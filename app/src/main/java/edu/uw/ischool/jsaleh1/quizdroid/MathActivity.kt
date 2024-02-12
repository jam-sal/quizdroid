package edu.uw.ischool.jsaleh1.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable

data class Question(var question: String, var answers: List<String>, var correct: Int) : Serializable
class MathActivity : AppCompatActivity() {
    val description = "This quiz will test your knowledge on some basic math concepts."
    val questions = arrayListOf<Question>(
        Question("What is 5 + 7 + 9?", listOf("20", "12", "14", "21"), 3),
        Question("On converting 32 yards to feet, we get...", listOf("960 ft", "96 ft", "0.96 ft", "0.096 ft"), 1),
        Question("Which of the following is an example of a prism shape?", listOf("Cube", "Cone", "Sphere", "Cylinder"), 0),
        Question("Solve the linear inequality 2x - 5 > -x + 4", listOf("x < -3", "x > -3", "x > 3", "x < 3"), 2)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

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