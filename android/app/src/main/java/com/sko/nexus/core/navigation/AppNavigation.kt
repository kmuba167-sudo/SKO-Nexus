package com.sko.nexus.core.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sailing
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sko.nexus.feature.auth.LoginScreen
import com.sko.nexus.feature.auth.RegisterScreen
import com.sko.nexus.feature.dashboard.DashboardScreen
import com.sko.nexus.feature.flights.FlightsScreen
import com.sko.nexus.feature.voyages.VoyagesScreen
import com.sko.nexus.feature.welcome.WelcomeScreen


object Routes {

    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val DASHBOARD = "dashboard"

    const val FLIGHTS = "flights"
    const val VOYAGES = "voyages"
    const val BOOKINGS = "bookings"
    const val PROFILE = "profile"
}


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val navBackStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry.value?.destination?.route


    // Show bottom navigation only after login

    val showBottomBar =
        currentRoute == Routes.DASHBOARD ||
                currentRoute == Routes.FLIGHTS ||
                currentRoute == Routes.VOYAGES ||
                currentRoute == Routes.BOOKINGS ||
                currentRoute == Routes.PROFILE


    Scaffold(

        bottomBar = {

            if (showBottomBar) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                topStart = 22.dp,
                                topEnd = 22.dp
                            )
                        )
                        .background(
                            Color(0xFF7FCBDE)
                        )
                        .padding(
                            vertical = 12.dp,
                            horizontal = 4.dp
                        ),

                    horizontalArrangement =
                        Arrangement.SpaceEvenly
                ) {

                    // =========================
                    // DASHBOARD
                    // =========================

                    NavigationItem(
                        icon = Icons.Default.Home,
                        label = "Dashboard",
                        selected =
                            currentRoute == Routes.DASHBOARD,

                        onClick = {

                            navController.navigate(
                                Routes.DASHBOARD
                            ) {

                                launchSingleTop = true
                            }
                        }
                    )


                    // =========================
                    // FLIGHTS
                    // =========================

                    NavigationItem(
                        icon =
                            Icons.Default.AirplanemodeActive,

                        label = "Flights",

                        selected =
                            currentRoute == Routes.FLIGHTS,

                        onClick = {

                            navController.navigate(
                                Routes.FLIGHTS
                            ) {

                                launchSingleTop = true
                            }
                        }
                    )


                    // =========================
                    // VOYAGES
                    // =========================

                    NavigationItem(
                        icon = Icons.Default.Sailing,

                        label = "Voyages",

                        selected =
                            currentRoute == Routes.VOYAGES,

                        onClick = {

                            navController.navigate(
                                Routes.VOYAGES
                            ) {

                                launchSingleTop = true
                            }
                        }
                    )


                    // =========================
                    // BOOKINGS
                    // =========================

                    NavigationItem(
                        icon =
                            Icons.Default.ConfirmationNumber,

                        label = "Bookings",

                        selected =
                            currentRoute == Routes.BOOKINGS,

                        onClick = {

                            navController.navigate(
                                Routes.BOOKINGS
                            ) {

                                launchSingleTop = true
                            }
                        }
                    )


                    // =========================
                    // PROFILE
                    // =========================

                    NavigationItem(
                        icon = Icons.Default.Person,

                        label = "Profile",

                        selected =
                            currentRoute == Routes.PROFILE,

                        onClick = {

                            navController.navigate(
                                Routes.PROFILE
                            ) {

                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }

    ) { innerPadding ->


        NavHost(

            navController = navController,

            startDestination = Routes.WELCOME,

            modifier = Modifier.padding(
                innerPadding
            )
        ) {


            // =========================
            // WELCOME
            // =========================

            composable(Routes.WELCOME) {

                WelcomeScreen(

                    onContinue = {

                        navController.navigate(
                            Routes.LOGIN
                        )
                    }
                )
            }


            // =========================
            // LOGIN
            // =========================

            composable(Routes.LOGIN) {

                LoginScreen(

                    onLoginSuccess = {

                        navController.navigate(
                            Routes.DASHBOARD
                        ) {

                            popUpTo(
                                Routes.LOGIN
                            ) {

                                inclusive = true
                            }
                        }
                    },

                    onRegisterClick = {

                        navController.navigate(
                            Routes.REGISTER
                        )
                    }
                )
            }


            // =========================
            // REGISTER
            // =========================

            composable(Routes.REGISTER) {

                RegisterScreen(

                    onRegisterSuccess = {

                        navController.navigate(
                            Routes.LOGIN
                        ) {

                            popUpTo(
                                Routes.REGISTER
                            ) {

                                inclusive = true
                            }
                        }
                    },

                    onLoginClick = {

                        navController.popBackStack()
                    }
                )
            }


            // =========================
            // DASHBOARD
            // =========================

            composable(Routes.DASHBOARD) {

                DashboardScreen()
            }


            // =========================
            // FLIGHTS
            // =========================

            composable(Routes.FLIGHTS) {

                FlightsScreen()
            }


            // =========================
            // VOYAGES
            // =========================

            composable(Routes.VOYAGES) {

                VoyagesScreen()
            }


            // =========================
            // BOOKINGS
            // =========================

            composable(Routes.BOOKINGS) {

                SimpleScreen(
                    title = "Bookings",
                    subtitle =
                        "View and manage your bookings."
                )
            }


            // =========================
            // PROFILE
            // =========================

            composable(Routes.PROFILE) {

                SimpleScreen(
                    title = "Profile",
                    subtitle =
                        "Manage your passenger profile."
                )
            }
        }
    }
}


// =====================================
// BOTTOM NAVIGATION ITEM
// =====================================

@Composable
private fun NavigationItem(

    icon: ImageVector,

    label: String,

    selected: Boolean,

    onClick: () -> Unit
) {

    val color = if (selected) {

        Color(0xFF0D47A1)

    } else {

        Color.White.copy(
            alpha = 0.75f
        )
    }


    Column(

        modifier = Modifier.clickable {
            onClick()
        },

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Icon(

            imageVector = icon,

            contentDescription = label,

            tint = color
        )


        Text(

            text = label,

            color = color
        )
    }
}


// =====================================
// TEMPORARY SCREEN
// =====================================

@Composable
private fun SimpleScreen(

    title: String,

    subtitle: String
) {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = title
        )

        Text(
            text = subtitle
        )
    }
}