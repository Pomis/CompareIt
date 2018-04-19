package pomis.app.compareit.fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_search_result.*

import pomis.app.compareit.R
import pomis.app.compareit.model.Product
import pomis.app.compareit.model.SearchResult
import pomis.app.compareit.view.ProductPlaceholder


class SearchResultFragment : Fragment() {
    lateinit var searchResult : SearchResult

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchResult.productTypes.forEach { phv_search.addView(ProductPlaceholder(Product(it.name, null))) }
        searchResult.products.forEach { phv_search.addView(ProductPlaceholder(it)) }
//        searchResult.stores.forEach { phv_search.addView((Product(it.name, null))) }
    }


}
