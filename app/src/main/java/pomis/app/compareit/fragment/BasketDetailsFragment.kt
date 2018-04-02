package pomis.app.compareit.fragment

import android.os.Bundle
import android.app.Fragment
import android.app.SharedElementCallback
import android.os.Build
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_basket_details.*
import pomis.app.compareit.R
import android.graphics.drawable.Drawable
import android.media.Image
import android.support.annotation.Nullable
import android.support.annotation.RequiresApi
import android.support.v4.view.ViewCompat
import android.widget.ImageView
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.Glide
import pomis.app.compareit.model.Basket
import javax.sql.DataSource
import android.widget.TextView
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.item_basket.*

class BasketDetailsFragment : Fragment() {
    lateinit var basket: Basket

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basket_details, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            sharedElementEnterTransition = TransitionInflater.from(context)
//                    .inflateTransition(R.transition.transition_shared_basket)
                    .inflateTransition(android.R.transition.move)

//            postponeEnterTransition()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition()
    }

    fun enterTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            basket = arguments.getSerializable("obj") as Basket
            val transitionName = arguments.getString("transitionName")

//            ViewCompat.setTransitionName(iv_basket_shop_large, transitionName)
//            ViewCompat.setTransitionName(tv_basket_name_detailed, transitionName)

            startPostponedEnterTransition()

//            tv_basket_name_detailed.text = basket.name
            Glide.with(context)
                    .load(basket.imageUrl)
                    .listener(object: RequestListener<Drawable?> {
                        @RequiresApi(Build.VERSION_CODES.O)
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable?>?, isFirstResource: Boolean): Boolean {
                            startPostponedEnterTransition()
                            return false
                        }

                        @RequiresApi(Build.VERSION_CODES.O)
                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable?>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                            startPostponedEnterTransition()
                            return false
                        }
                    })
//                    .into(iv_basket_shop_large as ImageView)

        }
    }
    companion object {
        fun newInstance(basket: Basket, transitionName: String): BasketDetailsFragment {
            val fragment = BasketDetailsFragment()
            val bundle = Bundle()
            bundle.putSerializable("obj", basket)
            bundle.putString("transitionName", transitionName)
            fragment.setArguments(bundle)
            return fragment
        }
    }



}
