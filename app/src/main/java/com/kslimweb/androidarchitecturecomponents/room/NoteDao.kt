package com.kslimweb.androidarchitecturecomponents.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kslimweb.androidarchitecturecomponents.room.entity.Note

// Generally it is good approach to create one DAO for each entity
@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT count(*) FROM note_table")
    fun countData(): Int
}