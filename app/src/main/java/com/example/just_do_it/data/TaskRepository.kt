package com.example.just_do_it.data

import androidx.lifecycle.LiveData

class TaskRepository (private val taskDao:TaskDao){

    val readAllData:LiveData<List<Task>> = taskDao.listAllData()

    suspend fun addData(task:Task){
        taskDao.insert(task)
    }

}