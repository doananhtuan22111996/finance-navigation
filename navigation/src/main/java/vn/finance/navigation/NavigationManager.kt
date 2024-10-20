package vn.finance.navigation

import android.content.Context
import android.os.Bundle

interface NavigationManager {
    fun registerActivity(activityKey: NavigationKey, className: String)

    fun startActivityByKey(context: Context, activityKey: NavigationKey)

    fun startActivityByKey(context: Context, activityKey: NavigationKey, bundle: Bundle)
}