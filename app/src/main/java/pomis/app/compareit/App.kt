package pomis.app.compareit

import android.app.Application
import android.content.Context
import org.koin.Koin
import org.koin.KoinContext
import org.koin.android.KoinContextAware
import org.koin.android.init
import pomis.app.compareit.module.DependencyModule

class App : Application(), KoinContextAware {
    override fun getKoin(): KoinContext {
        return koinContext
    }

    lateinit var koinContext: KoinContext

    override fun onCreate() {
        super.onCreate()
        koinContext = Koin().init(this).build(DependencyModule(this))
    }
}

