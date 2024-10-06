package vn.finance.navigation

sealed class NavigationKey {

    data class Onboarding(val key: String = "onboarding") : NavigationKey()
    data class Authentication(val key: String = "authentication") : NavigationKey()
    data class Home(val key: String = "home") : NavigationKey()
}
