package com.sko.nexus.feature.bookings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookingsViewModel : ViewModel() {

    private val _booking = MutableStateFlow(
        Booking(
            bookingReference = "SKO-8F247",
            bookingType = "FLIGHT",
            title = "SKO Airways",
            journey = "Delhi → Mumbai",
            date = "28 Aug 2026",
            time = "09:30 AM",
            status = "CONFIRMED",
            securityVerified = true
        )
    )

    val booking: StateFlow<Booking> =
        _booking.asStateFlow()

    fun selectBooking(booking: Booking) {
        _booking.value = booking
    }

    fun setSecurityVerified(verified: Boolean) {
        _booking.value =
            _booking.value.copy(
                securityVerified = verified
            )
    }
}