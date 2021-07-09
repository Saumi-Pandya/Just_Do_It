package com.example.just_do_it.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.just_do_it.R
import com.example.just_do_it.data.Task
import com.example.just_do_it.data.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment(),TaskAdapter.onItemClickListener {
    // TODO: Rename and change types of parameters
    lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listAllTask().observe(viewLifecycleOwner, Observer {
            setRecyclerView(it)
        })

        val floatingActionButton = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_saveFragment)
        }
    }

    private fun setRecyclerView(taskList: List<Task>){
          var recyclerView = requireView().findViewById<RecyclerView>(R.id.recycler_view)
          recyclerView.adapter = TaskAdapter(taskList,this@ListFragment)
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onItemClick(position: Int) {

    }


}