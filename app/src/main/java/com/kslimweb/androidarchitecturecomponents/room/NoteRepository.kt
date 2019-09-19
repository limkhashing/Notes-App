package com.kslimweb.androidarchitecturecomponents.room

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.kslimweb.androidarchitecturecomponents.room.entity.Note

class NoteRepository(application: Application) {

    private var noteDao: NoteDao
    private var allNotes: LiveData<List<Note>>

    init {
        val database: NoteDatabase = NoteDatabase.getInstance(
            application.applicationContext
        )!!
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) {
        InsertNoteAsyncTask(noteDao).execute(note)
    }

    fun update(note: Note) {
       UpdateNoteAsyncTask(noteDao).execute(note)
    }

    fun delete(note: Note) {
        DeleteNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAllNotes() {
        DeleteAllNotesAsyncTask(noteDao).execute()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }

    fun getDataCount(): Int {
        val asyncTask = GetDataCountAsyncTask(noteDao)
        return asyncTask.execute().get()
    }

    companion object {

        private var dataCount: Int? = null

        private class InsertNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
            override fun doInBackground(vararg p0: Note?) {
                noteDao.insert(p0[0]!!)
            }
        }

        private class UpdateNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
            override fun doInBackground(vararg p0: Note?) {
                noteDao.update(p0[0]!!)
            }
        }

        private class DeleteNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
            override fun doInBackground(vararg p0: Note?) {
                noteDao.delete(p0[0]!!)
            }
        }

        private class DeleteAllNotesAsyncTask(val noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                noteDao.deleteAllNotes()
            }
        }

        private class GetDataCountAsyncTask(val noteDao: NoteDao) : AsyncTask<Unit, Unit, Int>() {

            override fun onPostExecute(result: Int?) {
                super.onPostExecute(result)
                dataCount = result
            }

            override fun doInBackground(vararg params: Unit?): Int {
                return noteDao.countData()
            }
        }
    }
}
