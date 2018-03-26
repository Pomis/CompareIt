package pomis.app.compareit.view

import android.content.Intent
import android.widget.TextView
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import pomis.app.compareit.model.ProductType
import com.mindorks.placeholderview.annotations.expand.ChildPosition
import com.mindorks.placeholderview.annotations.expand.ParentPosition
import kotlinx.android.synthetic.main.item_type.view.*
import pomis.app.compareit.R
import pomis.app.compareit.activity.TransparentActivity

@Layout(R.layout.item_type)
class TypePlaceholder(val productType: ProductType) {

    @ParentPosition
    var parentPosition: Int = 0

    @ChildPosition
    var childPosition: Int = 0

    @View(R.id.tv_type)
    lateinit var tvType: TextView

    @Resolve
    fun onResolve() {
        tvType.text = productType.name
    }

    @Click(R.id.rl_type)
    fun onClick() {
        TransparentActivity.start(tvType.context, productType)
    }

}