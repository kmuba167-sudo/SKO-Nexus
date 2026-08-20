package com.sko.nexus.feature.flights

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FlightsViewModel : ViewModel() {

    private val _upcomingFlight = MutableStateFlow(
        Flight(
            airline = "SKO Airways",
            flightNumber = "SKO 247",
            originCode = "DEL",
            originCity = "Delhi",
            destinationCode = "BOM",
            destinationCity = "Mumbai",
            date = "28 Aug 2026",
            departureTime = "09:30 AM",
            duration = "2h 15m",
            gate = "A12",
            status = "CONFIRMED",
            securityVerified = true,
        )
    )

    val upcomingFlight: StateFlow<Flight> =
        _upcomingFlight.asStateFlow()

    fun setSecurityVerified(verified: Boolean) {
        _upcomingFlight.value =
            _upcomingFlight.value.copy(
                securityVerified = verified
            )
    }
}