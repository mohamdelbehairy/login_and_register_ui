package com.example.login_and_register_ui.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_and_register_ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(navController: NavController) {

    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val passwordVisible = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            // image
            Box(
                modifier = Modifier.background(color = White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier
                        .width(400.dp)
                        .height(350.dp),
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "Login Image",
                    contentScale = ContentScale.Fit
                )
            }
            // space
            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Sign In",
                fontWeight = FontWeight.Bold,
                color = Black,
                fontSize = 40.sp,
            )

            Spacer(modifier = Modifier.padding(20.dp))

            // email
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text(text = "Email Address", color = Black) },
                placeholder = { Text(text = "Email Address", color = Black) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Black,

                    )
            )

            Spacer(modifier = Modifier.padding(4.dp))

            // password
            OutlinedTextField(value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password", color = Black) },
                placeholder = { Text(text = "Password", color = Black) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),

                visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisible.value = !passwordVisible.value
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_remove_red_eye_24),
                            contentDescription = "Password",
                            tint = if (passwordVisible.value) Color.Magenta else Color.Gray
                        )
                    }
                })

            Spacer(modifier = Modifier.padding(20.dp))
            // button
            Button(
                colors = ButtonDefaults.buttonColors(White),
                onClick = {
                    when {
                        email.value.isEmpty() -> {
                            Toast.makeText(
                                context,
                                "Please enter email address!",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        password.value.isEmpty() -> {
                            Toast.makeText(
                                context,
                                "Please enter password!",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        else -> {
                            Toast.makeText(context, "Logged Successfully!", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
            ) {
                Text("Sign In", color = Black, fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Create an Account?",
                color = Black,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                })

            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}