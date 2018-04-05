package pomis.app.compareit.fragment

import android.os.Bundle
import android.app.Fragment
import android.app.inject
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_product_categories.*

import pomis.app.compareit.R
import pomis.app.compareit.model.ProductCategory
import pomis.app.compareit.model.ProductType
import pomis.app.compareit.repository.CompareitRouter
import pomis.app.compareit.utils.handle
import pomis.app.compareit.utils.schedule
import pomis.app.compareit.view.CategoryPlaceholder
import pomis.app.compareit.view.TypePlaceholder
import java.util.*

class ProductCategoriesFragment : Fragment() {
    val api by inject<CompareitRouter>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_categories, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        api.getCategories()
                .schedule()
                .map { CategoryPlaceholder(it) }
                .handle(activity, { c ->
                    phv_categories.addView(c)
                    c.category.typeDTOS
                            .map { TypePlaceholder(it) }
                            .forEach { phv_categories.addChildView(c.mParentPosition, it) }
                })
    }
}
