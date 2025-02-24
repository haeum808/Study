## 프로젝트 개요

제목 하나, 진행 상태 인디케이터 하나, 체크박스 2개로 구성된다.  
2개의 체크박스는 제목 표시 형태 설정과 진행 상태 인디케이터 유형 설정 시 이용된다.

## MainScreen 컴포저블 만들기

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeEssentialsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var linearSelected by remember { mutableStateOf(true) }
    var imageSelected by remember { mutableStateOf(true) }
    val onLinearClick = { value: Boolean ->
        linearSelected = value
    }
    val onTitleClick = { value: Boolean ->
        imageSelected = value
    }
}
```

2개의 상태 변수를 선언했다. 이 변수들은 Checkbox 컴포넌트의 상태를 true로 설정한다.  
다음으로 이벤트 핸들러를 선언했다. 이 핸들러들은 사용자가 Checkbox 설정을 토글할 때 각 변수의 상태를 바꾼다.

## ScreenContent 컴포저블 추가하기

```kotlin
@Composable
fun ScreenContent(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onLinearClick: (Boolean) -> Unit,
    onTitleClick: (Boolean) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        
    }
}
```

ScreenContent 컴포저블은 화면 콘텐츠를 표시한다.  
화면은 제목, 진행 상태 인디케이터, 체크박스를 포함한다.

## Checkbox 컴포저블 만들기

```kotlin
@Composable
fun CheckBoxes(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onLinearClick: (Boolean) -> Unit,
    onTitleClick: (Boolean) -> Unit,
) {
    Row(
        Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = imageSelected,
            onCheckedChange = onTitleClick,
        )
        Text("Image Title")
        Spacer(Modifier.width(20.dp))
        Checkbox(
            checked = linearSelected,
            onCheckedChange = onLinearClick,
        )
        Text("Linear Progress")
    }
}

@Preview(showBackground = true)
@Composable
fun DemoPreview() {
    CheckBoxes(
        linearSelected = true,
        imageSelected = true,
        onLinearClick = {},
        onTitleClick = {},
    )
}
```

위의 미리 보기 함수에서 CheckBoxes 컴포저블을 호출하면 2개의 상태 프로퍼티에는 true를 설정하고, 이벤트 콜백에는 아무런 동작도 하지 않는 스텁 람다를 할당한다.

## ScreenContent Slot API 구현하기

ScreenContent 컴포저블 파일을 다음과 같이 수정한다.  
체크박스를 포함한 행을 포함해 ScreenContent에는 제목과 진행 상태 인디케이터를 위한 슬롯도 필요하다.

```kotlin
@Composable
fun ScreenContent(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onLinearClick: (Boolean) -> Unit,
    onTitleClick: (Boolean) -> Unit,
    titleContent: @Composable () -> Unit,
    progressContent: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        titleContent()
        progressContent()
        CheckBoxes(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onLinearClick = onLinearClick,
            onTitleClick = onTitleClick,
        )
    }
}
```

## TitleImage 컴포저블 만들기

표시할 이미지 리소스를 전달할 수 있게 디자인함으로써 이 컴포저블의 재사용성을 최대한으로 높인다.

```kotlin
@Composable
fun TitleImage(drawing: Int) {
    Image(
        painter = painterResource(drawing),
        contentDescription = "title image"
    )
}
```

## MainScreen 컴포저블 완료하기

MainScreen 컴포저블에 ScreenContent 함수를 호출하는 코드를 추가한다.

```kotlin
@Composable
fun MainScreen() {
    var linearSelected by remember { mutableStateOf(true) }
    var imageSelected by remember { mutableStateOf(true) }
    val onLinearClick = { value: Boolean ->
        linearSelected = value
    }
    val onTitleClick = { value: Boolean ->
        imageSelected = value
    }

    ScreenContent(
        linearSelected = linearSelected,
        imageSelected = imageSelected,
        onLinearClick = onLinearClick,
        onTitleClick = onTitleClick,
        titleContent = {
            if (imageSelected) {
                TitleImage(drawing = R.drawable.ic_baseline_cloud_download_24)
            } else {
                Text(
                    "Downloading",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(30.dp)
                )
            }
        },
        progressContent = {
            if (linearSelected) {
                LinearProgressIndicator(
                    Modifier.height(40.dp),
                )
            } else {
                CircularProgressIndicator(
                    Modifier.size(200.dp),
                    strokeWidth = 18.dp,
                )
            }
        },
    )
}
```
