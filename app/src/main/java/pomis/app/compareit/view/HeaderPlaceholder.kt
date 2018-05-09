package pomis.app.compareit.view

import android.widget.TextView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import pomis.app.compareit.R

@Layout(R.layout.item_header)
class HeaderPlaceholder(val text: String, val badge: String) {

    @View(R.id.tv_header)
    private lateinit var tvHeader: TextView

    @View(R.id.tv_badge)
    private lateinit var tvBadge: TextView


    @Resolve
    private fun onResolve() {
        tvHeader.text = text
        tvBadge.text = badge
    }
}