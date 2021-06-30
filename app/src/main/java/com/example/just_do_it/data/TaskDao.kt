package com.example.just_do_it.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task:Task)

    @Query("SELECT * from task_table order by id DESC")
    fun listAllData():LiveData<List<Task>>
}