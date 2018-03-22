package pomis.app.compareit.model

import java.math.BigDecimal

/**
 * Created by roman on 3/22/18.
 */
data class Basket(
        val name: String,
        val watching: Boolean, // if user wants to receive notifications when price is lower than...
        val priceThreshold: BigDecimal?, // than this value
        val priceCurrent: BigDecimal,
        val items: List<Product>
)