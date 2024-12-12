상태를 정의할 때는 변수와 프로퍼티의 스코프를 최소화하는 것이 좋다.
- 프로퍼티보다는 지역 변수를 사용하는 것이 좋다.
- 최대한 좁은 스코프를 갖게 변수를 사용한다. 예를 들어 반복문 내부에서만 변수가 사용된다면, 변수를 반복문 내부에 작성하는 것이 좋다.

<br>

내부 스코프에서 외부 스코프에 있는 요소에만 접근할 수 있다.

```kotlin
val a = 1
fun fizz() {
    val b = 2
    print(a + b)
}
fun buzz = {
    val c = 3
    print(a + c)
}

// 이 위치에서는 a를 사용할 수 있지만, b와 c는 사용할 수 없다.
```

<br>

스코프를 좁게 만드는 것이 좋은 이유는 굉장히 많지만, 가장 중요한 이유는 프로그램을 추적하고 관리하기 쉽기 때문이다.  
또한 변수의 스코프 범위가 너무 넓으면, 다르 개발자에 의해서 변수가 잘못 사용될 수 있다.

```kotlin
// 나쁜 예
var user: User
for (i in users.indices) {
    user = users[i]
    print("User at $i is $user")
}

// 조금 더 좋은 예
for (i in users.indices) {
    val user = users[i]
    print("User at $i is $user")
}

// 제일 좋은 예
for ((i, user) in users.withIndex()) {
    print("User at $i is $user")
}
```

<br>

변수는 읽기 전용 또는 읽고 쓰기 전용 여부와 상관 없이, 변수를 정의할 때 초기화되는 것이 좋다.

```kotlin
// 나쁜 예
val user: User
if (hasValue) {
    user = getValue()
} else {
    user = User()
}

// 조금 더 좋은 예
val user: User = if (hasValue) {
    getValue()
} else {
    User()
}
```

<br>

여러 프로퍼티를 한꺼번에 설정해야 하는 경우에는 구조분해 선언을 활용하는 것이 좋다.

```kotlin
// 나쁜 예
fun updateWeather(degrees: Int) {
    val description: String
    val color: Int
    if (degrees < 5) {
        description = "cold"
        color = Color.BLUE
    } else if (degrees < 23) {
        description = "mild"
        color = Color.YELLOW
    } else {
        description = "hot"
        color = Color.RED
    }
    // ...
}

// 조금 더 좋은 예
fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 5 -> "cold" to Color.BLUE
        degrees < 23 -> "mild" to Color.YELLOW
        else -> "hot" to Color.RED
    }
}
```

## 캡처링

시퀀스 빌더를 사용해서 에라토스테네스의 체를 구현하면 다음과 같다.

```kotlin
val primes: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    while (true) {
        val prime = numbers.first()
        yield(prime)

        numbers = numbers.drop(1).filter { it % prime != 0 }
    }
}

print(primes.take(10).toList())
// [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
```

<br>

그런데 다음과 같이 최적화하려는 사람들이 항상 존재한다. 위의 코드와 다르게 prime을 var로 선언했으며, 반복문 내부에서 계속 생성하는 것이 아니라, 반복문에 진입하기 전에 한 번만 생성하는 형태이다.

```kotlin
val primes: Sequence<Int> = sequence {
    var numbers = generateSequence(2) { it + 1 }

    var pime: Int
    while (true) {
        prime = numbers.first()
        yield(prime)

        numbers = numbers.drop(1).filter { it % prime != 0 }
    }
}

print(primes.take(10).toList())
// [2, 3, 5, 6, 7, 8, 9, 10, 11, 12]
```

이러한 결과가 나온 이유는 prime이라는 변수를 캡처했기 때문이다. 반복문 내부에서 filter를 활용해서 prime으로 나눌 수 있는 숫자를 필터링한다.
그런데 시퀀스를 활용하므로 필터링이 지연된다. 따라서 최종적인 prime 값으로만 필터링된 것이다. prime이 2로 설정되어 있을 때 필터링된 4를 제외하면, drop만 동작하므로 그냥 연속된 숫자가 나와버린다.

## 정리

- 여러 가지 이유로 변수의 스코프는 좁게 만들어서 활용하는 것이 좋다.
- var보다는 val을 사용하느 것이 좋다.
- 람다에서 변수를 캡처한다.
