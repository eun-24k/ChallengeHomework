package com.example.homework.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.homework.databinding.FragmentTodoBinding
import com.example.homework.todo.list.TodoListViewModel

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TodoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTodoBinding.inflate(inflater, container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initView() {


    }

    private fun initViewModel() = with(viewModel) {
        uiState.observe(viewLifecycleOwner) {
            it.list // recycler view notify
        }
    }

    override fun onDestroyView() {
        _binding = null // 메모리 leak 을 방지 !! 이거 꼭 해줘야함 구글이 하라 했음..
        super.onDestroyView()

    }

    fun addTodoItem(todoModel: TodoData?) {
        //뷰모델로 데엍 넘기기
        viewModel.addTodoItem(todoModel)
    }


    companion object {
        // 인스턴스로 가지고 오는 이유! 액티비티를 newIntent로 가지고 오듯 프래그먼트는 newInstance로 가져온다!
        fun newInstance() = TodoFragment()

    }
}