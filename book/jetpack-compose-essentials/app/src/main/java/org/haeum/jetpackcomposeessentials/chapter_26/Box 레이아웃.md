## Box 컴포저블

Row와 Column이 자식들을 수평의 행 또는 수직의 열로 구조화하는 것과 달리 Box 레이아웃은 자식들을 위로 쌓아 올린다.  
첫 번째로 호출된 자식은 스택의 가장 아래에 위치한다.

## TextCell 컴포저블 추가하기

```kotlin
@Composable
fun TextCell(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 150,
) {
    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 5.dp, color = Color.Black)
    
    Text(
        text = text,
        cellModifier.then(modifier),
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}
```

## Box 레이아웃 추가하기

Box 레이아웃은 3개의 TextCell 자식을 포함한다.

```kotlin
@Composable
fun MainScreen() {
    Box { 
        val height = 200.dp
        val width = 200.dp
        
        TextCell("1", Modifier.size(width = width, height = height))
        TextCell("2", Modifier.size(width = width, height = height))
        TextCell("3", Modifier.size(width = width, height = height))
    }
}
```

Text 컴포저블은 기본적으로 투명하므로 3개의 자식이 위로 쌓인 것을 볼 수 있다.  
TextCell의 배경을 불투명하게 하려면 Surface 컴포넌트 안에서 Text 컴포저블을 호출해야 한다.  
TextCell 함수를 다음과 같이 수정한다.

```kotlin
@Composable
fun TextCell(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 150,
) {
    Surface {
        val cellModifier = Modifier
            .padding(4.dp)
            .border(width = 5.dp, color = Color.Black)

        Text(
            text = text,
            cellModifier.then(modifier),
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}
```

## Box 정렬

Box 컴포저블은 하나의 정렬 파라미터를 제공하며, 이를 이용하면 박스의 콘텐츠 영역 안에 있는 자식 그룹의 위치를 커스터마이즈할 수 있다.  
파라미터의 이름은 contentAlignment이며 다음과 같은 값을 지정할 수 있다.
- Alignment.TopStart
- Alignment.TopCenter
- Alignment.TopEnd
- Alignment.CenterStart
- Alignment.Center
- Alignment.CenterEnd
- Alignment.BottomCenter
- Alignment.BottomEnd
- Alignment.BottomStart

크기를 늘리고 contentAlignment 파라미터를 추가한다.

```kotlin
@Composable
fun MainScreen() {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.size(400.dp, 400.dp),
    ) {
        val height = 200.dp
        val width = 200.dp

        TextCell("1", Modifier.size(width = width, height = height))
        TextCell("2", Modifier.size(width = width, height = height))
        TextCell("3", Modifier.size(width = width, height = height))
    }
}
```

## BoxScope 모디파이어

Box 레이아웃에서는 다음 BoxScope 모디파이어를 자식 컴포저블에 적용할 수 있다.
- align(): Box 콘텐츠 영역 안의 자식을 정렬한다. 지정한 Alignment 값을 이용한다.
- matchParentSize(): 모디파이어가 적용된 자식의 크기를 부모 Box의 크기에 맞춘다.

```kotlin
@Composable
fun MainScreen() {
    Box(
        modifier = Modifier.size(90.dp, 290.dp),
    ) {
        Text("TopStart", Modifier.align(Alignment.TopStart))
        Text("TopCenter", Modifier.align(Alignment.TopCenter))
        Text("TopEnd", Modifier.align(Alignment.TopEnd))

        Text("CenterStart", Modifier.align(Alignment.CenterStart))
        Text("Center", Modifier.align(Alignment.Center))
        Text("CenterEnd", Modifier.align(Alignment.CenterEnd))

        Text("BottomStart", Modifier.align(Alignment.BottomStart))
        Text("BottomCenter", Modifier.align(Alignment.BottomCenter))
        Text("BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
}
```

## clip() 모디파이어 이용하기

Box에만 지정할 수 있는 것은 아니지만, 아마도 Box 컴포넌트가 형태를 자르는 것을 보여주기에 가장 좋은 예시다.  
컴포저블의 형태를 정의할 때는 clip() 모디파이어를 호출하고 Shape 값을 전달한다.  
Shape의 값에는 RectangleShape, CircleShape, RounderCornerShape, CutCornerShape를 이용할 수 있다.

```kotlin
import android.view.RoundedCorner

Box(Modifier.size(200.dp).clip(CircleShape).background(Color.Black))
Box(Modifier.size(200.dp).clip(RoundedCorner(30.dp)).background(Color.Black))
Box(Modifier.size(200.dp).clip(CutCornerShape(30.dp)).background(Color.Black))
```
