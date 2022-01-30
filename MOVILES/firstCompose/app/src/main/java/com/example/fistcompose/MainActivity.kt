package com.example.fistcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryUnknown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.fistcompose.ui.theme.FistComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FistComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PrimerBox()
                }
            }
        }
    }


    fun irPantalla()
    {
        startActivity(Intent( this, MainActivity2::class.java))
    }

}



@Composable
fun PrimerBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://placebear.com/200/300",
                builder = {
                    transformations(CircleCropTransformation())
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop


        )

        Greeting(
            name = "JJJ",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Greeting(
            name = "JJddJ",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Greeting(
            name = stringResource(R.string.ivan),
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val context = LocalContext.current

            Icon(

                imageVector = Icons.Default.BatteryUnknown,
                contentDescription = null,
                modifier = Modifier.size(200.dp)
                    .clickable {

                        context.startActivity(Intent( context, MainActivity2::class.java))

                    },
                tint = MaterialTheme.colors.secondary,

            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_ac_unit_24),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp),

                tint = MaterialTheme.colors.primary,
            )
        }


    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun DefaultPreview() {
    FistComposeTheme {
        PrimerBox()
    }
}
