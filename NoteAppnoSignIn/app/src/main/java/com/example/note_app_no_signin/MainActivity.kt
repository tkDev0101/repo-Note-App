package com.example.note_app_no_signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    //Variables
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var noteDao: NoteDao
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TYPECASTING
        recyclerView = findViewById(R.id.recycleView)
        fab = findViewById(R.id.fab)

        noteDao = NoteDao()
        auth = FirebaseAuth.getInstance()   //auth = Firebase.auth

        //Event Handler -> onClickListener
        fab.setOnClickListener{
            //naviaget to new activity to add notes
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        //get noteCollection collection from noteDao
        val noteCollection = noteDao.noteCollection


        //get currentUserId using auth
        val currentUserId = auth.currentUser!!.uid

    }
}