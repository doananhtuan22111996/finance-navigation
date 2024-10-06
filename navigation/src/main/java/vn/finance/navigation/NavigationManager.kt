package vn.finance.navigation

import android.content.Context

interface NavigationManager {
    fun registerActivity(activityKey: String, className: String)

    fun startActivityByKey(context: Context, activityKey: String)
}