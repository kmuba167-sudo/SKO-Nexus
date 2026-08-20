package com.sko.nexus.feature.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sko.nexus.core.ui.components.SkoButton
import com.sko.nexus.core.ui.theme.SkoNavy

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var passengerId by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // App name
        Text(
            text = "SKO NEXUS",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = SkoNavy
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Subtitle
        Text(
            text = "Secure Passenger Identity",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = SkoNavy,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Passenger ID
        OutlinedTextField(
            value = passengerId,
            onValueChange = {
                passengerId = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Passenger ID")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Password")
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot password
        TextButton(
            onClick = {
                // Forgot password will be implemented later
            }
        ) {
            Text("Forgot password?")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Login button
        SkoButton(
            text = "LOGIN",
            onClick = onLoginSuccess
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Divider text
        Text(
            text = "OR",
            style = MaterialTheme.typography.labelMedium,
            color = SkoNavy.copy(alpha = 0.5f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Face authentication
        TextButton(
            onClick = {
                // Biometric authentication will be implemented later
            }
        ) {
            Text(
                text = "Continue with Face Authentication",
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Register section
        Text(
            text = "Don't have an account?",
            color = SkoNavy.copy(alpha = 0.7f)
        )

        TextButton(
            onClick = onRegisterClick
        ) {
            Text(
                text = "REGISTER",
                fontWeight = FontWeight.Bold
            )
        }
    }
}