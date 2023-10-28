package com.mypet.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        Note::class
    ],
)
abstract class NoteDB : RoomDatabase() {
    abstract fun getNoteDao(): NotesDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDB? = null

        fun getDatabase(context: Context): NoteDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): NoteDB {
            return Room.databaseBuilder(
                context.applicationContext,
                NoteDB::class.java,
                "note_database"
            ).build()
        }
    }
}