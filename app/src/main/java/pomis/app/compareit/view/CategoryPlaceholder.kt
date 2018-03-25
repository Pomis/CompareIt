package pomis.app.compareit.view

import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.expand.Parent
import com.mindorks.placeholderview.annotations.expand.SingleTop
import pomis.app.compareit.R
import pomis.app.compareit.model.ProductCategory

/**
 * Created by roman on 3/25/18.
 */
@Parent
@SingleTop
@Layout(R.layout.item_category)
class CategoryPlaceholder(category: ProductCategory) {
    @Resolve
    fun onResolve() {

    }
}