package pomis.app.compareit.model

import java.io.Serializable
import java.util.*

/**
 * Created by roman on 3/22/18.
 */
data class Offer(
        val name: String,
        val text: String,
        val startDate: Date,
        val endDate: Date,
        val imageURL: String,
        val store: Store
):Serializable