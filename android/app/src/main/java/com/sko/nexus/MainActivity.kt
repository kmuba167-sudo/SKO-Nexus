package com.sko.nexus

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import com.sko.nexus.core.navigation.AppNavigation
import com.sko.nexus.ui.theme.SKONexusTheme

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SKONexusTheme {
                AppNavigation()
            }
        }
    }
}