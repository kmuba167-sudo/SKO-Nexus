package com.sko.nexus.feature.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.Anchor
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sko.nexus.core.navigation.Routes
import com.sko.nexus.core.ui.theme.SkoNavy
import com.sko.nexus.core.ui.theme.SkoSuccess


@Composable
fun DashboardScreen(
    onNavigate: (String) -> Unit = {}
) {

    // =========================
    // DASHBOARD COLORS
    // =========================

    val skyBlue = Color(0xFF42A5F5)

    val backgroundTop = Color(0xFFF4FBFD)
    val backgroundMiddle = Color(0xFFEAF6FA)
    val backgroundBottom = Color(0xFFDFF1F6)

    val cardColor = Color(0xFFF8FAFB)
    val textDark = SkoNavy
    val mutedText = Color(0xFF5F7D8A)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        backgroundTop,
                        backgroundMiddle,
                        backgroundBottom
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(28.dp))


            // =========================
            // HEADER
            // =========================

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "SKO NEXUS",
                        color = textDark,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Passenger Dashboard",
                        color = mutedText,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "🔔",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }


            Spacer(modifier = Modifier.height(22.dp))


            // =========================
            // HERO SECTION
            // =========================

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFAADDEA),
                                Color(0xFF7FCBDE)
                            )
                        )
                    )
            ) {

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.BottomStart)
                ) {

                    Text(
                        text = "Welcome back,",
                        color = textDark,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Passenger 👋",
                        color = textDark,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Your journey. Our priority.",
                        color = textDark.copy(alpha = 0.75f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }


                // Airplane

                Icon(
                    imageVector = Icons.Default.AirplanemodeActive,
                    contentDescription = "Flight",
                    tint = Color.White.copy(alpha = 0.9f),
                    modifier = Modifier
                        .size(82.dp)
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                )


                // Anchor

                Icon(
                    imageVector = Icons.Default.Anchor,
                    contentDescription = "Anchor",
                    tint = Color.White.copy(alpha = 0.9f),
                    modifier = Modifier
                        .size(82.dp)
                        .align(Alignment.BottomEnd)
                        .padding(12.dp)
                )
            }


            Spacer(modifier = Modifier.height(16.dp))


            // =========================
            // IDENTITY STATUS
            // =========================

            DashboardCard(
                backgroundColor = cardColor,
                icon = {

                    Icon(
                        imageVector = Icons.Default.VerifiedUser,
                        contentDescription = null,
                        tint = SkoSuccess,
                        modifier = Modifier.size(30.dp)
                    )
                },
                title = "IDENTITY STATUS",
                value = "Verified ✓",
                description = "Your passenger identity is secure and verified.",
                valueColor = SkoSuccess,
                onClick = { onNavigate(Routes.PROFILE) }
            )


            Spacer(modifier = Modifier.height(10.dp))


            // =========================
            // FACE VERIFICATION
            // =========================

            DashboardCard(
                backgroundColor = cardColor,
                icon = {

                    Icon(
                        imageVector = Icons.Default.Fingerprint,
                        contentDescription = null,
                        tint = skyBlue,
                        modifier = Modifier.size(30.dp)
                    )
                },
                title = "FACE VERIFICATION",
                value = "Available",
                description = "Verify your identity securely using biometric authentication.",
                valueColor = skyBlue,
                onClick = { onNavigate(Routes.PROFILE) }
            )


            Spacer(modifier = Modifier.height(10.dp))


            // =========================
            // UPCOMING JOURNEY
            // =========================

            DashboardCard(
                backgroundColor = cardColor,
                icon = {

                    Icon(
                        imageVector = Icons.Default.AirplanemodeActive,
                        contentDescription = null,
                        tint = Color(0xFF7E57C2),
                        modifier = Modifier.size(30.dp)
                    )
                },
                title = "UPCOMING JOURNEY",
                value = "No upcoming trips",
                description = "Your upcoming flights or voyages will appear here.",
                valueColor = Color(0xFF7E57C2),
                onClick = { onNavigate(Routes.FLIGHTS) }
            )


            Spacer(modifier = Modifier.height(12.dp))


            // =========================
            // INFORMATION BAR
            // =========================

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
                ) {

                    DashboardInfo(
                        icon = "✓",
                        title = "SECURITY",
                        value = "Active",
                        color = SkoSuccess
                    )

                    DashboardInfo(
                        icon = "◉",
                        title = "MEMBERSHIP",
                        value = "SKO Nexus",
                        color = skyBlue
                    )

                    DashboardInfo(
                        icon = "⚓",
                        title = "LOYALTY",
                        value = "Bronze",
                        color = Color(0xFFFF9800)
                    )
                }
            }


            // Pushes the dashboard content toward the top.
            // The bottom navigation is now handled by AppNavigation.
            Spacer(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}


// =====================================
// DASHBOARD CARD
// =====================================

@Composable
private fun DashboardCard(
    backgroundColor: Color,
    icon: @Composable () -> Unit,
    title: String,
    value: String,
    description: String,
    valueColor: Color,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        onClick = onClick
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Icon circle

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEAF6FA)),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }


            Spacer(modifier = Modifier.width(14.dp))


            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    color = mutedTextColor(),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = value,
                    color = valueColor,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = description,
                    color = mutedTextColor(),
                    style = MaterialTheme.typography.bodySmall
                )
            }


            Text(
                text = "›",
                color = skyBlueColor(),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}


// =====================================
// INFORMATION ITEM
// =====================================

@Composable
private fun DashboardInfo(
    icon: String,
    title: String,
    value: String,
    color: Color
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = icon,
            color = color,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = title,
            color = Color(0xFF6B8792),
            style = MaterialTheme.typography.labelSmall
        )

        Text(
            text = value,
            color = color,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold
        )
    }
}


// =====================================
// SMALL COLOR HELPERS
// =====================================

private fun mutedTextColor(): Color {
    return Color(0xFF5F7D8A)
}

private fun skyBlueColor(): Color {
    return Color(0xFF42A5F5)
}