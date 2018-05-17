package pomis.app.compareit.activity

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.TextView
import pomis.app.compareit.R
import pomis.app.compareit.base.BaseActivity
import pomis.app.compareit.fragment.BasketDetailsFragment
import pomis.app.compareit.fragment.TypeDetailsFragment
import pomis.app.compareit.fragment.OfferDetailsFragment
import pomis.app.compareit.fragment.ProductDetailsFragment
import pomis.app.compareit.model.Basket
import pomis.app.compareit.model.Offer
import pomis.app.compareit.model.Product
import pomis.app.compareit.model.ProductType
import java.io.Serializable

class TransparentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_details)

        val fragment = when(intent.getSerializableExtra("obj")) {
            is Offer        -> OfferDetailsFragment()
            is ProductType  -> TypeDetailsFragment()
            is Product      -> ProductDetailsFragment()
            is Basket       -> BasketDetailsFragment()
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

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun start(activity: Activity, sharedView: View, textView: TextView, basket: Basket) {
            val pairImage = android.util.Pair<View, String>(sharedView, "trans")
            val pairText = android.util.Pair<View, String>(textView, "transText")

            var launcher = Intent(activity, TransparentActivity::class.java)
            launcher.putExtra("obj", basket)
            val options = ActivityOptions
                    .makeSceneTransitionAnimation(activity, pairImage, pairText)
            activity.startActivity(launcher, options.toBundle())
        }
    }
}

