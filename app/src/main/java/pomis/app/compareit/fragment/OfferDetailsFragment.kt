package pomis.app.compareit.fragment
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_offer_details.*

import pomis.app.compareit.R
import pomis.app.compareit.model.Offer


class OfferDetailsFragment : Fragment() {
    lateinit var offer: Offer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_offer_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fill()
    }

    fun fill() {
        offer = activity?.intent?.getSerializableExtra("offer") as Offer
        tv_offer_title.text = offer.name
        tv_offer_description.text = offer.text
        Glide.with(activity).load(offer.image).into(iv_offer_image)
    }

}
