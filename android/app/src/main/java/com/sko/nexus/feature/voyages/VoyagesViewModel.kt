package com.sko.nexus.feature.voyages

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class VoyagesViewModel : ViewModel() {

    private val _upcomingVoyage = MutableStateFlow(
        Voyage(
            vesselName = "SKO Oceanic",
            voyageNumber = "VOY 102",
            originPort = "MAA",
            destinationPort = "CMB",
            departureDate = "28 Aug 2026",
            departureTime = "06:00 PM",
            arrivalDate = "30 Aug 2026",
            arrivalTime = "08:00 AM",
            duration = "38h",
            terminal = "T3",
            status = "CONFIRMED",
            securityVerified = true,
        )
    )

    val upcomingVoyage: StateFlow<Voyage> =
        _upcomingVoyage.asStateFlow()

    fun setSecurityVerified(verified: Boolean) {
        _upcomingVoyage.value =
            _upcomingVoyage.value.copy(
                securityVerified = verified
            )
    }
}