package com.example.note_app_no_signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query

class MainActivity : AppCompatActivity() {

    //Variables
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var backFAB: FloatingActionButton
    private lateinit var noteDao: NoteDao
    private lateinit var auth: FirebaseAuth
    private lateinit var adaptor: RVAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TYPECASTING
        recyclerView = findViewById(R.id.recycleView)
        fab = findViewById(R.id.fab)
        backFAB = findViewById(R.id.backFAB)

        noteDao = NoteDao()
        auth = FirebaseAuth.getInstance()   //auth = Firebase.auth

        //Event Handler -> onClickListener
        fab.setOnClickListener{
            //naviaget to new activity to add notes
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }


        //Event Handler -> onClickListener
        backFAB.setOnClickListener{
            //naviaget to new activity to add notes
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(this)

        //get noteCollection collection from noteDao
        val noteCollection = noteDao.noteCollection


        //get currentUserId using auth
        val currentUserId = auth.currentUser!!.uid

        //create a query in noteCollection
        val query = noteCollection.whereEqualTo("uid", currentUserId).orderBy("text", Query.Direction.ASCENDING)

        //the whereEqualTo("uid", currentUserId) is for the user to only access to its own notes
        //the .orderBy("text", Query.Direction.ASCENDING) is to order the notes by alphabetical order

        val recyclerViewOption = FirestoreRecyclerOptions.Builder<Note>().setQuery(query, Note::class.java).build()

        //now add adaptor
        adaptor = RVAdaptor(recyclerViewOption)
        recyclerView.adapter = adaptor

        //create itemTouchHelper to swipe to delete note

    ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.absoluteAdapterPosition
            adaptor.deleteNote(position)
        }

    }).attachToRecyclerView(recyclerView)

    }

    override fun onStart(){
        super.onStart()
        adaptor.startListening()
    }

    override fun onStop(){
        super.onStop()
        adaptor.stopListening()
    }




}