package com.example.login_and_register_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_and_register_ui.ui.theme.Login_and_register_uiTheme
import com.example.login_and_register_ui.views.LoginView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login_and_register_uiTheme {
                NavigateView()
            }
        }
    }
}

@Composable
fun NavigateView() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login_view") {
        composable("login_view") {
            LoginView(navController)
        }
    }
}