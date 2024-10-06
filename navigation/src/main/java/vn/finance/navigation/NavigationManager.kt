package vn.finance.navigation

import android.content.Context

interface NavigationManager {
    fun registerActivity(activityKey: NavigationKey, className: String)

    fun startActivityByKey(context: Context, activityKey: NavigationKey)
}