package com.example.just_do_it.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity(tableName = "task_table")
data class Task(@PrimaryKey(autoGenerate = true) val id:Int,
                var title :String?,
                var description: String?,
                var date:Long = 21,
                var priority:Int = 1)