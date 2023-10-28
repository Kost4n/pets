package com.mypet.app.ui.notes

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mypet.app.R
import com.mypet.app.databinding.FragmentNoteBinding
import com.mypet.app.db.Note
import com.mypet.app.db.NoteDB
import com.mypet.app.db.NotesAdapter
import com.mypet.app.db.RecycleItemDecoration
import kotlinx.coroutines.launch

class NotesFragment: Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: NotesAdapter
    private lateinit var viewModel: NotesViewModel
    private val notesDao by lazy {
        NoteDB.getDatabase(requireContext().applicationContext).getNoteDao()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonAdd.setOnClickListener {
            addNote()
        }

        return root
    }

    private fun addNote() {
        val view = layoutInflater.inflate(R.layout.add, null)
        val edit = view.findViewById<EditText>(R.id.add_edit)
        AlertDialog.Builder(context)
            .setTitle("Write a note on vaccination")
            .setView(view)
            .setPositiveButton("Add") { d, _ ->
                viewModel.addNote(edit.text.toString())
            }
            .setNegativeButton("Back") { d, _ ->
                d.dismiss()
            }
            .show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecView()
    }

    private fun setRecView() {
        val recView = binding.recycle
        val noteClickListener = object : NotesAdapter.OnRecordClickListener {
            override fun onRecordClick(record: Note, position: Int) {
                watchNote(record)
            }
        }
        adapter = NotesAdapter(noteClickListener)
        recView.layoutManager = LinearLayoutManager(context)
        recView.setHasFixedSize(true)
        recView.addItemDecoration(RecycleItemDecoration(2))

        recView.adapter = adapter
        observeNotes()
    }

    private fun watchNote(record: Note) {
        val view = layoutInflater.inflate(R.layout.notes_row, null)
        view.findViewById<TextView>(R.id.note_text).text = record.noteText
        view.findViewById<TextView>(R.id.note_date).text = record.noteDate
        AlertDialog.Builder(context)
            .setView(view)
            .setPositiveButton("Yes") { d, _ ->
                viewModel.deleteNote(record)
                adapter.notifyDataSetChanged()
                d.dismiss()
            }
            .setNegativeButton("No") { d, _ ->
                d.dismiss()
            }
            .show()
    }

    override fun onStart() {
        super.onStart()
        observeNotes()
    }

    private fun observeNotes() {
        lifecycleScope.launch {
            notesDao.getNotes().collect() {
                if (it.isNotEmpty()) {
                    adapter.update(it.toMutableList())
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}