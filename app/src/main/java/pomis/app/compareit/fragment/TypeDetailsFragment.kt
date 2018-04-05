package pomis.app.compareit.fragment

import android.os.Bundle
import android.app.Fragment
import android.app.inject
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


class TypeDetailsFragment : Fragment() {
    lateinit var productType: ProductType

    val api by inject<CompareitRouter>()
    val baskets by inject<ArrayList<Basket>>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_type_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productType = activity?.intent?.getSerializableExtra("obj") as ProductType
        b_add_to_basket.text = "Add any ${productType.name} to basket"
        phv_products.layoutManager = GridLayoutManager(activity, 3)
        phv_products.addView(ProductPlaceholder(Product(
                "any "+productType.name, null
        )))
        api.getProductType(productType.id)
                .schedule()
                .flattenAsObservable { it.items }
                .map { ProductPlaceholder(it) }
                .handle(activity, {
                    Log.d("KEK", it.product.toString())
                    phv_products.addView(it)
                })
        ms_baskets.setItems(baskets.map { it.name })
        ms_baskets.setOnItemSelectedListener{ _, i, _, _ -> baskets[i].items.add(Product(productType.name, null)) }
    }

}
