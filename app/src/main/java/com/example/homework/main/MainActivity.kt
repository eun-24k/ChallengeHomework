package com.example.homework.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.homework.bookmark.BookmarkFragment
import com.example.homework.todo.TodoFragment
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
        var todoMainViewPagerAdapter = TodoMainViewPagerAdapter(this)
        todoMainViewPagerAdapter.addFragment(TodoFragment())
        todoMainViewPagerAdapter.addFragment(BookmarkFragment())

        binding.viewPager.apply {
            adapter = todoMainViewPagerAdapter

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