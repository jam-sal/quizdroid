package edu.uw.ischool.jsaleh1.quizdroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class Question(var question: String?, var answers: ArrayList<String>?, var correct: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeStringList(answers)
        parcel.writeInt(correct)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }
}

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
        val bundle = Bundle()
        bundle.putString("desc", description)
        bundle.putInt("numOfQ", questions.size)
        bundle.putParcelableArrayList("questions", questions)
        bundle.putInt("numCorrect", 0)
        bundle.putInt("currentQNum", 0)
        overviewFragment.arguments = bundle
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, overviewFragment)
            commit()
        }
    }
}