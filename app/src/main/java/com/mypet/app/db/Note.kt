package com.mypet.app.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @ColumnInfo(name = "note_text") val noteText: String,
    @ColumnInfo(name = "note_date") val noteDate: String
) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}