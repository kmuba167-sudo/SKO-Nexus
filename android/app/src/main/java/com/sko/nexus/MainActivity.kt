package com.sko.nexus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sko.nexus.core.navigation.AppNavigation
import com.sko.nexus.ui.theme.SKONexusTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SKONexusTheme {
                AppNavigation()
            }
        }
    }
}