package pomis.app.compareit.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchResult(
        val keyword: String,

        @SerializedName("productDTOS")
        val products: List<Product>,

        @SerializedName("storeDTOS")
        val stores: List<Store>,

        @SerializedName("typeDTOS")
        val productTypes: List<ProductType>
):Serializable