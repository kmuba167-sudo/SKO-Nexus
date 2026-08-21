package com.sko.nexus.feature.identity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class IdentityViewModel : ViewModel() {

    private val _identityVerified =
        MutableStateFlow(false)

    val identityVerified: StateFlow<Boolean> =
        _identityVerified.asStateFlow()

    fun markIdentityVerified() {
        _identityVerified.value = true
    }

    fun clearIdentityVerification() {
        _identityVerified.value = false
    }
}