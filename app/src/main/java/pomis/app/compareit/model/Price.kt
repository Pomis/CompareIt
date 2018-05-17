package pomis.app.compareit.model

import java.io.Serializable
import java.math.BigDecimal

data class Price(
        val store: Store,
        val price: BigDecimal
):Serializable