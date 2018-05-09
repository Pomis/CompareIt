package pomis.app.compareit.model

import java.io.Serializable

/**
 * Created by roman on 3/22/18.
 */
class Store (
        val name: String,
        val locations: List<Location>?
):Serializable