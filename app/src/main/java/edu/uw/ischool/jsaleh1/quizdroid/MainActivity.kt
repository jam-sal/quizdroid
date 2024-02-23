package edu.uw.ischool.jsaleh1.quizdroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topicRepository = (application as QuizApp).getTopicRepository()
        val topics = topicRepository.getAll()

//        val adapter: ArrayAdapter<*> = object : ArrayAdapter<Any?>(
//            this,
//            android.R.layout.simple_list_item_1,
//            android.R.id.text1,
//            topics
//        ) {
//        }

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, android.R.id.text1, topics)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            (application as QuizApp).selectedTopic = position
            var next = Intent()
            when (position) {
                0 -> next = Intent(this, MarvelActivity::class.java)
                1 -> next = Intent(this, MathActivity::class.java)
                else -> next = Intent(this, PhysicsActivity::class.java)
            }
            startActivity(next)
        }
    }
}