package com.sko.nexus.feature.flights

class FlightsRepository {

    fun getUpcomingFlight(): Flight {
        return Flight(
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
            securityVerified = true
        )
    }
}