package com.example.note_app_no_signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddNoteActivity : AppCompatActivity() {


    //Variables
    private lateinit var noteEditText: EditText
    private lateinit var addNoteButton: Button
    private lateinit var noteDao: NoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)



        //TYPECASTING
        addNoteButton = findViewById(R.id.addNoteButton)
        noteEditText = findViewById(R.id.noteEditText)
        noteDao = NoteDao()



        //Event Handler -> onClickListener
        addNoteButton.setOnClickListener{

            val note = noteEditText.text.toString()

            if(note.isNotEmpty()){
                //navigate to Main Activity
                    //now create note data class and note-data to add data to firestore
                        //now create layout for recyclerview
                            //now create adaptor for recyclerView
                noteDao.addNote(note)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }



    }
}