package pomis.app.compareit.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by roman on 3/22/18.
 */
data class Product(
        val name: String,
        val imageURL: String?
):Serializable
