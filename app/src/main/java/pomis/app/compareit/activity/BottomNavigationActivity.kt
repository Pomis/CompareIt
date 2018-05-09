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
import android.app.inject
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.view.size
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.jakewharton.rxbinding2.widget.RxSearchView
import com.jakewharton.rxbinding2.widget.RxTextView
import es.dmoral.toasty.Toasty
import pomis.app.compareit.R.id.search_bar_text
import pomis.app.compareit.fragment.SearchResultFragment
import pomis.app.compareit.model.SearchResult
import pomis.app.compareit.repository.CompareitRouter
import pomis.app.compareit.utils.ErrorHandler
import pomis.app.compareit.utils.schedule
import pomis.app.compareit.utils.scheduleFlat
import pomis.app.compareit.utils.setStatusBarColor
import java.util.concurrent.TimeUnit

class BottomNavigationActivity : BaseActivity() {
    val api by inject<CompareitRouter>()
    lateinit var fragmentAndColor: Pair<Fragment, Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        fragmentManager.beginTransaction().add(R.id.fl_container, OffersFragment(), "content")
                .commit()
        initSearch()
        initBottom()
    }

    override fun onBackPressed() {}

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
                    changeFragment(position)
                }
                true
            })
        }
    }


    private fun changeFragment(position: Int) {
        fragmentAndColor = when (position) {
            0 -> Pair(OffersFragment(), R.color.colorOffers)
            1 -> Pair(ProductCategoriesFragment(), R.color.colorProducts)
            2 -> Pair(BasketsFragment(), R.color.colorBaskets)
            3 -> Pair(SearchResultFragment(), R.color.colorSearch)
            else -> Pair(Fragment(), R.color.colorPrimary)
        }
        fragmentManager.beginTransaction()
                .replace(R.id.fl_container, fragmentAndColor.first, "content").commit()
        Handler().postDelayed({
            setStatusBarColor(fragmentAndColor.second)
            if (position != 3) bottom_navigation.removeItemAtIndex(3)
        }, 150)
    }

    private fun initSearch() {
        RxTextView.afterTextChangeEvents(findViewById<EditText>(R.id.search_bar_text))
                .skipInitialValue()
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter { it != null && !it.editable().isNullOrBlank() }
                .distinctUntilChanged()
                .switchMap { api.search(it.editable().toString()) }
                .scheduleFlat()
                .onErrorReturn { null }
                .retry()
                .subscribe({
                    if (bottom_navigation.itemsCount < 4)
                        bottom_navigation.addItem(AHBottomNavigationItem(R.string.search, R.drawable.ic_sale, R.color.colorSearch))
                    bottom_navigation.setCurrentItem(3, true)
                    (fragmentAndColor.first as SearchResultFragment).searchResult = it
                }, {
                    ErrorHandler.handle(it, this)
                })
    }
}
