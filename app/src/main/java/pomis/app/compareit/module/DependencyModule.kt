package pomis.app.compareit.module

import android.content.Context
import org.koin.android.AndroidModule
import org.koin.dsl.module.Module
import pomis.app.compareit.model.Basket
import pomis.app.compareit.model.getMockBaskets
import pomis.app.compareit.repository.CompareitRouter

/**
 * Created by roman on 3/23/18.
 */
class DependencyModule(val appContext: Context) : AndroidModule() {

    override fun context() =
        declareContext {
            provide {
                CompareitRouter.create()
            }
            provide {
                getMockBaskets()
            }
            provide {
                appContext
            }
        }

}