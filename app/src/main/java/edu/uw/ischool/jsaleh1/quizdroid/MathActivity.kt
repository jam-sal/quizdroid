package edu.uw.ischool.jsaleh1.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class MathActivity : AppCompatActivity() {
    val description = "This quiz will test your knowledge on some basic math concepts."
    val questions = arrayListOf<Question>(
        Question("What is 5 + 7 + 9?", arrayListOf("20", "12", "14", "21"), 3),
        Question("On converting 32 yards to feet, we get...", arrayListOf("960 ft", "96 ft", "0.96 ft", "0.096 ft"), 1),
        Question("Which of the following is an example of a prism shape?", arrayListOf("Cube", "Cone", "Sphere", "Cylinder"), 0),
        Question("Solve the linear inequality 2x - 5 > -x + 4", arrayListOf("x < -3", "x > -3", "x > 3", "x < 3"), 2)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        val overviewFragment = OverviewFragment()
//        val bundle = Bundle()
//        bundle.putString("desc", description)
//        bundle.putInt("numOfQ", questions.size)
//        bundle.putParcelableArrayList("questions", questions)
//        bundle.putInt("numCorrect", 0)
//        bundle.putInt("currentQNum", 0)
//        overviewFragment.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, overviewFragment)
            commit()
        }
    }
}