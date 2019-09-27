package m.vk.k023_viewpager2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import m.vk.k023_viewpager2.fragment.*

class ViewPagerAdapter internal constructor(fm: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        lateinit var fragment: Fragment
        when (position) {
            0 -> fragment = OneFragment()
            1 -> fragment = TwoFragment()
            2 -> fragment = ThreeFragment()
            3 -> fragment = FourFragment()
            4 -> fragment = FiveFragment()
        }
        return fragment
    }

}