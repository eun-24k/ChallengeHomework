package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.homework.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }

    private fun initViewPager() {
        var viewPager2Adapter = ViewPager2Adapter(this)
        viewPager2Adapter.addFragment(TodoFragment())
        viewPager2Adapter.addFragment(BookmarkFragment())

        binding.viewPager.apply {
            adapter = viewPager2Adapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {})

        }

        TabLayoutMediator(binding.tapLayout, binding.viewPager) {tab, position->
            when (position) {
                0 -> tab.text = "To do"
                1 -> tab.text = "Bookmark"
            }
        }.attach()
    }
}