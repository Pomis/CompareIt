package pomis.app.compareit.activity

import android.app.FragmentTransaction
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import pomis.app.compareit.R
import pomis.app.compareit.base.BaseActivity
import pomis.app.compareit.fragment.BasketsFragment
import pomis.app.compareit.fragment.OffersFragment
import pomis.app.compareit.fragment.ProductCategoriesFragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import android.graphics.Color.parseColor
import android.R.attr.fragment
import android.app.Fragment
import android.graphics.Color
import android.os.Build
import android.os.Handler
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import pomis.app.compareit.utils.setStatusBarColor

class BottomNavigationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        fragmentManager.beginTransaction().add(R.id.fl_container, OffersFragment(), "content")
                .commit()
        initSearch()
        initBottom()
    }

    private fun initBottom() {
        with(bottom_navigation) {
            addItem(AHBottomNavigationItem(R.string.offers, R.drawable.ic_sale, R.color.colorOffers))
            addItem(AHBottomNavigationItem(R.string.products, R.drawable.ic_shape, R.color.colorProducts))
            addItem(AHBottomNavigationItem(R.string.lists, R.drawable.ic_cart, R.color.colorBaskets))
            isColored = true
            currentItem = 0
            defaultBackgroundColor = Color.WHITE
            setColoredModeColors(Color.WHITE, Color.RED)
            isBehaviorTranslationEnabled = true
            isTranslucentNavigationEnabled = true

            setOnTabSelectedListener({ position, wasSelected ->
                if (!wasSelected) {
                    val (fragment, color) = when(position) {
                        0 -> Pair(OffersFragment(), R.color.colorOffers)
                        1 -> Pair(ProductCategoriesFragment(), R.color.colorProducts)
                        2 -> Pair(BasketsFragment(), R.color.colorBaskets)
                        else -> Pair(Fragment(), R.color.colorPrimary)
                    }

                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_container, fragment, "content").commit()
                    Handler().postDelayed({setStatusBarColor(color)},150)
                }
                true
            })
        }


    }

    private fun initSearch() {
        //
    }
}
