package com.example.just_do_it.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application:Application) : AndroidViewModel(application){
      private val repoInstance: TaskRepository = TaskRepository(application)

    fun listAllTask():LiveData<List<Task>>{
        return repoInstance.listAllTask()
    }

    fun insertTask(task:Task){
        viewModelScope.launch {
            repoInstance.insertTask(task)
        }
    }

    fun deleteTask(task:Task){
        viewModelScope.launch {
            repoInstance.deleteTask(task)
        }
    }

    fun updateTask(task:Task){
        viewModelScope.launch {
            repoInstance.updateTask(task)
        }
    }
}