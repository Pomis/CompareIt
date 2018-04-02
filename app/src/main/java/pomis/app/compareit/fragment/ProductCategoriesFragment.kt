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
                .flatMapIterable { it }
                .map { CategoryPlaceholder(it) }
                .subscribe ({ category ->

                    phv_categories.addView(category)
                    api.getCategory(category.category._id)
                            .schedule()
                            .flatMapIterable { it.typeDTOS }
                            .map { TypePlaceholder(it) }
                            .subscribe ({
                                type -> phv_categories.addChildView(category.mParentPosition, type)
                            },{
                                it.printStackTrace()
                            })

                }, {
                    it.printStackTrace()
                    Toast.makeText(activity, "No connection", LENGTH_SHORT).show()
                })

//        phv_categories.addView(CategoryPlaceholder(ProductCategory("fruits")))
//        phv_categories.addChildView(0, TypePlaceholder(ProductType("apple")))

    }
}
