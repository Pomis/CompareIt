package pomis.app.compareit.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import pomis.app.compareit.App
import pomis.app.compareit.R
import pomis.app.compareit.base.BaseActivity
import pomis.app.compareit.model.Offer

class OfferDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_details)
    }
}

