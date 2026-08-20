package com.sko.nexus.feature.flights

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Security
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
import com.sko.nexus.core.ui.theme.SkoNavy
import com.sko.nexus.core.ui.theme.SkoSuccess
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FlightsScreen(
    viewModel: FlightsViewModel = viewModel()
) {

    val flight = viewModel.upcomingFlight.collectAsState().value

    val skyBlue = Color(0xFF42A5F5)
    val backgroundTop = Color(0xFFF4FBFD)
    val backgroundBottom = Color(0xFFDFF1F6)
    val mutedText = Color(0xFF5F7D8A)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        backgroundTop,
                        backgroundBottom
                    )
                )
            )
            .padding(horizontal = 20.dp)
    ) {

        Spacer(modifier = Modifier.height(28.dp))

        // =========================
        // HEADER
        // =========================

        Text(
            text = "Flights",
            color = SkoNavy,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Your upcoming air journeys",
            color = mutedText,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(22.dp))

        // =========================
        // UPCOMING FLIGHT
        // =========================

        Text(
            text = "UPCOMING FLIGHT",
            color = mutedText,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                // Airline row

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(
                                Color(0xFFEAF6FA)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.AirplanemodeActive,
                            contentDescription = null,
                            tint = skyBlue,
                            modifier = Modifier.size(26.dp)
                        )
                    }

                    Spacer(
                        modifier = Modifier.size(12.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = flight?.airline ?: "",
                            color = SkoNavy,
                            style =
                                MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = flight?.flightNumber ?: "",
                            color = mutedText,
                            style =
                                MaterialTheme.typography.bodySmall
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(
                                Color(0xFFE8F5E9)
                            )
                            .padding(
                                horizontal = 12.dp,
                                vertical = 6.dp
                            )
                    ) {

                        Text(
                            text = flight?.status ?: "",
                            color = SkoSuccess,
                            style =
                                MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(22.dp)
                )

                // =========================
                // ROUTE
                // =========================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        horizontalAlignment =
                            Alignment.Start
                    ) {

                        Text(
                            text = flight?.originCode ?: "",
                            color = SkoNavy,
                            style =
                                MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = flight?.originCity ?: "",
                            color = mutedText,
                            style =
                                MaterialTheme.typography.bodySmall
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment =
                            Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector =
                                Icons.Default.AirplanemodeActive,
                            contentDescription = null,
                            tint = skyBlue,
                            modifier = Modifier.size(28.dp)
                        )

                        Spacer(
                            modifier =
                                Modifier.height(4.dp)
                        )

                        Text(
                            text = flight?.duration ?: "",
                            color = mutedText,
                            style =
                                MaterialTheme.typography.labelSmall
                        )
                    }

                    Column(
                        horizontalAlignment =
                            Alignment.End
                    ) {

                        Text(
                            text = flight?.destinationCode ?: "",
                            color = SkoNavy,
                            style =
                                MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = flight?.destinationCity ?: "",
                            color = mutedText,
                            style =
                                MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                // =========================
                // FLIGHT DETAILS
                // =========================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    FlightDetail(
                        icon = Icons.Default.CalendarMonth,
                        title = "DATE",
                        value = flight?.date ?: ""
                    )

                    FlightDetail(
                        icon = Icons.Default.AccessTime,
                        title = "DEPARTURE",
                        value = flight?.departureTime ?: ""
                    )

                    FlightDetail(
                        icon = Icons.Default.LocationOn,
                        title = "GATE",
                        value = flight?.gate ?: ""
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // =========================
        // SECURITY STATUS
        // =========================

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
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
                    .padding(16.dp),
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(
                            Color(0xFFE8F5E9)
                        ),
                    contentAlignment =
                        Alignment.Center
                ) {

                    Icon(
                        imageVector =
                            Icons.Default.Security,
                        contentDescription = null,
                        tint = SkoSuccess,
                        modifier = Modifier.size(25.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.size(14.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Passenger Security",
                        color = SkoNavy,
                        style =
                            MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = if (flight?.securityVerified == true) {
                            "Identity verified for this journey."
                        } else {
                            "Identity verification required."
                        },
                        color = mutedText,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Text(
                    text = if (flight?.securityVerified == true) "✓" else "!",
                    color = if (flight?.securityVerified == true) {
                        SkoSuccess
                    } else {
                        Color.Red
                    },
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        // =========================
        // BOARDING STATUS
        // =========================

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF42A5F5)
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "BOARDING PASS",
                        color = Color.White.copy(
                            alpha = 0.75f
                        ),
                        style =
                            MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(3.dp)
                    )

                    Text(
                        text = "Ready for boarding",
                        color = Color.White,
                        style =
                            MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                Icon(
                    imageVector =
                        Icons.Default.AirplanemodeActive,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    }
}


// =====================================
// FLIGHT DETAIL
// =====================================

@Composable
private fun FlightDetail(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String
) {

    Column(
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF42A5F5),
            modifier = Modifier.size(21.dp)
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = title,
            color = Color(0xFF6B8792),
            style =
                MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = value,
            color = SkoNavy,
            style =
                MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold
        )
    }
}