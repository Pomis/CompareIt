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


class OffersFragment : Fragment() {
    val api by inject<CompareitRouter>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_offers, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phv_offers.layoutManager = GridLayoutManager(activity, 2)
        phv_offers.addView(OfferPlaceholder(Offer(
                "Liquid Liquidation!","description sdfjsdklfjsdlkfjskldjf klsdjf lkdjf l",
                "https://avatars.mds.yandex.net/get-pdb/872807/9c81bef6-a368-4756-b85b-443e659f96ea/s1200")))
        phv_offers.addView(OfferPlaceholder(Offer(
                "Cheese cheesing!", "description sdfjsdklfjsdlkfjskldjf klsdjf lkdjf l",
                "https://avatars.mds.yandex.net/get-pdb/872807/9c81bef6-a368-4756-b85b-443e659f96ea/s1200")))
        phv_offers.addView(OfferPlaceholder(Offer(
                "Beer bearing!","description sdfjsdklfjsdlkfjskldjf klsdjf lkdjf l",
                "http://toptenliquors.com/app/uploads/2016/02/Beer-Bomber-Sale-FB-Event-e1456180353233.jpg")))
        phv_offers.addView(OfferPlaceholder(Offer(
                "Cheese cheesing!","description sdfjsdklfjsdlkfjskldjf klsdjf lkdjf l",
                "https://avatars.mds.yandex.net/get-pdb/872807/9c81bef6-a368-4756-b85b-443e659f96ea/s1200")))
        phv_offers.addView(OfferPlaceholder(Offer(
                "Beer bearing!","description sdfjsdklfjsdlkfjskldjf klsdjf lkdjf l",
                "http://toptenliquors.com/app/uploads/2016/02/Beer-Bomber-Sale-FB-Event-e1456180353233.jpg")))
    }
}