package pomis.app.compareit.fragment


import android.os.Bundle
import android.app.Fragment
import android.app.SharedElementCallback
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_baskets.*

import pomis.app.compareit.R
import pomis.app.compareit.model.Basket
import pomis.app.compareit.model.Product
import pomis.app.compareit.view.BasketPlaceholder
import java.math.BigDecimal
import android.support.v7.widget.RecyclerView
import android.transition.TransitionInflater


class BasketsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_baskets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phv_baskets.addView(BasketPlaceholder(Basket(
                "Weekly products", "http://volex.ee/wp-content/uploads/2016/05/DCS-32.jpg",
                BigDecimal(10), listOf(Product("cheese"), Product("meelk"))
        ), activity))
        phv_baskets.addView(BasketPlaceholder(Basket(
                "HHHH Productz", "https://static1.visitestonia.com/images/1099263/Selver_.jpg",
                BigDecimal(10), listOf(Product("cheese"), Product("meelk"))
        ), activity))
        phv_baskets.addView(BasketPlaceholder(Basket(
                "Yet another basket", "https://f9.pmo.ee/OlAyt5o8uKtucUSyDttgH2yX3to=/685x410/smart/nginx/o/2011/11/02/818206t1h7e43.jpg",
                BigDecimal(10), listOf(Product("cheese"), Product("meelk"))
        ), activity))
    }



}
