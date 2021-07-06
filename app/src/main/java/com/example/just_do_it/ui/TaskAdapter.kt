package com.example.just_do_it.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.just_do_it.R
import com.example.just_do_it.data.Task
import org.w3c.dom.Text

class TaskAdapter(val taskList: List<Task>,val listener: onItemClickListener): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){

    inner class TaskViewHolder(view: View):RecyclerView.ViewHolder(view),View.OnClickListener{
        val tasktitle = view.findViewById<TextView>(R.id.uitasktitle)
        val taskdesc = view.findViewById<TextView>(R.id.uitaskdescription)
        val taskdate = view.findViewById<TextView>(R.id.uitaskdate)

        init{
            view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION)
                listener.onItemClick(position)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {
        val taskView = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(taskView)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        val item = taskList[position]
        with(holder){
               tasktitle.text = item.title
               taskdesc.text = item.description
               taskdate.text = item.date.toString()
        }
    }

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

}