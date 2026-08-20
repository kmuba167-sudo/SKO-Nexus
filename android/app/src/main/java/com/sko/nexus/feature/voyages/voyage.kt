package com.sko.nexus.feature.voyages

data class Voyage(
    val vesselName: String,
    val voyageNumber: String,
    val originPort: String,
    val destinationPort: String,
    val departureDate: String,
    val departureTime: String,
    val arrivalDate: String,
    val arrivalTime: String,
    val duration: String,
    val terminal: String,
    val status: String,
    val securityVerified: Boolean
)