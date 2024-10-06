package vn.finance.navigation

sealed class NavigationKey(private val key: String) {

    data object Onboarding : NavigationKey(key = "onboarding")
    data object Authentication : NavigationKey(key = "authentication")
    data object Home : NavigationKey(key = "home")
}