package pomis.app.compareit.model

import kotlinx.android.synthetic.main.fragment_baskets.*
import pomis.app.compareit.view.BasketPlaceholder
import java.io.Serializable
import java.math.BigDecimal

/**
 * Created by roman on 3/22/18.
 */
data class Basket(
        val name: String,
        val imageUrl: String,
        val prices: List<Price>,
        val bestPrice: Price,
        var items: ArrayList<Product>
):Serializable


//        val watching: Boolean, // if user wants to receive notifications when price is lower than...
//        val priceThreshold: BigDecimal?, // than this value
//        val priceCurrent: BigDecimal,
var list: ArrayList<Basket> = ArrayList()

fun getMockBaskets():ArrayList<Basket>{
    if (list.size == 0) {
        val locs = listOf<Location>(
                Location("Jaama 2", 12.123f, 12.3121f, null, 100),
                Location("Kivi 3", 12.123f, 12.3121f, null, 75),
                Location("Reakoja plats 4", 12.123f, 12.3121f, null, 66),
                Location("Lossi 5", 12.123f, 12.3121f, null,50),
                Location("Turu 6", 12.123f, 12.3121f, null, 66),
                Location("Narva maantee 21", 12.123f, 12.3121f, null, 75)
        )

        val price1 = Price(Store("MAXIMA", locs, null), BigDecimal(10))
        val price2 = Price(Store("Selver", locs, null), BigDecimal(15))
        val price3 = Price(Store("Prisma", locs, null), BigDecimal(14))
        val price4 = Price(Store("Prisma", locs, null), BigDecimal(23))
        list.add(Basket(
                "Weekly products",
                "http://volex.ee/wp-content/uploads/2016/05/DCS-32.jpg",
                listOf(price1, price2, price3), price1,
                arrayListOf(
                        Product("Black bread", null),
                        Product("Milk Tere 2.5%", null),
                        Product("Oranges", null),
                        Product("Eesti juust", null),
                        Product("Coca-cola 1.5l", null)
                )))

        list.add(Basket(
                "For birthday party",
                "https://static1.visitestonia.com/images/1099263/Selver_.jpg",
                listOf(price1, price2, price3), price2,
                arrayListOf(
                        Product("Jack Daniels 0.7l", null),
                        Product("Jim Beam 0.5l", null)
                )))

        list.add(Basket(
                "Yet another basket",
                "https://f9.pmo.ee/OlAyt5o8uKtucUSyDttgH2yX3to=/685x410/smart/nginx/o/2011/11/02/818206t1h7e43.jpg",
                listOf(price1, price2, price3), price3,
                arrayListOf(Product("cheese", null), Product("meelk", null))))
    }
    return list

}