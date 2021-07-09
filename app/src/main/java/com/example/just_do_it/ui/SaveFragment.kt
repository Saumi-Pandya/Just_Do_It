package com.example.just_do_it.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.just_do_it.R
import com.example.just_do_it.data.Task
import com.example.just_do_it.data.TaskViewModel


class SaveFragment : Fragment() {

    lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edittexttitle = view.findViewById<EditText>(R.id.edittexttitle)
        val edittextdesc = view.findViewById<EditText>(R.id.edittextdesc)
        val savebutton = view.findViewById<Button>(R.id.buttonsave)
        val taskObject = Task(0,title =  edittexttitle.toString(),description = edittextdesc.toString())
        savebutton.setOnClickListener {
            saveData(taskObject)
        }

    }

    fun saveData(taskObject: Task){
        viewModel.insertTask(taskObject)
        requireActivity().onBackPressed()
    }

}