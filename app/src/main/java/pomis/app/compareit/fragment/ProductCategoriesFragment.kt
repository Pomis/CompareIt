package pomis.app.compareit.fragment

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_product_categories.*

import pomis.app.compareit.R
import pomis.app.compareit.model.ProductCategory
import pomis.app.compareit.model.ProductType
import pomis.app.compareit.view.CategoryPlaceholder
import pomis.app.compareit.view.TypePlaceholder

class ProductCategoriesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_categories, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phv_categories.addView(CategoryPlaceholder(ProductCategory("fruits")))
        phv_categories.addChildView(0, TypePlaceholder(ProductType("apple")))
        phv_categories.addChildView(0, TypePlaceholder(ProductType("apfelsin")))
        phv_categories.addChildView(0, TypePlaceholder(ProductType("mango")))
        phv_categories.addView(CategoryPlaceholder(ProductCategory("milk products")))
        phv_categories.addChildView(1, TypePlaceholder(ProductType("kefiir")))
        phv_categories.addChildView(1, TypePlaceholder(ProductType("tvorog")))
        phv_categories.addChildView(1, TypePlaceholder(ProductType("piim")))
        phv_categories.addView(CategoryPlaceholder(ProductCategory("test123")))
        phv_categories.addView(CategoryPlaceholder(ProductCategory("312312")))

    }
}
