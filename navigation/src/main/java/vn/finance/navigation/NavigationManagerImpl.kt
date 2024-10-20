package vn.finance.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import javax.inject.Inject

class NavigationManagerImpl @Inject constructor() : NavigationManager {

    private val activityMap = mutableMapOf<String, String>()

    override fun registerActivity(activityKey: NavigationKey, className: String) {
        activityMap[activityKey.key] = className
    }

    override fun startActivityByKey(context: Context, activityKey: NavigationKey) {
        val className = activityMap[activityKey.key]
        if (className != null) {
            try {
                val intent = Intent(context, Class.forName(className))
                context.startActivity(intent)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun startActivityByKey(context: Context, activityKey: NavigationKey, bundle: Bundle) {
        val className = activityMap[activityKey.key]
        if (className != null) {
            try {
                val intent = Intent(context, Class.forName(className))
                intent.putExtras(bundle)
                context.startActivity(intent)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}
