package pomis.app.compareit

import android.app.Application
import org.koin.Koin
import org.koin.KoinContext
import org.koin.android.KoinContextAware
import org.koin.android.init
import pomis.app.compareit.module.ApiModule

class App : Application(), KoinContextAware {
    override fun getKoin(): KoinContext {
        return context
    }

    lateinit var context: KoinContext


    override fun onCreate() {
        super.onCreate()
        context = Koin().init(this).build(ApiModule())
    }
}

