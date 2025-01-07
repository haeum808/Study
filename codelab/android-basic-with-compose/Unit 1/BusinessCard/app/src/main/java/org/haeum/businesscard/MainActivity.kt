package org.haeum.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.haeum.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Green,
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box {
        MainInformation(
            image = painterResource(id = R.drawable.android_logo),
            name = "Haeum",
            title = "Android Developer Extraordinaire",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            ContactInformation(image = painterResource(id = R.drawable.ic_call), "+82 10-4497-8087")
            ContactInformation(image = painterResource(id = R.drawable.ic_share), "@AndroidDev")
            ContactInformation(
                image = painterResource(id = R.drawable.ic_email),
                "haeumueah@gmail.com"
            )
            Spacer(modifier = Modifier.padding(32.dp))
        }
    }
}

@Composable
fun MainInformation(
    image: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(painter = image, contentDescription = null)
        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = title, fontSize = 16.sp)
    }
}

@Composable
fun ContactInformation(
    image: Painter,
    detail: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(painter = image, contentDescription = null)
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = detail)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}