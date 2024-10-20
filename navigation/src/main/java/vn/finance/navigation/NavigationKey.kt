package vn.finance.navigation

sealed class NavigationKey(open val key: String) {

    data class Onboarding(override val key: String = "onboarding") : NavigationKey(key = key)
    data class Authentication(override val key: String = "authentication") :
        NavigationKey(key = key)

    data class Home(override val key: String = "home") : NavigationKey(key = key)
    data class Setting(override val key: String = "setting") : NavigationKey(key = key)
    data class Statistic(override val key: String = "statistic") : NavigationKey(key = key)
    data class Notification(override val key: String = "notification") : NavigationKey(key = key)
    data class Profile(override val key: String = "profile") : NavigationKey(key = key)
}
