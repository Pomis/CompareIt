package pomis.app.compareit.module

import org.koin.android.AndroidModule
import org.koin.dsl.context.Context
import org.koin.dsl.module.Module
import pomis.app.compareit.repository.CompareitRouter

/**
 * Created by roman on 3/23/18.
 */
class ApiModule : AndroidModule() {

    override fun context() =
        declareContext {
            provide {
                CompareitRouter.create()
            }
        }

}