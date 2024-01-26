package com.example.homework.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework.R
import com.example.homework.databinding.FragmentBookmarkBinding
import com.example.homework.databinding.FragmentTodoBinding
import com.example.homework.todo.TodoFragment


class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBookmarkBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {


    }

    override fun onDestroyView() {
        _binding = null // 메모리 leak 을 방지 !! 이거 꼭 해줘야함 구글이 하라 했음..
        super.onDestroyView()

    }


    companion object {
        // 인스턴스로 가지고 오는 이유! 액티비티를 newIntent로 가지고 오듯 프래그먼트는 newInstance로 가져온다!
        fun newInstance() = BookmarkFragment()

    }
}