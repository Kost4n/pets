package com.mypet.app.db

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mypet.app.R

class NotesAdapter(
    private val onRecordClickListener: OnRecordClickListener
) : RecyclerView.Adapter<NotesAdapter.RecordViewHolder>() {
    private var itemList = mutableListOf<Note>()

    inner class RecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val noteText = itemView.findViewById<TextView>(R.id.note_text)
        private val noteDate = itemView.findViewById<TextView>(R.id.note_date)
        private val noteId = itemView.findViewById<TextView>(R.id.note_id)

        fun bind(note: Note, position: Int) {
            noteText.text = note.noteText
            noteDate.text = note.noteDate
            noteId.text = note.id.toString()

            itemView.setOnClickListener {
                onRecordClickListener.onRecordClick(note, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_row, parent, false)

        return RecordViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) =
        holder.bind(itemList[position], position)

    fun update(items: MutableList<Note>) {
        itemList = items
        notifyDataSetChanged()
    }
    interface OnRecordClickListener {
        fun onRecordClick(record: Note, position: Int)
    }
}

class RecycleItemDecoration(
    val spaceHeight: Int
): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        outRect.bottom = spaceHeight
    }
}