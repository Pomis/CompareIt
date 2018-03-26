package pomis.app.compareit.fragment

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pomis.app.compareit.R
import pomis.app.compareit.model.ProductType


class BasketProductAddingFragment : Fragment() {
    lateinit var productType: ProductType

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basket_product_adding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productType = activity?.intent?.getSerializableExtra("obj") as ProductType
    }

}
