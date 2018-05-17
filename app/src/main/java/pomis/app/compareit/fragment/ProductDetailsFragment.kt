package pomis.app.compareit.fragment


import android.app.Fragment
import android.app.inject
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_basket_details.*
import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlinx.android.synthetic.main.fragment_type_details.*

import pomis.app.compareit.R
import pomis.app.compareit.model.Basket
import pomis.app.compareit.model.Product
import pomis.app.compareit.model.ProductType
import pomis.app.compareit.repository.CompareitRouter
import pomis.app.compareit.utils.handle
import pomis.app.compareit.utils.schedule
import pomis.app.compareit.view.StoreListPlaceholder
import java.util.concurrent.TimeUnit

class ProductDetailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    private val api by inject<CompareitRouter>()
    private val baskets by inject<ArrayList<Basket>>()
    private var product: Product? = null
    private var selectedBasket: Basket? = null



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readIntent()
        initButton()
    }

    private fun readIntent() {
        ms_product_baskets.setItems(baskets.map { it.name })
        selectedBasket = baskets[0]
        ms_product_baskets.setOnItemSelectedListener { _, i, _, _ -> selectedBasket = baskets[i] }

        product = (activity?.intent?.getSerializableExtra("obj") as Product)
                        ?.apply {
                            tv_product_name.text = name
                            b_add_product_to_basket.text = "Add ${name} to ${selectedBasket?.name}"
                            Glide.with(activity).load(imageURL).into(iv_product)
                        }


    }

    private fun initButton() {
        RxView.clicks(b_add_product_to_basket)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe {
                    product?.let { selectedBasket?.items?.add(it) }
                    activity.finish()
                }
    }

}
