package com.example.note_app_realtime_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddNoteActivity : AppCompatActivity() {

    // Variables
    private lateinit var noteEditText: EditText
    private lateinit var addNoteButton: Button
    private lateinit var noteDao: NoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        // TYPECASTING
        addNoteButton = findViewById(R.id.addNoteButton)
        noteEditText = findViewById(R.id.noteEditText)
        noteDao = NoteDao()

        // Event Handler -> onClickListener
        addNoteButton.setOnClickListener {
            val note = noteEditText.text.toString()
            if(note.isNotEmpty()) {
                // Navigate to Main Activity
                noteDao.addNote(note)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}