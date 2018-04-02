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

class BottomNavigationActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fragmentManager.beginTransaction().replace(R.id.fl_container, OffersFragment(), "content").commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_container, ProductCategoriesFragment(), "content").commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragmentManager.beginTransaction()
                        .replace(R.id.fl_container, BasketsFragment(), "content").commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        fragmentManager.beginTransaction().add(R.id.fl_container, OffersFragment(), "content").commit()
        bnv_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initSearch()
    }

    private fun initSearch() {
        //
    }
}
