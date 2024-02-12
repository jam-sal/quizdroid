package edu.uw.ischool.jsaleh1.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    val categories = arrayListOf<String>("Marvel Super Heroes", "Math", "Physics")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, categories)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            var next = Intent()
            val selectedCat = when (position) {
                0 -> next = Intent(this, MarvelActivity::class.java)
                1 -> next = Intent(this, MathActivity::class.java)
                else -> next = Intent(this, PhysicsActivity::class.java)
            }
            startActivity(next)
        }
    }
}