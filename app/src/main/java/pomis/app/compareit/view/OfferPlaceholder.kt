package pomis.app.compareit.view

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.Animation
import com.mindorks.placeholderview.annotations.*
import pomis.app.compareit.R
import pomis.app.compareit.activity.TransparentActivity
import pomis.app.compareit.model.Offer

@Layout(R.layout.item_offer)
@NonReusable
open class OfferPlaceholder(private val offer: Offer) {

    @View(R.id.tv_label)
    lateinit var label: TextView

    @View(R.id.iv_bg)
    lateinit var background: ImageView

    @Resolve
    fun onResolve() {
        label.text = offer.name
        Glide.with(background).load(offer.imageURL).into(background)
    }

    @Click(R.id.cv_card)
    fun onClick() {
        TransparentActivity.start(background.context, offer)
    }
}