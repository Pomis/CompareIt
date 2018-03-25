package pomis.app.compareit.model

import java.io.Serializable

/**
 * Created by roman on 3/22/18.
 */
data class Offer(
        val name: String,
        val text: String,
        val image: String
):Serializable