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

        val adapter: ArrayAdapter<*> = object : ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_list_item_2,
            android.R.id.text1,
            topics
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val text1 = view.findViewById<View>(android.R.id.text1) as TextView
                val text2 = view.findViewById<View>(android.R.id.text2) as TextView
                text1.setText(topics[position].title)
                text2.setText(topics[position].shortDesc)
                return view
            }
        }

        val listView = findViewById<ListView>(R.id.listView)
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, topicsWithDescriptions)
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