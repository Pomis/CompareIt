package pomis.app.compareit.fragment

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_search_result.*

import pomis.app.compareit.R
import pomis.app.compareit.activity.TransparentActivity
import pomis.app.compareit.model.Product
import pomis.app.compareit.model.SearchResult
import pomis.app.compareit.view.HeaderPlaceholder
import pomis.app.compareit.view.ProductPlaceholder
import pomis.app.compareit.view.ProductTypePlaceholder


class SearchResultFragment : Fragment() {
    var searchResult: SearchResult? = null
        set(value) {
            field = value; updateLists()
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateLists()
    }

    private fun updateLists() {
        phv_search?.run{
            removeAllViews()

            addView(HeaderPlaceholder("Product types", "${searchResult?.productTypes?.size}"))
            searchResult?.productTypes?.forEach { addView(ProductTypePlaceholder(it)) }

            addView(HeaderPlaceholder("Products", "${searchResult?.products?.size}"))
            searchResult?.products?.forEach { addView(ProductPlaceholder(it, { TransparentActivity.start(activity, it) })) }

            addView(HeaderPlaceholder("Stores", "${searchResult?.stores?.size}"))
            searchResult?.stores?.forEach { addView(ProductPlaceholder(Product(it.name, it.imageURL), null)) }

            refresh()
        }
    }


}
