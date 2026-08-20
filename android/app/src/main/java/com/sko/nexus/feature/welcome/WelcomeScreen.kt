package com.sko.nexus.feature.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sko.nexus.R
import com.sko.nexus.core.ui.components.SkoButton
import com.sko.nexus.core.ui.theme.SkoNavy
import com.sko.nexus.core.ui.theme.SkoSuccess

@Composable
fun WelcomeScreen(
    onContinue: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Logo
        Image(
            painter = painterResource(id = R.drawable.skologo),
            contentDescription = "SKO Nexus Logo",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.size(18.dp))

        // App name
        Text(
            text = "SKO NEXUS",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = SkoNavy,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(8.dp))

        // Tagline
        Text(
            text = "SECURE PASSENGER IDENTITY",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = SkoNavy,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(18.dp))

        // Description
        Text(
            text = "A trusted digital identity platform designed for secure and seamless passenger journeys.",
            style = MaterialTheme.typography.bodyLarge,
            color = SkoNavy.copy(alpha = 0.75f),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(30.dp))

        // Security indicators
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SecurityStatus("✓", "Secure")
            SecurityStatus("✓", "Private")
            SecurityStatus("✓", "Verified")
        }

        Spacer(modifier = Modifier.size(36.dp))

        // Continue
        SkoButton(
            text = "GET STARTED  →",
            onClick = onContinue
        )
    }
}

@Composable
private fun SecurityStatus(
    icon: String,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            color = SkoSuccess,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = SkoNavy
        )
    }
}