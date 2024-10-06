package vn.finance.navigation

import android.content.Context
import android.content.Intent
import javax.inject.Inject

class NavigationManagerImpl @Inject constructor() : NavigationManager {

    private val activityMap = mutableMapOf<String, String>()

    override fun registerActivity(activityKey: String, className: String) {
        activityMap[activityKey] = className
    }

    override fun startActivityByKey(context: Context, activityKey: String) {
        val className = activityMap[activityKey]
        if (className != null) {
            try {
                val intent = Intent(context, Class.forName(className))
                context.startActivity(intent)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}
