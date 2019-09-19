package com.kslimweb.androidarchitecturecomponents.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note( // @ColumnInfo(name = "name_you_preferred_in_table")
           var title: String,
           var description: String,
           var priority: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}