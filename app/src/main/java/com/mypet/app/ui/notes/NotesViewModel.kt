package com.mypet.app.ui.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mypet.app.db.Note
import com.mypet.app.db.NoteDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class NotesViewModel(application: Application): AndroidViewModel(application) {
    private val notesDao by lazy {
        NoteDB.getDatabase(application.applicationContext).getNoteDao()
    }

    fun addNote(text: String) = viewModelScope.launch(Dispatchers.IO) {
        notesDao.addNote(Note(text, getDate()))
    }

    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        notesDao.deleteNote(note)
    }

    private val sdf = SimpleDateFormat("dd/M/yyyy")

    private fun getDate(): String = sdf.format(Date())
}