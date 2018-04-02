package pomis.app.compareit.view

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import pomis.app.compareit.R
import pomis.app.compareit.model.Product

@Layout(R.layout.item_product)
class ProductPlaceholder(val product : Product) {
    @View(R.id.tv_product_name)
    lateinit var tvProductName: TextView

    @View(R.id.iv_product_photo)
    lateinit var ivProductPhoto: ImageView

    @Resolve
    fun onResolve() {
        tvProductName.text = product.name
        if (product.imageDTO!=null)
            Glide.with(ivProductPhoto).load(product.imageDTO.links.get(0).href).into(ivProductPhoto)
    }

}