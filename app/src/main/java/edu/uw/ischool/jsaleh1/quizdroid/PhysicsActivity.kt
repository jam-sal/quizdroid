package edu.uw.ischool.jsaleh1.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable

class PhysicsActivity : AppCompatActivity() {
    val description = "This quiz will test your knowledge on some basic physics concepts."
    val questions = arrayListOf<Question>(
        Question("The slope of the position-time graph of an object moving with negative velocity is", listOf("Positive", "Negative", "Zero", "Infinity"), 1),
        Question("For small deformation, stress is proportional to strain is called as", listOf("Hooke's law", "Elastic law", "Newton's law", "None"), 0),
        Question("A measure of opposition to the current flow in an electrical circuit is known as?", listOf("Voltage", "Current", "Capacitance", "Resistance"), 3),
        Question("To get maximum work what should be the angle between force and displacement?", listOf("0 degrees", "30 degrees", "60 degrees", "90 degrees"), 0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)

        val overviewFragment = OverviewFragment()
        val bundle = Bundle()
        bundle.putString("desc", description)
        bundle.putInt("numOfQ", 4)
        bundle.putSerializable("questions", questions)
        overviewFragment.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, overviewFragment)
            commit()
        }
    }
}