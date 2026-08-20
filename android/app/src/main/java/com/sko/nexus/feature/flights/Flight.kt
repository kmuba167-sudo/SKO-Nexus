package com.sko.nexus.feature.flights

data class Flight(
    val airline: String,
    val flightNumber: String,
    val originCode: String,
    val originCity: String,
    val destinationCode: String,
    val destinationCity: String,
    val date: String,
    val departureTime: String,
    val duration: String,
    val gate: String,
    val status: String,
    val securityVerified: Boolean
)