package vn.finance.navigation

sealed class NavigationKey(open val key: String) {

    data class Onboarding(override val key: String = "onboarding") : NavigationKey(key = key)
    data class Authentication(override val key: String = "authentication") :
        NavigationKey(key = key)

    data class Home(override val key: String = "home") : NavigationKey(key = key)
}
