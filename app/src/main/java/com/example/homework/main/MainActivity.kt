package com.example.homework.main

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.viewpager2.widget.ViewPager2
import com.example.homework.databinding.ActivityAddToDoBinding
import com.example.homework.todo.TodoFragment
import com.example.homework.databinding.ActivityMainBinding
import com.example.homework.todo.TodoData
import com.example.homework.todo.content.AddTodoActivity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewPagerAdapter by lazy {
        TodoMainViewPagerAdapter(this@MainActivity)
    }

    private val contentTodoLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val todoModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    result.data?.getParcelableExtra(
                        AddTodoActivity.EXTRA_TODO_MODEL,
                        TodoData::class.java
                    )
                } else {
                    result.data?.getParcelableExtra(
                        AddTodoActivity.EXTRA_TODO_MODEL
                    )
                }
                // 아래 코드에서 프래그먼트를 가져 왔으니까 TODOFRAGMENT로 캐스팅해줌.
                val fragment = viewPagerAdapter.getTodoListFragment() as? TodoFragment
                fragment?.addTodoItem(todoModel)

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
//        initViewPager()
    }

    private fun initView() = with(binding) {
        viewPager.adapter = viewPagerAdapter
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) { // 페이지가 설정이 되었을 떄 플로팅 액션 버튼을 숨기고 보여주는 기능 추가
                super.onPageSelected(position)
                //심화 개념 (클래스로 가져와야 더 효율적이다)
//                viewPagerAdapter.getFragment2(TodoFragment::class.java)

                when (viewPagerAdapter.getFragment(position)) {
                    is TodoFragment -> fabCreateTodo.show()
                    else -> fabCreateTodo.hide()
                }

            }
        }
        )

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        fabCreateTodo.setOnClickListener {
            contentTodoLauncher.launch(
                AddTodoActivity.newIntent(this@MainActivity)

            )
        }
    }


//    private fun initViewPager() {
//        var todoMainViewPagerAdapter = TodoMainViewPagerAdapter(this)
//        todoMainViewPagerAdapter.addFragment(TodoFragment())
//        todoMainViewPagerAdapter.addFragment(BookmarkFragment())
//
//        binding.viewPager.apply {
//            adapter = todoMainViewPagerAdapter
//
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {})
//
//        }
//
//        TabLayoutMediator(binding.tapLayout, binding.viewPager) {tab, position->
//            when (position) {
//                0 -> tab.text = "To do"
//                1 -> tab.text = "Bookmark"
//            }
//        }.attach()
//    }
}