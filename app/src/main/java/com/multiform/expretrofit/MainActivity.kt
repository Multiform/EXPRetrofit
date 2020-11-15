package com.multiform.expretrofit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.multiform.expretrofit.databinding.ActivityMainBinding
import com.multiform.expretrofit.ui.screens.MoviesFragment
import com.multiform.expretrofit.ui.screens.RuMoviesFragment
import com.multiform.expretrofit.ui.screens.SerialsFragment
import com.multiform.expretrofit.utils.APP_ACTIVITY
import com.multiform.expretrofit.utils.showToast


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        APP_ACTIVITY = this

        window.statusBarColor = ContextCompat.getColor(this, R.color.backgroundColorDark)

        mainBinding.containerPagers.adapter = ViewPagerAdapter(supportFragmentManager)
        mainBinding.tabViewPager.setupWithViewPager(mainBinding.containerPagers)

        mainBinding.containerPagers.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                showToast("$position page!")
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    inner class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> MoviesFragment()
                1 -> SerialsFragment()
                else -> RuMoviesFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position) {
                0 -> "MOVIES"
                1 -> "SERIALS"
                else -> "RU MOVIES"
            }
        }
    }
}