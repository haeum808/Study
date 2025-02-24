## Slot API 이해하기

특정한 컴포저블이 호출되기 전까지는 어떤 컴포저블이 중간에 표시될지 모르는 상황을 가정해보자.  
문제를 해결하려면 함수가 호출될 때 중간 컴포저블을 다른 컴포저블로 배치할 수 있는 슬롯으로 열어두어야 한다.  
이를 해당 컴포저블에 대한 Slot API를 제공한다고 부른다.  
하나의 컴포저블 함수는 호출자에게 여러 슬롯을 제공할 수 있다.

## Slot API 선언하기

컴포저블에 슬롯을 추가할 때는 먼저 슬롯을 파라미터로 받을 수 있도록 지정한다.  
이것은 컴포저블이 다른 컴포저블을 파라미터로 받도록 선언하는 것과 본질적으로 동일하다.

```kotlin
@Composable
fun SlotDemo(middleContent: @Composable () -> Unit) {
    Column {
        Text("Top text")
        middleContent()
        Text("Bottom text")
    }
}
```

## Slot API 컴포저블 호출하기

```kotlin
SlotDemo(middleContent = { ButtonDemo() })

@Composable
fun ButtonDemo() {
    Button(onClick = {}) {
        Text("Click me")
    }
}
```

좀 더 명확한 구문은 다음과 같다.

```kotlin
SlotDemo { ButtonDemo() }
```

슬롯마다 별도의 Slot API를 이용해야만 하는 것은 아니다. SlotDemo 예시는 다음과 같이 슬롯으로 구성할 수도 있다.

```kotlin
@Composable
fun SlotDemo(
    topContent: @Composable () -> Unit,
    middleContent: @Composable () -> Unit,
    bottomContent: @Composable () -> Unit,
) {
    Column {
        topContent()
        middleContent()
        bottomContent()
    }
}
```
