package me.alejandropradilla.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.alejandropradilla.myapplication.ui.Screens.FacebookLoginScreen
import me.alejandropradilla.myapplication.ui.Screens.FacebookRegisterScreen
import me.alejandropradilla.myapplication.ui.Screens.FeedScreen
import me.alejandropradilla.myapplication.ui.Screens.RecuperarSceen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val myNavcontroller = rememberNavController()

            NavHost(
                navController = myNavcontroller,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login") {
                    FacebookLoginScreen(
                        onClickRegister = {
                        myNavcontroller.navigate("Register")
                        },
                        onClickIniciarSesion = {
                            myNavcontroller.navigate("FeedScreen"){
                                popUpTo("")
                            }
                        },
                        onClickRecuperarContraseña = {
                            myNavcontroller.navigate("RecuperarSceen")
                        }
                    )
                }
                composable(route = "register") {
                    FacebookRegisterScreen(onClickBack = {
                        myNavcontroller.popBackStack()
                    })
                }
                composable(route = "FeedScreen") {
                    FeedScreen()
                }
                composable(route = "RecuperarSceen") {
                    RecuperarSceen(onClickBack = {
                        myNavcontroller.popBackStack()
                    })
                }
            }
        }
    }
}
