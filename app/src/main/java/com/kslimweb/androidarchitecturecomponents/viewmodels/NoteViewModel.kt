package com.kslimweb.androidarchitecturecomponents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kslimweb.androidarchitecturecomponents.room.entity.Note
import com.kslimweb.androidarchitecturecomponents.room.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NoteRepository = NoteRepository(application)
    private var allNotes: LiveData<List<Note>> = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun update(note: Note) {
        repository.update(note)
    }

    fun delete(note: Note) {
        repository.delete(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }

    fun getDataCount(): Int {
        return repository.getDataCount()
//        return repository.processDataCount()
    }
}