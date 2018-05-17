package pomis.app.compareit.view

import android.widget.TextView
import com.mindorks.placeholderview.Animation
import com.mindorks.placeholderview.annotations.Animate
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import pomis.app.compareit.R
import pomis.app.compareit.model.Location
import pomis.app.materailplotview.Views.PercentageView

@Animate(Animation.FADE_IN_ASC)
@Layout(R.layout.item_location)
class LocationPlaceholder(val location: Location) {
    @View(R.id.tv_label)
    lateinit var tvLabel: TextView

    @View(R.id.tv_sublabel)
    lateinit var tvSublabel: TextView

    @View(R.id.pv_availability)
    lateinit var pvAvailability: PercentageView

    @View(R.id.tv_walking_time)
    lateinit var tvWalkingTime: TextView

    @View(R.id.tv_cost)
    lateinit var tvCost: TextView

    @Resolve
    fun onResolve() {
        tvLabel.text = location.shopName
        tvSublabel.text = location.address
        val perc = (75+((2*Math.random()).toInt())*25)
        pvAvailability.percentage = perc
        pvAvailability.text = "${perc}%"
        tvCost.text = "€${(5+Math.random()*7).toInt()}"
        tvWalkingTime.text = "${(5+Math.random()*10).toInt()} mins"
    }
}