package com.example.note_app_realtime_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    // Variables
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var backFAB: FloatingActionButton
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TYPECASTING
        recyclerView = findViewById(R.id.recycleView)
        fab = findViewById(R.id.fab)
        backFAB = findViewById(R.id.backFAB)

        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference.child("notes")

        // Event Handler -> onClickListener
        fab.setOnClickListener{
            // Navigate to new activity to add notes
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        // Event Handler -> onClickListener
        backFAB.setOnClickListener{
            // Navigate to new activity to add notes
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get currentUserId using auth
        val currentUserId = auth.currentUser!!.uid

        // Create a query in databaseReference
        val query = databaseReference.orderByChild("uid").equalTo(currentUserId)

        // Create FirebaseRecyclerOptions
        val recyclerViewOptions = FirebaseRecyclerOptions.Builder<Note>()
            .setQuery(query, Note::class.java)
            .build()

        // Now add adapter
        adapter = RVAdapter(recyclerViewOptions)
        recyclerView.adapter = adapter

        // Create itemTouchHelper to swipe to delete note
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
                adapter.deleteNote(position)
            }
        }).attachToRecyclerView(recyclerView)
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
}