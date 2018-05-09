package pomis.app.compareit.fragment

import android.os.Bundle
import android.app.Fragment
import android.app.inject
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_product_categories.*

import pomis.app.compareit.R
import pomis.app.compareit.repository.CompareitRouter
import pomis.app.compareit.utils.handle
import pomis.app.compareit.utils.schedule
import pomis.app.compareit.view.CategoryPlaceholder
import pomis.app.compareit.view.ProductTypePlaceholder

class ProductCategoriesFragment : Fragment() {
    val api by inject<CompareitRouter>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_categories, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        api.getCategories()
                .schedule()
                .map { CategoryPlaceholder(it) }
                .handle(activity, { c ->
                    spin_kit.visibility = View.GONE
                    phv_categories.addView(c)
                    c.category.typeDTOS
                            .map { ProductTypePlaceholder(it) }
                            .forEach { phv_categories.addChildView(c.mParentPosition, it) }
                })
    }
}
