package com.example.weather

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weather.tendays.TenDaysFragment
import com.example.weather.today.TodayFragment
import com.example.weather.tomorrow.TomorrowFragment

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity)  {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = when (position) {
            0 -> TodayFragment()
            1 -> TomorrowFragment()
            else -> TenDaysFragment()
        }
        return fragment
    }
}
