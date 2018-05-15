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
                Location("Jaama 2", 12.123f, 12.3121f, null),
                Location("Kivi 3", 12.123f, 12.3121f, null),
                Location("Reakoja plats 4", 12.123f, 12.3121f, null),
                Location("Lossi 5", 12.123f, 12.3121f, null),
                Location("Turu 6", 12.123f, 12.3121f, null),
                Location("Narva maantee 21", 12.123f, 12.3121f, null)
        )

        val price1 = Price(Store("MAXIMA", locs), BigDecimal(10), 0.98f)
        val price2 = Price(Store("Selver", locs), BigDecimal(15), 0.93f)
        val price3 = Price(Store("Prisma", locs), BigDecimal(14), 0.91f)
        val price4 = Price(Store("Prisma", locs), BigDecimal(23), 0.91f)
        list.add(Basket(
                "Weekly products",
                "http://volex.ee/wp-content/uploads/2016/05/DCS-32.jpg",
                listOf(price1, price2, price3), price1,
                arrayListOf(Product("cheese", null), Product("meelk", null))))

        list.add(Basket(
                "For birthday cake",
                "https://static1.visitestonia.com/images/1099263/Selver_.jpg",
                listOf(price1, price2, price3), price2,
                arrayListOf(Product("cheese", null), Product("meelk", null))))

        list.add(Basket(
                "Yet another basket",
                "https://f9.pmo.ee/OlAyt5o8uKtucUSyDttgH2yX3to=/685x410/smart/nginx/o/2011/11/02/818206t1h7e43.jpg",
                listOf(price1, price2, price3), price3,
                arrayListOf(Product("cheese", null), Product("meelk", null))))

        list.add(Basket(
                "Yet another basket 2",
                "https://f9.pmo.ee/OlAyt5o8uKtucUSyDttgH2yX3to=/685x410/smart/nginx/o/2011/11/02/818206t1h7e43.jpg",
                listOf(price1, price2, price3), price4,
                arrayListOf(Product("cheese", null), Product("meelk", null))))
    }
    return list

}