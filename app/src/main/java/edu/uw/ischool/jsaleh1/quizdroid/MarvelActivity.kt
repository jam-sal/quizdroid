package edu.uw.ischool.jsaleh1.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MarvelActivity : AppCompatActivity() {
    val description = "This quiz will test your knowledge on the Marvel super heroes."
    val questions = arrayListOf<Question>(
        Question("Where is Captain America from?", listOf("Brooklyn", "Ithaca", "Rochester", "Buffalo"), 0),
        Question("How many Infinity Stones are there?", listOf("5", "4", "6", "7"), 2),
        Question("Who was Marvel Comics’ first original hero character?", listOf("Captain America", "Iron Man", "Spider Man", "Human Torch"), 3),
        Question("In what part of Africa is the fictional nation of Wakanda, home of Black Panther, located?", listOf("Central Africa", "North Africa", "West Africa", "East Africa"), 3)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel)

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