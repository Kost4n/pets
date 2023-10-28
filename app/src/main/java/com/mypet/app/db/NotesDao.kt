package com.mypet.app.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(recordEntity: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getNotes(): Flow<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)
} 