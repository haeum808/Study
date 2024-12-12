
```kotlin
var a = 10
var list: 
```

요소가 상태를 갖는 경우, 해당 요소의 동작은 사용 방법뿐만 아니라 그 이력에도 의존하게 된다.

```kotlin
class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @Throws(InsufficentFunds::class)
    fun withdraw(withdrawAmount: Double) {
        if (balance < withdrawAmount) {
            throw InsufficentFunds()
        }
        balance -= withdrawAmount
    }
}

class InsufficientFunds : Exception()
val account = BankAccount()
pritnln(account.balance) // 0.0
account.deposit(100.0)
println(accout.balance) // 100.0
account.withdraw(50.0)
println(account.balance) // 50.0
```

시간의 변화에 따라서 변하는 요소를 표현할 수 있다는 것은 유용하지만, 상태를 적절하게 관리하는 것이 생각보다 어렵다.  
1. 프로그램을 이해하고 디버그하기 힘들어진다.
2. 가변성이 있으면, 코드의 실행을 추론하기 어려워진다.
3. 멀티스레드 프로그램일 때는 적절한 동기화가 필요하다.
4. 테스트하기 어렵다.
5. 상태 변경이 일어날 때, 이러한 변경은 다른 부분에 알려야 하는 경우가 있다.

다음 코드는 멀티스레드를 활용해서 프로퍼티를 수정한다. 이때 충돌에 의해서 일부 연산이 이루어지지 않는다.

```kotlin
var num = 0
for (i in 1..1000) {
    thread {
        Thread.sleep(10)
        num += 1
    }
}
Thread.sleep(5000)
print(num) // 1000이 아닐 확률이 매우 높다.
```

일부 연산이 충돌되어 사라지므로 적절하게 추가로 동기화를 구현해야 한다. 
동기화를 잘 구현하는 것은 굉장히 어려운 일이다. 따라서 변할 수 있는 지점은 줄일수록 좋다.

```kotlin
val lock = Any()
var num = 0
for (i in 1..1000) {
    thread {
        Thread.sleep(10)
        synchronized(lock) {
            num += 1
        }
    }
}
Thread.sleep(1000)
print(num) // 1000
```

가변성은 시스템의 상태를 나타내기 위한 중요한 방법이다. 하지만 변경이 일어나야 하는 부분을 신중하고 확실하게 결정하고 사용해야 한다.

## 코틀린에서 가변성 제한하기

코틀린은 가변성을 제한할 수 있게 설계되어 있다.
- 읽기 전용 프로퍼티(val)
- 가변 컬렉션과 읽기 전용 컬렉션 구분하기
- 데이터 클래스의 copy


### 읽기 전용 프로퍼티(val)

```kotlin
val a = 10
a = 20 // 오류
```

이렇게 선언된 프로퍼티는 마치 값(value)처럼 동작하며, 일반적인 방법으로는 값이 변하지 않는다.

<br>

```kotlin
val list = mutableListOf(1, 2, 3)
list.add(4)

print(list) // [1, 2, 3, 4]
```

읽기 전용 프로퍼티가 mutable 객체를 담고 있다면, 내부적으로 변할 수 있다.

<br>

```kotlin
var name: String = "Marcin"
var surname: String = "Moskala"
val fullName
    get() = "$name $surname"

fun main() {
    println(fullName) // Marcin Moskala
    name = "Maja"
    println(fullName) // Maja Moskala
}
```

var 프로퍼티를 사용하는 val 프로퍼티는 var 프로퍼티가 변할 때 변할 수 있다.
값을 추출할 때마다 사용자 정의 게터가 호출된다.

<br>

```kotlin
fun calculate(): Int {
    print("Calculating... ")
    return 42
}

val fizz = calculate() // 계산합니다...
val buzz
    get() = calculate()

fun main() {
    print(fizz) // 42
    print(fizz) // 42
    print(buzz) // 계산합니다... 42
    print(buzz) // 계산합니다... 42
}
```

코틀린의 프로퍼티는 기본적으로 캡슐화되어 있고, 추가적으로 사용자 정의 접근자(게터, 세터)를 가질 수 있다.

<br>

```kotlin
interface Element {
    val active: Boolean
}

class ActualElement: Element {
    override var active: Boolean = false
}
```

var은 게터와 세터를 모두 제공하지만, val은 변경이 불가능하므로 게터만 제공한다. 그래서 val을 var로 오버라이드할 수 있다.

<br>

```kotlin
val name: String? = "Marton"
val surname: String = "Braun"

val fullName: String?
    get() = name?.let { "$it $surname" }

val fullName2: String? = name?.let { "$it $surname" }

fun main() {
    if (fullName != null) {
        println(fullName.length) // 오류
    }

    if (fullName != null) {
        println(fullName2.length) // Marton Braun
    }
}
```

val은 읽기 전용 프로퍼티지만, 변경할 수 없음을 의미하는 것은 아니다. val은 정의 옆에 상태가 바로 직히므로, 코드의 실행을 예측하는 것이 훨씬 간단하다. 또한 스마트 캐스트 등의 추가적인 기능을 활용할 수 있다.  
fullName은 게터로 정의했으므로 스마트 캐스트할 수 없다. 게터를 활용하므로, 값을 사용하는 시점의 name에 따라서 다른 결과가 나올 수 있기 때문이다.

### 가변 컬렉션과 읽기 전용 컬렉션 구분하기

코틀린은 읽고 쓸 수 있는 컬렉션과 읽기 전용 컬렉션으로 구분된다.

Iterable, Collection, Set, List 인터페이스는 읽기 전용이다.  
변경을 위한 메서드를 따로 가지지 않는다.  

MutableIterable, MutableCollection, MutableSet, MutableList 인터페이스는 읽고 쓸 수 있는 컬렉션이다.  
mutable이 붙은 인터페이스는 대응되는 읽기 전용 인터페이스를 상속 받아서, 변경을 위한 메서드를 추가한 것이다.

<br>

개발자가 '시스템 해킹'을 시도해서 다운캐스팅을 할 때 문제가 된다.  
리스트를 읽기 전용으로 리턴하면, 이를 읽기 전용으로만 사용해야 한다.  
컬렉션 다운캐스팅은 이러한 계약을 위반하고, 추상화를 무시하는 행위이다.

```kotlin
val list = listOf(1, 2, 3)

// 이렇게 하지 마세요!
if (list is MutableList) {
    list.add(4)
}
```

<br>

읽기 전용에서 mutable로 변경해야 한다면, 복제를 통해서 새로운 mutable 컬렉션을 만드는 list.toMutableList를 활용해야 한다.

```kotlin
val list = listOf(1, 2, 3)

val mutableListOf = list.toMutableList()
mutableList.add(4)
```

이렇게 코드를 작성하면 어떠한 규약도 어기지 않을 수 있으며, 기존의 객체는 여전히 immutable이라 수정할 수 없으므로, 안전하다고 할 수 있다.

### 데이터 클래스의 copy

immutable 객체를 사용하면, 다음과 같은 장점이 있다.  
1. 한 번 정의된 상태가 유지되므로, 코드를 이해하기 쉽다.
2. immutable 객체는 공유했을 때도 충돌이 따로 이루어지지 않으므로, 병렬 처리를 안전하게 할 수 있다.
3. immutable 객체에 대한 참조는 변경되지 않으므로, 쉽게 캐시할 수 있다.
4. immutable 객체는 방어적 복사본을 만들 필요가 없다. 또한 객체를 복사할 때 깊은 복사를 따로 하지 않아도 된다.
5. immutable 객체는 다른 객체를 만들 때 활용하기 좋다. 또한 immutable 객체는 실행을 더 쉽게 예측할 수 있다.
6. immutable 객체는 '세트' 또는 '맵의 키'로 사용할 수 있다. mutable 객체는 이러한 것으로 사용할 수 없다. 세트와 맵이 내부적으로 해시 테이블을 사용하고, 해시 테이블은 처음 요소를 넣을 때 요소의 값을 기반으로 버킷을 결정하기 때문이다. 따라서 요소에 수정이 일어나면 해시 테이블 내부에서 요소를 찾을 수 없게 되어 버린다.

```kotlin
val names: SortedSet<FullName> = TreeSet()
val person = FullName("AAA", "AAA")
names.add(person)
names.add(FullName("Jordan", "Hansen"))
names.add(FullName("David", "Blanc"))

print(names) // [AAA AAA, David Blanc, Jordan Hansen]
print(person in names) // true

person.name = "ZZZ"
print(names) // [ZZZ AAA, David Blanc, Jordan Hansen]
print(person in names) // false
```

<br>

Int -> plus, minus  
Iterable -> map, filter

data 한정자는 copy라는 이름의 메서드를 만들어주낟. copy 메서드를 활용하면, 모든 기본 생성자 프로퍼티가 같은 새로운 객체를 만들어 낼 수 있다.

```kotlin
data class User(
    val name: String,
    val surname: String
)

var user = User("Maja", "Markiewicz")
user = user.copy(surname = "Moskala")
print(user) // User(name=Maja, surname=Moskala)
```

## 다른 종류의 변경 가능 지점

변경할 수 있는 리스트 만드는 법  
1. mutable 컬렉션 만들기
2. var로 읽고 쓸 수 있는 프로퍼티 만들기

```kotlin
val list1: MutableList<Int> = mutableListOf()
var list2: List<Int> = listOf()

list1.add(1)
list2 = list2 + 1

list1 += 1 // list1.plusAssign(1)로 변경된다.
list2 += 1 // list2.plus(1)로 변경된다.
```

두 가지 모두 변경 가능 지점이 있지만, 그 위치가 다르다.  
첫 번째 코드는 구체적인 리스트 구현 내부에 변경 가능 지점이 있다.  
두 번째 코드는 프로퍼티 자체가 변경 가능 지점이다.

<br>

mutable 리스트 대신 mutable 프로퍼티를 사용하는 형태는 사용자 정의 세터를 활용해서 변경을 추적할 수 있다.

<br>

mutable 컬렉션을 사용하는 것이 처음에는 더 간단하게 느껴지겠지만, mutable 프로퍼티를 사용하면 객체 변경을 제어하기가 더 쉽다.

## 변경 가능 지점 노출하지 말기

상태를 나타내는 mutable 객체를 외부에 노출하는 것은 굉장히 위험하다.

```kotlin
data class User(val name: String)

class UserRepository {
    private val storedUsers: MutableMap<Int, String> = 
        mutableMapOf()
    
    fun loadAll(): MutableMap<Int, String> {
        return storedUsers
    }
    //...
}
```

loadAll을 사용해서 private 상태인 UserRepository를 수정할 수 있다.

```kotlin
val userRepository = userRepository.loadAll()
storedUsers[4] = "Kirll"
//...

print(userRepository.loadAll()) // {4=Kirll}
```

이러한 코드는 돌발적인 수정이 일어날 때 위험할 수 있다.  

이를 처리하는 방법은 두 가지이다.  
1. 리턴되는 mutable 객체를 복제한다. 이를 방어적 복제라고 부른다.

```kotlin
class UserHolder {
    private val user: MutableUser()

    fun get(): MutableUser {
        return user.copy()
    }

    //...
}
```

2. 컬렉션은 객체를 읽기 전용 슈퍼타입으로 업캐스트하여 가변성을 제한할 수도 있다.

```kotlin
data class User(val name: String)

class UserRepository {
    private val storedUsers: MutableMap<Int, String> =
        mutableMapOf()

    fun loadAll(): Map<Int, String> {
        return storedUsers
    }

    //...
}
```

## 정리

- var보다는 val을 사용하는 것이 좋다.
- mutable 프로퍼티보다는 immutable 프로퍼티를 사용하는 것이 좋다.
- mutable 객체와 클래스보다는 immutable 객체와 클래스를 사용하는 것이 좋다.
- 변경이 필요한 대상을 만들어야 한다면, immutable 데이터 클래스로 만들고 copy를 활용하는 것이 좋다.
- 컬렉션에 상태를 저장해야 한다면, mutable 컬렉션보다는 읽기 전용 컬렉션을 사용하는 것이 좋다.
- 변이 지점을 적절하게 설계하고, 불필요한 변이 지점은 만들지 않는 것이 좋다.
- mutable 객체를 외부에 노출하지 않는 것이 좋다.
