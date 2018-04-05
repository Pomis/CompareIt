package pomis.app.compareit.utils

import android.app.Activity
import android.os.Build
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import java.util.concurrent.TimeUnit

fun Activity.setStatusBarColor(@ColorRes colorRes: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = ContextCompat.getColor(this, colorRes)
    }
}
