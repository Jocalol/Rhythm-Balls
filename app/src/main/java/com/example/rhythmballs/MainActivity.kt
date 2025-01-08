package com.example.rhythmballs

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rhythmballs.ui.theme.RhythmBallsTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            RhythmBallsTheme {

                var navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    NavHost(navController = navController, startDestination = "main_menu") {
                        composable("in_game") {
                            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                            GameScreenView() {
                                navController.navigate("score")
                            }
                        }
                        composable("main_menu") {
                            MenuScreen(navController = navController)
                        }
                        composable("login") {
                            LoginScreen(navController = navController, onLoginSuccess = {
                                navController.navigate("main_menu")
                            })
                        }
                        composable("register") {
                            RegisterView(navController = navController, onRegisterSuccess = {
                                navController.navigate("main_menu")
                            })
                        }
                        composable("score") {
                            ScoreView(34879)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RhythmBallsTheme {
        Greeting("Android")
    }
}