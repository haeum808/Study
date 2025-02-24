package org.haeum.jetpackcomposeessentials.chapter_24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.haeum.jetpackcomposeessentials.R
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
    val modifier = Modifier
        .border(width = 2.dp, color = Color.Black)
        .padding(all = 10.dp)

    val secondModifier = Modifier.height(100.dp)

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Hello Compose",
            modifier = modifier.then(secondModifier),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        CustomImage(
            image = R.drawable.vacation,
            modifier = Modifier.padding(16.dp)
                .width(270.dp)
                .clip(shape = RoundedCornerShape(30.dp)),
        )
    }
}

@Composable
fun CustomImage(
    image: Int, modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeEssentialsTheme {
        DemoScreen()
    }
}
