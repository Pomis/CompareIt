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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        basket = activity?.intent?.getSerializableExtra("obj") as Basket
        tv_basket_name_detailed.text = basket.name
        Glide.with(this)
                .load(basket.imageUrl)
                .into(iv_basket_shop_large)
    }
}
