package pomis.app.compareit.view

import android.app.Activity
import android.os.Build
import android.support.v4.view.ViewCompat.setTransitionName
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.annotations.Click
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import pomis.app.compareit.R
import pomis.app.compareit.activity.TransparentActivity
import pomis.app.compareit.model.Basket


@Layout(R.layout.item_basket)
class BasketPlaceholder(val basket: Basket, val activity: Activity) {
    @View(R.id.iv_basket_shop)
    lateinit var ivBasketShop: ImageView

    @View(R.id.tv_basket_name)
    lateinit var tvBasketName: TextView

    @View(R.id.tv_basket_content)
    lateinit var tvBasketContent: TextView

    @Resolve
    fun onResolve() {
        Glide.with(ivBasketShop.context).load(basket.imageUrl).into(ivBasketShop)
        tvBasketName.text = basket.name
        tvBasketContent.text = basket.items.map{ it.name }.joinToString()
    }

    @Click(R.id.cv_basket)
    fun onClick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            TransparentActivity.start(activity, ivBasketShop, tvBasketName, basket)
        } else {
            // start normally
        }
    }

}