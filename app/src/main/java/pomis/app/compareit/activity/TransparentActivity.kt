package pomis.app.compareit.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import pomis.app.compareit.App
import pomis.app.compareit.R
import pomis.app.compareit.base.BaseActivity
import pomis.app.compareit.fragment.BasketProductAddingFragment
import pomis.app.compareit.fragment.OfferDetailsFragment
import pomis.app.compareit.fragment.OffersFragment
import pomis.app.compareit.model.Offer
import pomis.app.compareit.model.ProductType
import java.io.Serializable

class TransparentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_details)

        val fragment = when(intent.getSerializableExtra("obj")) {
            is Offer        -> OfferDetailsFragment()
            is ProductType  -> BasketProductAddingFragment()
            else            -> null
        }
        fragmentManager.beginTransaction().add(R.id.fl_details, fragment, "content").commit()
    }

    companion object Factory {
        fun start(context: Context, obj: Serializable) {
            val intent = Intent(context, TransparentActivity::class.java)
            intent.putExtra("obj", obj )
            context.startActivity(intent)
        }
    }
}

