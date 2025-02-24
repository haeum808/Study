## CompositionLocal 이해하기

CompositionLocal은 컴포저블 계층 트리 상위에서 선언된 상태를 계층 트리 하위의 함수에서 이용하는 방법을 제공한다.  
그러나 기존과 같이 해당 상태가 선언된 함수와 상태를 이용하는 함수 사이에 있는 모든 컴포저블에 상태를 전달하지는 않는다.  

CompositionLocal을 이용하면 중간 자식 노드에 상태를 전달하지 않고도 트리의 가장 높은 노드에 선언되어 있는 데이터를 하위 노드에서 이용할 수 있다.  

## CompositionLocal 이용하기

CompositionLocal을 이용해 상태를 선언하려면 ProvidableCompositionalLocal 인스턴스를 생성해야 한다.  
이 인스턴스는 compositionLocalOf() 또는 staticCompositionLocalOf() 함수를 호출해서 얻을 수 있다.

```kotlin
val LocalColor = compositionLocalOf { Color.RED }
val LocalColor = staticCompositionLocalOf { Color.RED }
```

staticCompositionLocalOf() 함수는 자주 변경되지 않는 상탯값을 저장할 때 이용하는 것이 좋다.  
상탯값이 변경되면 해당 상태가 할당된 노드의 하위 노드를 모두 재구성해야 하기 때문이다.  

한편 compositionLocalOf() 함수는 현재 상태에 접근하는 컴포저블에 대해서만 재구성을 수행한다.  
이 함수는 변경이 잦은 상태를 다룰 때 이용해야 한다.  

ProvidableCompositionLocal 인스턴스에 값을 할당하고 해당 호출을 CompositionLocalProvider 호출의 바로 하위 자식 컴포저블로 전달한다.

```kotlin
val color = Color.Blue

CompistionalLocalProvider(LocalColor provides color) {
    Composable5()
}
```

이제 Compositional5의 모든 자손은 ProviderCompositionLocal 인스턴스의 현재 프로퍼티를 통해 CompositionalLocal 상태에 접근할 수 있다.

```kotlin
val background = LocalColor.current
```

## CompositionLocal 상태 추가하기

기기의 라이트 모드와 다크 모드에 따라 변경되는 color 상태를 선언하고, 이를 이용해 Composable8의 텍스트 컴포넌트 배경 색상을 제어하는 것이 목표다.  

```kotlin
val LocalColor = staticCompositionLocalOf { Color(0xFFffdbcf) }

@Composable
fun Composable1() {
    var color = if (isSystemInDarkTheme()) {
        Color(0xFFa08d87)
    } else {
        Color(0xFFffdbcf)
    }

    Column {
        Composable2()

        CompositionLocalProvider(LocalColor provides color) {
            Composable3()
        }
    }
}
```

## CompositionLocal 상태에 접근하기

```kotlin
@Composable
fun Composable8() {
    Text("Composable 8", modifier = Modifier.background(LocalColor.current))
}
```

## 디자인 테스트하기

라이트 모드와 다크 모드에서 액티비티 코드를 테스트하기 위해 MainActivity.kt 파일에 새로운 Preview 컴포저블을 추가하고,  
uiMode를 UI_NIGHT_MODE_YES로 설정한다.

```kotlin
@Preview(showBackground = true)
@Composable
fun LightPreview() {
    JetpackComposeEssentialsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Composable1()
        }
    }
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    JetpackComposeEssentialsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Composable1()
        }
    }
}
```


