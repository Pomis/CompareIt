package pomis.app.compareit.model

/**
 * Created by roman on 3/22/18.
 */
data class ProductCategory(
        val _id: Int,
        val name: String,
        val typeDTOS: List<ProductType>
)