package com.sko.nexus.feature.bookings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DirectionsBoat
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sko.nexus.core.ui.theme.SkoBlue

@Composable
fun BookingsScreen(
    onBookingClick: (Booking) -> Unit
) {

    val bookings = listOf(
        Booking(
            bookingReference = "SKO-84291",
            bookingType = "Flight",
            title = "Chennai → Dubai",
            journey = "Chennai (MAA) → Dubai (DXB)",
            date = "24 Aug 2026",
            time = "10:00 AM",
            status = "Confirmed",
            securityVerified = true
        ),
        Booking(
            bookingReference = "SKO-71542",
            bookingType = "Cruise",
            title = "Dubai → Muscat",
            journey = "Dubai → Muscat",
            date = "30 Aug 2026",
            time = "06:00 PM",
            status = "Confirmed",
            securityVerified = true
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp)
    ) {

        Text(
            text = "My Bookings",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Your upcoming journeys",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(bookings) { booking ->
                BookingCard(
                    booking = booking,
                    onClick = {
                        onBookingClick(booking)
                    }
                )
            }
        }
    }
}

@Composable
private fun BookingCard(
    booking: Booking,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                BookingTypeIcon(
                    bookingType = booking.bookingType
                )

                Spacer(modifier = Modifier.size(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = booking.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = booking.bookingType,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                StatusBadge(
                    status = booking.status
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Journey
            Text(
                text = "JOURNEY",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = booking.journey,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Date & Time
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "DATE",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = booking.date,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "DEPARTURE",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = booking.time,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Divider-like section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(
                        MaterialTheme.colorScheme.outlineVariant
                    )
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Booking reference + security
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "BOOKING REFERENCE",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = booking.bookingReference,
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                if (booking.securityVerified) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Security verified",
                            tint = Color(0xFF2E7D32),
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.size(5.dp))

                        Text(
                            text = "Security Verified",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color(0xFF2E7D32)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BookingTypeIcon(
    bookingType: String
) {

    val icon = if (bookingType == "Flight") {
        Icons.Default.AirplanemodeActive
    } else {
        Icons.Default.DirectionsBoat
    }

    Box(
        modifier = Modifier
            .size(48.dp)
            .background(
                color = SkoBlue.copy(alpha = 0.12f),
                shape = RoundedCornerShape(14.dp)
            ),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            imageVector = icon,
            contentDescription = bookingType,
            tint = SkoBlue,
            modifier = Modifier.size(25.dp)
        )
    }
}

@Composable
private fun StatusBadge(
    status: String
) {

    Surface(
        shape = RoundedCornerShape(50),
        color = Color(0xFFE8F5E9)
    ) {

        Text(
            text = status,
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),
            style = MaterialTheme.typography.labelMedium,
            color = Color(0xFF2E7D32)
        )
    }
}