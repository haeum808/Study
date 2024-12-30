## 구조화 프로그래밍의 탄생

1960년대 후반, '사람이 프로그램을 보다 편하게 쓰고 읽을 수 있도록 규칙을 만들자'는 흐름을 타고 '구조화 프로그래밍'이 태어났다.

## if가 탄생하기 전

### if는 왜 있는 걸까?

C언어 소스는 다음과 같다.

```C
int main() {
  int x = 123;
  /* if문 앞 */
  if(x == 456) {
    /* if문 안 */
  }
  /* if문 뒤 */
}
```

컴파일하면 다음과 같은 어셈블리어 코드가 출력된다.

```
_main:
        ....
        movl    $123, -8(%rbp) // 1
        # if문 앞
        movl    -8(%rbp). $eax // 2
        cmpl    $456, %eax
        jne     LBB1_2
        # if문 안               // 3
LBB1_2:
        # if문 뒤
        ....

# movl - move long integer
# cmpl - compare long integer
# jne - jump if not equal
```

1에서는 x에 수치 123을 대입하고 있다.  
2에서는 x의 값을 %eax라는 임시 저장 장소에 이동 후 수치 456과 비교한다.  
3에서는 '바로 직전 비교에서 양쪽이 동일하지 않으면 LBB1_2로 점프하라는 명령이다'  
4가 if문 안쪽 코드로 양쪽이 동일할 때만 실행된다. 동일하지 않으면 LBB1_2로 점프하기 때문에 4는 실행되지 않는다.

### if-else는 왜 있는 걸까?

#### 어셈블리어의 표현 방법

우선은 else를 사용하는 코드를 C언어로 구현해보고 그것을 어셈블리어로 컴파일해본다.

```C
/* if문 앞 */
if(x > 0) { q
  /* 플러스일 경우 처리 */
} else if(x < 0) {
  /* 마이너스 일 경우 처리 */
} else {
  /* 0일 경우 처리 */
}
/* if문 뒤 */
```

컴파일한 것이 다음 코드다.

```
_main:
        ....
        # if문 앞
        movl    -8(%rbp), %eax  // 1
        cmpl    $0, %eax        // 1
        jle     LBB1_2          // 1
        # 플러스일 경우 처리        // 2
        jmp     LBB1_5          // 3
LBB1_2:                         // 4 // 5
        movl    -8(%rbp), %eax  // 5
        cmpl    $0, %eax        // 5
        jge     LBB1_4          // 5
        # 마이너스일 경우 처리       // 6
        jmp     LBB1_5          // 7 // 10
LBB1_4:                         // 8 // 10
        # 0일 경우 처리            // 9 // 10
LBB1_5:                         // 11
        # if문 뒤
        
# jle는 jump if less or equal의 약어로 '0 이하이면 점프'라는 의미다.  
# jge는 그 반대로, jump if greater or equal이다.
# jmp는 jump의 약어로 무조건 점프한다.
```

1은 'x가 0 이하이면 LBB1_2로 점프'  
2는 플러스일 경우의 처리  
3은 'LBB1_5'로 점프'이다.  
5는 'x가 0이상이면 LBB1_4'로 점프  
6이 마이너스일 경우의 처리  
7은 'LBB1_5'로 점프이다.  
10이 0일 경우의 처리다.  

#### C 언어의 표현 방법

C 언어에서도 '지정한 행으로 점프하기 위한 명령'을 사용하면 else를 사용하지 않고 코드를 쓸 수 있다.

```C
void not_use_if(int x) {
  if(x <= 0) goto NOT_POSITIVE;
  printf("플러스 숫자\n");
  goto END;
NOT_POSITIVE:
  if(x >= 0) goto NOT_NEGATIVE;
  printf("마이너스 숫자\n");
  goto END;
NOT_NEGATIVE:
  printf("제로 \n");
END:
  return;
}
```

#### if-else 사용의 장점

if-else를 사용한 코드와 비교해보자. 어느 쪽이 알기 쉬운가?

```C
void use_if(int x){
  if(x > 0){
    printf("플러스 숫자\n");
  }else if(x < 0){
    printf("마이너스 숫자\n");
  }else{
    printf("제로\n");
  }
}
```

'조건이 참인 경우와 거짓인 경우의 처리 흐름을 분배한다'는 패턴은 프로그래밍에 빈번히 사용된다.  
이것을 간단하가 읽기 쉬운 형태로 쓰기 위해 if-else 구문이 세롭게 도입된 것이다.

## while, 반복되는 if를 읽기 쉽게 표현

while 문은 '조건을 만족하고 있는 동안 블록 안의 내용을 반복하여 실행'하는 구문이다.

### while 문을 사용하는 방법

다음 코드는 조 x > 0을 만족하고 있는 동안 'x를 표시하고 x에서 1을 뺀다'는 처리를 반복한다.

```C
void use_while(int x){
  printf("use_while\n");
  while(x > 0){
    printf("%d\n", x);
    x--;
  }
}
```

### while 문을 사용하지 않는 방법

다음 코드는 '조건을 만족하지 않으면 END_LOOP'에 점프, 'x를 표시하고 x에서 1을 뺀다', '조건문 직전으로 점프한다'는 내용이다.

```C
void not_use_while(int x){
  printf("not_use_while\n");
 START_LOOP:
  if(!(x > 0)) goto END_LOOP;
  printf("%d\n", x);
  x--;
  goto START_LOOP;
 END_LOOP:
  return;
}
```

break문은 goto END_LOOP와 같은 동작이다.  

while문이 가져온 편리함은 '새로운 것'이 아니라, '읽기 쉽게함', '쓰기 쉽게 함'인 것이다.  

if-else나 while, break는 '제한이 붙은 goto'라고 생각하면 된다.

## for, 수치를 증가시키는 while을 읽기 쉽게 표현

for 문으로 할 수 있는 것은 while문으로도 가능하다.

### for를 사용하는 방법

다음은 i를 0이상 N 미만의 범위에서 1씩 증가시키며 표시하는 코드다.

```C
for(i = 0; i < N; i++){
    printf("%d\n", i);
}
```

### for를 사용하지 않는 방법

동일한 내용을 while문을 사용해서 표현하면 다음과 같다.

```c
i = 0;
while(i < N){
    printf("%d\n", i);
    i++;
}
```

for문을 사용하면 한 곳에 모두 정리가 되기 때문에 루프의 의도를 쉽게 이해할 수 있다.

'시작값, 증가값, 종료값' 3 가지를 함께 표현하는 for문은 1958년에 만들어진 ALGOL 58에서 이미 발명된 것이다.

### foreach, 처리 대상으로 반복 제어

while은 조건식으로 반복을 제어한다.  
for문은 횟수로 반복을 제어한다. (엄밀히 말하면 for문에서도 조건식으로 제어하고 있지만, 주요 사용 목적은 횟수를 의식한 제어다.)  
foreach 구문은 처리 대상으로 반복을 제어한다.  

foreach 구문은 '어떤 대상의 요소 전부에 어떤 처리를 한다'는 코드를 쉽게 쓰기 위해 만들어졌다.

```
// 배열
int[] items = new int[]{1, 2, 3, 4, 5};

// 일반 for문으로 각 요소를 출력
for(int i = 0; i < items.length; i++){
    int item = items[i];
    System.out.println(item);
}

// 확장 for문으로 각 요소를 출력
for(int item: items){
    System.out.println(item);
}
```

foreach 구문을 사용하면 'items의 각 요소를 표시'라고 간단하게 쓰고 있다.

## 정리

if문, while문, for문을 사용하지 않아도 프로그램을 짤 수 있다.  
그러나 사용하는 것이 보다 알기 쉬운 코드를 구성할 수 있다.  
알기 쉬운 코드를 만들기 위해서 적극적으로 사용하도록 하자.
