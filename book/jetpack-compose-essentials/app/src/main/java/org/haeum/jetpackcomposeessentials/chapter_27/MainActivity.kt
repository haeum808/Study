package org.haeum.jetpackcomposeessentials.chapter_27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import org.haeum.jetpackcomposeessentials.ui.theme.JetpackComposeEssentialsTheme
import kotlin.math.roundToInt

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
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(120.dp, 80.dp),
    ) {
        Column {
            ColorBox(
                Modifier
                    .exampleLayout(0f)
                    .background(Color.Blue)
            )
            ColorBox(
                Modifier
                    .exampleLayout(0.25f)
                    .background(Color.Green)
            )
            ColorBox(
                Modifier
                    .exampleLayout(0.5f)
                    .background(Color.Yellow)
            )
            ColorBox(
                Modifier
                    .exampleLayout(0.25f)
                    .background(Color.Red)
            )
            ColorBox(
                Modifier
                    .exampleLayout(0f)
                    .background(Color.Magenta)
            )
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier) {
    Box(
        Modifier
            .padding(1.dp)
            .size(width = 50.dp, height = 10.dp)
            .then(modifier)
    )
}

fun Modifier.exampleLayout(
    x: Int,
    y: Int,
): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, y)
    }
}

fun Modifier.exampleLayout(
    fraction: Float
): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    val x = -(placeable.width * fraction).roundToInt()

    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, 0)
    }
}