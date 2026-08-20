# Fix compilation error: No parameter with name 'onNavigate' found

The user reported a compilation error in `AppNavigation.kt` indicating that `DashboardScreen` is being called with a parameter `onNavigate` that does not exist in its declaration.

Although the current source code for `AppNavigation.kt` does not show this call, it is a logical addition for a dashboard screen to handle navigation to other features (Flights, Voyages, etc.). I will implement the missing `onNavigate` parameter in `DashboardScreen` and wire it up in `AppNavigation.kt`.

## Proposed Changes

### [Dashboard Feature]

#### [MODIFY] [DashboardScreen.kt](file:///C:/Users/Mubarak/Documents/MubaProjects/SKO-Workspace/SKO-Nexus/android/app/src/main/java/com/sko/nexus/feature/dashboard/DashboardScreen.kt)
- Add `onNavigate: (String) -> Unit` parameter to `DashboardScreen` Composable.
- Add `onClick: () -> Unit` parameter to `DashboardCard` private Composable.
- Wire up the cards to trigger `onNavigate` with appropriate routes:
    - "UPCOMING JOURNEY" -> `Routes.FLIGHTS`
    - "IDENTITY STATUS" -> `Routes.PROFILE`
    - "FACE VERIFICATION" -> `Routes.PROFILE`

### [Core Navigation]

#### [MODIFY] [AppNavigation.kt](file:///C:/Users/Mubarak/Documents/MubaProjects/SKO-Workspace/SKO-Nexus/android/app/src/main/java/com/sko/nexus/core/navigation/AppNavigation.kt)
- Pass the `onNavigate` lambda to `DashboardScreen` call.

## Verification Plan

### Automated Tests
- Run `:app:compileDebugKotlin` to verify the compilation error is resolved.

### Manual Verification
- N/A (UI navigation verification requires running the app).
