package pomis.app.compareit.fragment

import android.os.Bundle
import android.app.Fragment
import android.app.inject
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.fragment_offers.*
import kotlinx.android.synthetic.main.fragment_type_details.*

import pomis.app.compareit.R
import pomis.app.compareit.model.Basket
import pomis.app.compareit.model.Product
import pomis.app.compareit.model.ProductType
import pomis.app.compareit.repository.CompareitRouter
import pomis.app.compareit.utils.handle
import pomis.app.compareit.utils.schedule
import pomis.app.compareit.view.ProductPlaceholder
import java.util.concurrent.TimeUnit

class TypeDetailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_type_details, container, false)
    }

    private lateinit var productType: ProductType
    private var selectedProduct: Product? = null
        set(value) {
            field = value
            b_add_to_basket.text = "Add ${selectedProduct?.name} to basket"
        }
    private var selectedBasket: Basket? = null

    private val api by inject<CompareitRouter>()
    private val baskets by inject<ArrayList<Basket>>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initButton()
    }

    private fun initList() {
        productType = activity?.intent?.getSerializableExtra("obj") as ProductType
        phv_products.layoutManager = GridLayoutManager(activity, 3)
        phv_products.addView(generateProductTypePlaceholder())
        api.getProductType(productType.id)
                .schedule()
                .flattenAsObservable { it.items }
                .map { ProductPlaceholder(it, { selectedProduct = it }) }
                .handle(activity, {
                    Log.d("KEK", it.product.toString())
                    phv_products.addView(it)
                })
        ms_baskets.setItems(baskets.map { it.name })
        selectedBasket = baskets[0]
        ms_baskets.setOnItemSelectedListener { _, i, _, _ -> selectedBasket = baskets[i] }
    }

    private fun generateProductTypePlaceholder(): ProductPlaceholder {
        val product = Product("any " + productType.name, null)
        val callback = { selectedProduct = product }
        selectedProduct = product
        return ProductPlaceholder(product, callback)
    }

    private fun initButton() {
        RxView.clicks(b_add_to_basket)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe {
                    selectedProduct?.let { selectedBasket?.items?.add(it) }
                    activity.finish()
                }
    }

}

