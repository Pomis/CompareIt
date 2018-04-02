package pomis.app.compareit.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by roman on 3/22/18.
 */
data class ProductType(
        @SerializedName("_id")
        val id: Int,

        @SerializedName("productDTOS")
        val items: List<Product>,

        val name: String
):Serializable