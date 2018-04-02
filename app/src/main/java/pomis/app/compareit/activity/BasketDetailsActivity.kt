package pomis.app.compareit.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.app.ActivityOptions
import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_basket_details.*
import pomis.app.compareit.R

class BasketDetailsActivity : Activity() {
    companion object {
        fun launch(activity: Activity, sharedView: View) {
            val transitionName = "trans"
            val launcher = Intent(activity, BasketDetailsActivity::class.java)

            val options = ActivityOptions
                    .makeSceneTransitionAnimation(activity, sharedView, transitionName)
            activity.startActivity(launcher, options.toBundle())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket_details)
        postponeEnterTransition()
        Glide.with(this)
                .load("https://static1.visitestonia.com/images/1099263/Selver_.jpg")
                .into(iv_basket_shop_large)
        startPostponedEnterTransition()

    }


    private fun getListener(): RequestListener<Drawable>? {
        return object: RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                startPostponedEnterTransition()
                return true
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                startPostponedEnterTransition()
                return true
            }
        }
    }
}
