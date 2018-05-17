package pomis.app.compareit.model

import java.io.Serializable

data class Location(
    val address: String,
    val lat: Float,
    val lon: Float,
    var shopName: String?,
    var availability: Int?
):Serializable