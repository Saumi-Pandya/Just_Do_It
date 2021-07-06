package com.example.just_do_it.data

import android.app.Application
import androidx.lifecycle.LiveData

class TaskRepository (context: Application){

    private val taskDao: TaskDao = TaskDatabase.getDatabase(context).taskDao()

    suspend fun insertTask(task:Task){
        taskDao.insertTask(task)
    }

    suspend fun deleteTask(task: Task){
        taskDao.deleteTask(task)
    }

    suspend fun updateTask(task: Task){
        taskDao.updateTask(task)
    }

    fun listAllTask():LiveData<List<Task>>{
        return taskDao.listAllTask()
    }

}