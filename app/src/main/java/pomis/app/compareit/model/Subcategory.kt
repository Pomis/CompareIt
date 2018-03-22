package pomis.app.compareit.model

/**
 * Created by roman on 3/22/18.
 */
data class Subcategory(
        val id: String,
        val items: List<StoreItem>,
        val name: String
)