package com.example.fistcompose

import android.content.Intent
import android.opengl.GLES31
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryUnknown
import androidx.compose.material.icons.outlined.BatteryUnknown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.fistcompose.ui.theme.FistComposeTheme
import kotlinx.coroutines.launch

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


    fun irPantalla() {
        startActivity(Intent(this, MainActivity2::class.java))
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
        val snackbarHostState = remember { SnackbarHostState() }


        val context = LocalContext.current
        val circularProgressDrawable: CircularProgressDrawable = remember {
            val c = CircularProgressDrawable(context)
            c.strokeWidth = 5f
            c.centerRadius = 30f
            c.start()
            c
        }
        Image(
            painter = rememberImagePainter(
                data = "https://placebear.com/200/300",
                builder = {
                    placeholder(circularProgressDrawable)
                    transformations(CircleCropTransformation())
                    crossfade(durationMillis = 2000)
                }
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit


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

            val scope = rememberCoroutineScope()

            Icon(

                imageVector = Icons.Outlined.BatteryUnknown,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clickable {

                        context.startActivity(Intent(context, MainActivity2::class.java))

                    },
                tint = MaterialTheme.colors.primary,

                )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_ac_unit_24),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clickable {
                        scope.launch {
                            snackbarHostState.showSnackbar("Hello")
                        }
                        Toast
                            .makeText(context, "TOAST", Toast.LENGTH_SHORT)
                            .show()

                    },

                tint = MaterialTheme.colors.primary,
            )
        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomEnd)
        )

    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun DefaultPreview() {
    FistComposeTheme {
        PrimerBox()
    }
}
