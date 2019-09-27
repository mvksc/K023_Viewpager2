package m.vk.k023_viewpager2.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import m.vk.k023_viewpager2.transformer.ZoomOutPageTransformer
import m.vk.k023_viewpager2.R
import m.vk.k023_viewpager2.adapter.ViewPagerAdapter
import m.vk.k023_viewpager2.databinding.ActivityMainBinding
import m.vk.k023_viewpager2.transformer.DepthPageTransformer

class MainActivity : AppCompatActivity(),View.OnClickListener{

    companion object{
        lateinit var binding: ActivityMainBinding
        lateinit var viewPagerAdapter: ViewPagerAdapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = viewPagerAdapter

        binding.viewPager2.setPageTransformer(ZoomOutPageTransformer())//or see more https://github.com/geftimov/android-viewpager-transformers

        binding.tvMenuOne.setOnClickListener(this)
        binding.tvMenuTwo.setOnClickListener(this)
        binding.tvMenuThree.setOnClickListener(this)
        binding.tvMenuFour.setOnClickListener(this)
        binding.tvMenuFive.setOnClickListener(this)

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentColor(position)
            }

        })

    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvMenuOne ->{
                setCurrentPager(0)
            }
            R.id.tvMenuTwo ->{
                setCurrentPager(1)
            }
            R.id.tvMenuThree ->{
                setCurrentPager(2)
            }
            R.id.tvMenuFour ->{
                setCurrentPager(3)
            }
            R.id.tvMenuFive ->{
                setCurrentPager(4)
            }
        }
    }
    private fun setCurrentPager(index: Int){
        binding.viewPager2.currentItem = index
    }
    private fun setCurrentColor(index: Int){
        binding.tvMenuOne.setTextColor(Color.parseColor("#858585"))
        binding.tvMenuTwo.setTextColor(Color.parseColor("#858585"))
        binding.tvMenuThree.setTextColor(Color.parseColor("#858585"))
        binding.tvMenuFour.setTextColor(Color.parseColor("#858585"))
        binding.tvMenuFive.setTextColor(Color.parseColor("#858585"))

        when(index){
            0 -> {
                binding.tvMenuOne.setTextColor(Color.parseColor("#FFFFFF"))
            }
            1 -> {
                binding.tvMenuTwo.setTextColor(Color.parseColor("#FFFFFF"))
            }
            2 -> {
                binding.tvMenuThree.setTextColor(Color.parseColor("#FFFFFF"))
            }
            3 -> {
                binding.tvMenuFour.setTextColor(Color.parseColor("#FFFFFF"))
            }
            4 -> {
                binding.tvMenuFive.setTextColor(Color.parseColor("#FFFFFF"))
            }

        }
    }
}
