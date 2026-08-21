package com.sko.nexus.feature.bookings

data class Booking(
    val bookingReference: String,
    val bookingType: String,
    val title: String,
    val journey: String,
    val date: String,
    val time: String,
    val status: String,
    val securityVerified: Boolean
)
