package pomis.app.compareit.fragment


import android.os.Bundle
import android.app.Fragment
import android.app.SharedElementCallback
import android.app.inject
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
import pomis.app.compareit.view.ProductPlaceholder
import pomis.app.compareit.view.SeparatorPlaceholder


class BasketsFragment : Fragment() {
    val baskets by inject<ArrayList<Basket>>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_baskets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baskets.map { BasketPlaceholder(it, activity) }.forEach{ phv_baskets.addView(it) }
        phv_baskets.addView(SeparatorPlaceholder())
    }



}
