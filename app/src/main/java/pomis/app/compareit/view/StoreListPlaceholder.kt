package pomis.app.compareit.view

import android.widget.TextView
import com.mindorks.placeholderview.PlaceHolderView
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import pomis.app.compareit.R
import pomis.app.compareit.model.Location
import pomis.app.compareit.model.Store


@Layout(R.layout.item_store)
class StoreListPlaceholder(val stores: List<Store>) {
    lateinit var locations: ArrayList<Location>

//    @View(R.id.tv_label)
//    lateinit var tvLabel : TextView

    @View(R.id.phv_locations)
    lateinit var phvLocations: PlaceHolderView

    @Resolve
    fun onResolve() {
//        tvLabel.text = "Stores list"
        locations = ArrayList()



        stores  .map        { x -> x.locations?.forEach { it.shopName = x.name }; x }
                .flatMap    { it.locations!!.asIterable() }
                .map        { locations.add(it); it }//phvLocations.addView(LocationPlaceholder(it)) }
                .first()
                .also       { phvLocations.addView(LocationPlaceholder(it)); phvLocations.addView(ExpandButtonPlaceholder(locations, phvLocations)) }

        //locs .forEach { listView.addView(LocationPlaceholder(it)) }
    }



}