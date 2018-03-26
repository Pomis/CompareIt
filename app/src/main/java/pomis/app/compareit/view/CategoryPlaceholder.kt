package pomis.app.compareit.view

import android.media.Image
import android.widget.ImageView
import android.widget.TextView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.expand.*
import pomis.app.compareit.R
import pomis.app.compareit.model.ProductCategory

@Parent
@SingleTop
@Layout(R.layout.item_category)
class CategoryPlaceholder(val category: ProductCategory) {

    @View(R.id.tv_category_title)
    lateinit var tvTitle: TextView

    @View(R.id.iv_arrow)
    lateinit var ivArrow: ImageView

    @ParentPosition
    var mParentPosition: Int = 0

    @Resolve
    fun onResolve() {
        tvTitle.text = category.name
    }

    @Expand
    fun onExpand() {
        ivArrow.animate().rotation(180f).setDuration(500).start();
    }

    @Collapse
    fun onCollapse() {
        ivArrow.animate().rotation(0f).setDuration(500).start();
    }
}