package com.example.fistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fistcompose.ui.theme.FistComposeTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FistComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    Navigation()
                }
            }
        }
    }
}


@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.LISTADO
    ) {
        composable(Routes.LISTADO) {
            pantallaLista(text = "hola",
                onNavigate = {
                    navController.navigate(Routes.DETALLE + "?todoId=${it}")
                }
            )
        }
        composable(
            route = Routes.DETALLE + "?todoId={todoId}",
            arguments = listOf(
                navArgument(name = "todoId") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            pantallaDetalle(
                id = it.arguments?.get("todoId")as Int,
                onPopBackStack = {
                navController.popBackStack()
            })
        }
    }

}


@Composable
fun pantallaLista(text: String,
onNavigate: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Greeting(
            "Android"
        )

        var texto = text

        OutlinedTextField(
            value = "hola",
            isError = true,
            onValueChange = { texto = it },
        )

        Button(onClick = { onNavigate(10) } ) {
            Text(
                text = "vete"
            )
        }
    }
}


@Composable
fun pantallaDetalle(
    id : Int,
                    onPopBackStack: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Greeting(
            "Pantalla Detalle $id"

        )
        Button(onClick =  onPopBackStack ) {
            Text(
                text = "Volver"
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FistComposeTheme {

        Navigation()
    }
}