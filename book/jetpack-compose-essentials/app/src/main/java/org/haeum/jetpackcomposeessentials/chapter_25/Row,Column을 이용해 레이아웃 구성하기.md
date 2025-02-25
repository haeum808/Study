## RowColDemo 프로젝트 만들기

커스텀 컴포넌트인 TextCell의 인스턴스를 이용해 행/열 기반 레이아웃을 구현한다.

```kotlin
@Composable
fun MainScreen() {

}

@Composable
fun TextCell(
    text: String,
    modifier: Modifier = Modifier,
) {
    val cellModifier = Modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Black)

    Text(
        text = text,
        cellModifier.then(modifier),
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}
```

## Row 컴포저블

Row 컴포저블은 이름 그대로 자식 컴포넌트를 화면의 수평 방향으로 배열한다.

```kotlin
@Composable
fun MainScreen() {
    Row { 
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }
}
```

## Column 컴포저블

Column 컴포저블은 Row 컴포저블과 동일한 목적을 수행하지만, 자식들을 수직 방향으로 배열한다는 점이 다르다.

```kotlin
@Composable
fun MainScreen() {
    Column { 
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }
}
```

## Row, Column 컴포저블 조합하기

Row, Column 컴포저블을 조합해 표 스타일의 레이아웃을 만들 수 있다.

```kotlin
@Composable
fun MainScreen() {
    Column {
        Row {
            Column {
                TextCell("1")
                TextCell("2")
                TextCell("3")
            }

            Column {
                TextCell("4")
                TextCell("5")
                TextCell("6")
            }

            Column {
                TextCell("7")
                TextCell("8")
            }
        }

        Row {
            TextCell("9")
            TextCell("10")
            TextCell("11")
        }
    }
}
```

Row, Column 레이아웃이 서롬 포함하도록 하면 어떤 복잡한 레이아웃이라도 구성할 수 있다.

## 레이아웃 정렬

Row, Column 컴포저블은 모두 사용자 인터페이스 레이아웃 안의 공간을 차지한다.  
차지하는 공간은 자식 요소, 다른 컴포저블, 크기 관련 설정을 적용하는 모디파이어들에 따라 달라진다.  
기본적으로 Row와 Column 내부의 자식 요소 그룹들은 콘텐츠 영역의 가장 왼쪽 위 모서리를 기준으로 정렬된다.

```kotlin
import org.w3c.dom.Text

@Composable
fun MainScreen() {
    Row(modifier = Modifier.size(width = 400.dp, height = 200.dp)) {
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }
}
```

위 변경을 적용하기 전 Row는 그 자식들을 감싸고 있다.  

수직 방향 축의 기본 정렬은 Row 컴포저블의 verticalAlignment 파라미터에 값을 전달해서 변경할 수 있다.

```kotlin
@Composable
fun MainScreen() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.size(width = 400.dp, height = 200.dp)
    ) {
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }
}
```

콘텐츠는 Row 영역에서 수직 방향 중앙에 위치하게 된다.  

Row의 수직 방향 정렬 파라미터로 전달할 수 있는 값은 다음과 같다.
- Alignment.Top: 콘텐츠를 Row 콘텐츠 영역의 수직 방향 위 위치에 정렬한다.
- Alignment.CenterVertically: 콘첸트를 Row 콘텐츠 영역의 수직 방향 가운데 위치에 정렬한다.
- Alignment.Bottom: 콘텐츠를 Row 콘텐츠 영역의 수직 방향 아래 위치에 정렬한다.

Column 컴포저블을 이용할 때는 horizontalAlignment 파라미터를 이용해 수평축 방향의 정렬을 설정할 수 있으며, 다음과 같은 값을 전달할 수 있다.
- Alignment.Start: 콘텐츠를 Column 콘텐츠 영역의 수평 방향 시작 위치에 정렬한다.
- Alignment.CenterHorizontally: 콘텐츠를 Column 콘텐츠 영역의 수평 방향 가운데 위치에 정렬한다.
- Alignment.End: 콘텐츠를 Column 콘텐츠 영역의 수평 방향 끝 위치에 정렬한다.

정렬을 다룰 때는 컴포저블을 포함하는 흐름과 반대 축 기준으로 동작한다.  
Row를 이용해 자식을 수평으로 구조화한다면 정렬은 수직축에서 수행해야 한다.  
반대로 Column 컴포저블의 수평축으로 정렬한다면 자식들은 수직 방향으로 배열된다.

## 레이아웃 배열 위치 조정하기

정렬과 달리 배열은 자식의 위치를 컨테이너와 동일 축을 따라 제어한다.  
Row 인스턴스에서는 horizontalArrangement, Column 인스턴스에서는 verticalArrangement를 각각 이용해서 배열값을 설정한다.  

다음은 Row 컴포넌트에서 이용할 수 있는 horizontalArrangement 파라미터다.
- Arrangement.Start: 콘텐츠를 Row 콘텐츠 영역의 수평 방향 시작 위치에 정렬한다.
- Arrangement.Center: 콘텐츠를 Row 콘텐츠 영역의 수평 방향 가운데 위치에 정렬한다.
- Arrangement.End: 콘텐츠를 Row 콘텐츠 영역의 수평 방향 끝 위치에 정렬한다.

다음은 Column 컴포저블에서 이용할 수 있는 verticalArrangement 파라미터다.
- Arrangement.Top: 콘텐츠를 Column 콘텐츠 영역의 수직 방향 위 위치에 정렬한다.
- Arrangement.Center: 콘텐츠를 Column 콘텐츠 영역의 수직 방향 가운데 위치에 정렬한다.
- Arrangement.Bottom: 콘텐츠를 Column 콘텐츠 영역의 수직 방향 아래 위치에 정렬한다.

## 레이아웃 배열 간격 조정하기

배열 간격 조정을 이용해 Row 또는 Column 안의 자식 컴포넌트들의 콘텐츠 영역 안에서 간격을 조정한다.  
다음 값 중 하나를 이용해야 한다.
- Arrangement.SpaceEvenly: 자식들은 균일한 간격을 유지한다. 첫 번째 자식의 앞, 마지막 자식의 뒤 공간을 포함한다.
- Arrangement.SpaceBetween: 자식들은 균일한 간격을 유지한다. 첫 번째 자식의 앞, 마지막 자식의 뒤 공간을 포함하지 않는다.
- Arrangement.SpaceAround: 자식들은 균일한 간격을 유지한다. 첫 번째 자식의 앞, 마지막 자식의 뒤 공간은 각 자식들 사이 공간의 절반이다.

## Row, Column 스코프 모디파이어

흔히들 Row 또는 Column의 자식들의 부모의 스코프 안에 있다고 말한다.  
이 두 스코프는 추가 모디파이어 함수들을 제공하며, 이를 이용해 Row 또는 Column 안에 포함된 각 자식들의 동작이나 형태를 변경할 수 있다.  

ColumnScope는 다음 모디파이어를 제공하며, 이를 이용해 자식 컴포넌트들의 위치를 제어할 수 있다.
- Modifier.align(): Alignment.CenterHorizontally, Alignment.Start, Alignment.End 값을 이용해 자식들을 수평으로 정렬한다.
- Modifier.alignBy(): 자식들과 alignBy() 모디파이어가 적용된 다른 형제를 수평으로 정렬한다.
- Modifier.weight(): 형제에 할당된 가중치에 따라 자식의 높이를 설정한다.

RowScope는 Row 자식들이 이용할 수 있는 다음 모디파이어를 제공한다.
- Modigier.align(): Alignment.CenterVertically, Alignment.Top, Alignment.Bottom 값을 이용해 자식들을 수직으로 정렬한다.
- Modifier.alignBy(): 자식들과 alignBy() 모디파이어가 적용된 다른 형제들과 정렬한다. 정렬은 베이스 라인 또는 커스텀 정렬 라인 설정에 따라 수행할 수 있다.
- Modifier.alignByBaseline(): 자식의 베이스라인을 alignBy() 또는 alignByBaseline() 모디파이어가 이미 적용된 형제들과 정렬한다.
- Modifier.paddingFrom(): 자식의 정렬 라인에 패딩을 추가한다.
- Modifier.weight(): 형제에 할당된 가중치에 따라 자식의 폭을 설정한다.

베이스라인 정렬 옵션은 글꼴 크기가 다른 텍스트 콘텐츠들을 정렬할 때 특히 유용하다.

```kotlin
import java.lang.reflect.Modifier

Row {
    Text(
        text = "Large Text",
        Modifier.alignByBaseline(),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
    )

    Text(
        text = "Small Text",
        Modifier.alignByBaseline(),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
    )
}
```

또는 alignByBaseline() 모디파이러를 alignBy() 함수 호출로 변경할 수도 있다. 이때는 정렬 파라미터에 FirstBaseline을 전덜한다.

```kotlin
Modifier.alignBy(FirstBaseline)
```

여러 줄의 텍스트를 다룰 때는 LastBaseline을 alignBy() 모디파이어 함수에 전달하면 형제 컴포넌트들을 마지막 텍스트의 베이스라인에 맞춰 정렬할 수 있다.

```kotlin
@Composable
fun MainScreen() {
    Row {
        Text(
            text = "Large Text\nMore Text",
            Modifier.alignBy(LastBaseline),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Small Text",
            Modifier.alignByBaseline(),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
```

위의 코드를 렌더링해 보면 두 번째 자식의 텍스트 콘텐츠 베이스라인이 첫 번째 자식의 텍스트 마지막 행 베이스라인에 맞춰 정렬되었음을 확인할 수 있다.  
위의 코드에서 FirstBaseline을 이용하면 작은 텍스트 컴포저블의 베이스라인을 멀티라인 컴포넌트 텍스트의 첫 번째 행의 베이스라인에 맞춰 정렬한다.  

특정 자식의 정렬에 오프셋을 적용할 때는 paddingForm() 모디파이어를 이용할 수 있다.  

```kotlin
@Composable
fun MainScreen() {
    Row {
        Text(
            text = "Large Text\nMore Text",
            Modifier.alignBy(LastBaseline),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Small Text",
            Modifier.paddingFrom(
                alignmentLine = FirstBaseline,
                before = 80.dp,
                after = 0.dp,
            ),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
```

## 스코프 모디파이어 가중치

RowScope 가중치 모디파이어를 이용하면 각 자식의 폭을 그 형제들을 기준으로 상대적으로 지정할 수 있다.

```kotlin
@Composable
fun MainScreen() {
    Row {
        TextCall("1", Modifier.weight(weight = 0.2f, fill = true))
        TextCall("2", Modifier.weight(weight = 0.4f, fill = true))
        TextCall("3", Modifier.weight(weight = 0.3f, fill = true))
    }
}
```

가중치 모디파이어가 적용되지 않은 형제 요소들은 원하는 크기로 표시되며, 적용된 자식들이 나머지 공간을 공유한다.  
ColumnScope도 align(), alignBy(), weight() 모디파이어를 제공하며 이들은 모두 수평축에서 동작한다.  
RowScope와 달리 ColumnScope에는 베이스라인 개념이 존재하지 않는다.
