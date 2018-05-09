package pomis.app.compareit.view

import com.mindorks.placeholderview.PlaceHolderView
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import pomis.app.compareit.R
import pomis.app.compareit.model.Location
import pomis.app.compareit.model.Store


@Layout(R.layout.item_store)
class StoreListPlaceholder(val stores: List<Store>, val listView: PlaceHolderView) {
    lateinit var locations: ArrayList<Location>

    @Resolve
    fun onResolve() {
        stores  .filter     { it.locations != null }
                .map        { x -> x.locations?.forEach { it.shopName = x.name }; x }
                .flatMap    { it.locations!!.asIterable() }
                .map        { locations.add(it); LocationPlaceholder(it) }
                .first()
                .let        { listView.addView(it); listView.addView(ExpandButton(locations, listView)) }
    }


    @Layout(R.layout.item_expander)
    class ExpandButton(val locations: List<Location>, val listView: PlaceHolderView) {
        @Click(R.id.rl_expandor)
        fun onClick() {
            locations.drop(1)
                     .forEach   { listView.addView(LocationPlaceholder(it)) }
                     .let       { listView.removeView(this) }

        }
    }
}