package pomis.app.compareit.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_search_result.*
import kotlinx.android.synthetic.main.fragment_type_details.*

import pomis.app.compareit.R
import pomis.app.compareit.model.Product
import pomis.app.compareit.model.SearchResult
import pomis.app.compareit.view.ProductPlaceholder


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
        phv_search.layoutManager = GridLayoutManager(activity, 3)
        updateLists()
    }

    private fun updateLists() {
        if (phv_search != null) {
            Log.d("KEK", "updateLists()")
            phv_search.removeAllViews();
            searchResult?.productTypes?.forEach { phv_search.addView(ProductPlaceholder(Product(it.name, null))) }
            searchResult?.products?.forEach { phv_search.addView(ProductPlaceholder(it)) }
            //        searchResult.stores.forEach { phv_search.addView((Product(it.name, null))) }
            phv_search.refresh();
        }
    }


}
