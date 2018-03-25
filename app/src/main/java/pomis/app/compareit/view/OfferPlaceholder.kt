package pomis.app.compareit.view

import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mindorks.placeholderview.annotations.*
import pomis.app.compareit.R
import pomis.app.compareit.activity.OfferDetailsActivity
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
        Glide.with(background).load(offer.image).into(background)
    }

    @Click(R.id.cv_card)
    fun onClick() {
        val intent = Intent(background.context, OfferDetailsActivity::class.java)
        intent.putExtra("offer", offer)
        background.context.startActivity(intent)
    }
}