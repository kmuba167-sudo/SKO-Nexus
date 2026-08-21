package com.sko.nexus.feature.identity

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

class BiometricAuthenticator(
    private val activity: FragmentActivity
) {

    private val authenticators =
        BiometricManager.Authenticators.BIOMETRIC_STRONG or
                BiometricManager.Authenticators.BIOMETRIC_WEAK or
                BiometricManager.Authenticators.DEVICE_CREDENTIAL

    fun canAuthenticate(): Boolean {

        val biometricManager =
            BiometricManager.from(activity)

        return biometricManager.canAuthenticate(
            authenticators
        ) == BiometricManager.BIOMETRIC_SUCCESS
    }

    fun authenticate(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        val executor =
            ContextCompat.getMainExecutor(activity)

        val promptInfo =
            BiometricPrompt.PromptInfo.Builder()
                .setTitle("SKO Nexus Identity Verification")
                .setSubtitle("Verify your passenger identity")
                .setDescription(
                    "Use face, fingerprint, or your device credentials to securely verify your identity."
                )
                .setAllowedAuthenticators(authenticators)
                .build()

        val biometricPrompt =
            BiometricPrompt(
                activity,
                executor,
                object : BiometricPrompt.AuthenticationCallback() {

                    override fun onAuthenticationSucceeded(
                        result: BiometricPrompt.AuthenticationResult
                    ) {
                        super.onAuthenticationSucceeded(result)

                        onSuccess()
                    }

                    override fun onAuthenticationError(
                        errorCode: Int,
                        errString: CharSequence
                    ) {
                        super.onAuthenticationError(
                            errorCode,
                            errString
                        )

                        onError(
                            errString.toString()
                        )
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()

                        onError(
                            "Biometric authentication failed."
                        )
                    }
                }
            )

        biometricPrompt.authenticate(promptInfo)
    }
}