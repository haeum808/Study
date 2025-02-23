package org.haeum.jetpackcomposeessentials.chapter_20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.haeum.jetpackcomposeessentials.ui.theme.JetpackComposeEssentialsTheme

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
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {
    MyTextField()
}

@Composable
fun MyTextField() {
    val textState = remember { mutableStateOf("") }
    val onTextChange = { text: String ->
        textState.value = text
    }
    TextField(
        value = textState.value,
        onValueChange = onTextChange,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeEssentialsTheme {
        DemoScreen()
    }
}

@Composable
fun FunctionA() {
    var switchState by remember { mutableStateOf(true) }
    val onSwitchChange = { value: Boolean ->
        switchState = value
    }
    FunctionB(
        switchState = switchState,
        onSwitchChange = onSwitchChange,
    )
}

@Composable
fun FunctionB(
    switchState: Boolean,
    onSwitchChange: (Boolean) -> Unit,
) {
    Switch(
        checked = switchState,
        onCheckedChange = onSwitchChange,
    )
}
