package com.example.homework.main


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework.R
import com.example.homework.bookmark.BookmarkFragment
import com.example.homework.todo.TodoFragment

//ViewPager2Adapter.kt
class TodoMainViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private var fragments = listOf(
        TodoMainTab(
            fragment = TodoFragment.newInstance(),
            title = R.string.main_tab_todo_title
        ),
        TodoMainTab(
            fragment = BookmarkFragment.newInstance(),
            title = R.string.main_tab_bookmark_title
        )
    )


    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position].fragment

    fun getFragment(position: Int): Fragment = fragments[position].fragment
    // TODO createFragment() 랑 정확하게 무슨 차이가 있는지 이해가 되지 않는다.

//    fun getFragment2(clazz:Class<out Fragment>): Fragment? =  // 심화 버전 !!
//        fragments.find{it.fragment::class.java == clazz::class.java }?.fragment
//


    fun getTitle(position: Int): Int = fragments[position].title
    fun getTodoListFragment(): Fragment? =
        fragments.find {
            it.fragment == TodoFragment::class.java
        }?.fragment


}