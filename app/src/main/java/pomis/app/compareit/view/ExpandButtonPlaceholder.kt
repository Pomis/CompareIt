package pomis.app.compareit.view

import android.widget.TextView
import com.mindorks.placeholderview.PlaceHolderView
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import pomis.app.compareit.R
import pomis.app.compareit.model.Location

@Layout(R.layout.item_expander)
class ExpandButtonPlaceholder(val locations: List<Location>, val listView: PlaceHolderView, val callback: (() -> Unit)?) {
    @View(R.id.tv_expand)
    lateinit var tvExpand: TextView

    @Resolve
    fun onResolve() {
        tvExpand.text = "Show ${locations.size-1} other shops"
    }

    @Click(R.id.rl_expandor)
    fun onClick() {
        locations.drop(1)
                .forEach   { listView.addView(LocationPlaceholder(it)) }
                .let       { listView.removeView(this) }
        callback?.invoke()
    }
}