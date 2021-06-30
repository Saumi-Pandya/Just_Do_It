package com.example.just_do_it.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity(tableName = "task_table")
data class Task(@PrimaryKey(autoGenerate = true) val id:Int,
                var task_heading :String?,
                var task_desc: String?,
                var date:DateFormat?,
                var priority:Int)