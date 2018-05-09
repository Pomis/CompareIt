package pomis.app.compareit.fragment


import android.os.Bundle
import android.app.Fragment
import android.app.inject
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_offers.*

import pomis.app.compareit.R
import pomis.app.compareit.model.Offer
import pomis.app.compareit.view.OfferPlaceholder
import pomis.app.compareit.repository.CompareitRouter
import pomis.app.compareit.utils.ErrorHandler
import pomis.app.compareit.utils.handle
import pomis.app.compareit.utils.schedule


class OffersFragment : Fragment() {
    val api by inject<CompareitRouter>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_offers, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phv_offers.layoutManager = GridLayoutManager(activity, 2)
        api.getOffers().schedule()
                .map { OfferPlaceholder(it) }
                .handle(activity, {
                    phv_offers.addView(it)
                    spin_kit.visibility = View.GONE
                })
    }
}