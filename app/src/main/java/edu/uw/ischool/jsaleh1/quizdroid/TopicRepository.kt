package edu.uw.ischool.jsaleh1.quizdroid

import android.content.Context
import android.util.Log
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

interface iTopicRepository {
    fun getAll() : List<Topic>
    fun getTopic(topicIndex: Int): Topic
//    fun getQuestion(topicIndex: Int, quizIndex: Int): Question
}

class TopicRepository(private val context: Context): iTopicRepository {
//    var topics = listOf<Topic>(
//        Topic(
//            "Math",
//            "This math quiz contains questions relating to concepts from elementary school arithmetic to high school algebra.",
//            "Test your knowledge on different mathematics concepts.",
//            listOf<Question>(
//                Question("What is 5 + 7 + 9?", arrayListOf("20", "12", "14", "21"), 3),
//                Question("On converting 32 yards to feet, we get...", arrayListOf("960 ft", "96 ft", "0.96 ft", "0.096 ft"), 1),
//                Question("Which of the following is an example of a prism shape?", arrayListOf("Cube", "Cone", "Sphere", "Cylinder"), 0),
//                Question("Solve the linear inequality 2x - 5 > -x + 4", arrayListOf("x < -3", "x > -3", "x > 3", "x < 3"), 2)
//            )
//        ),
//        Topic(
//            "Physics",
//            "This physics quiz contains high level questions without requiring any math or calculation.",
//            "Test your knowledge on different physics concepts.",
//            listOf<Question>(
//                Question("The slope of the position-time graph of an object moving with negative velocity is", arrayListOf("Positive", "Negative", "Zero", "Infinity"), 1),
//                Question("For small deformation, stress is proportional to strain is called as", arrayListOf("Hooke's law", "Elastic law", "Newton's law", "None"), 0),
//                Question("A measure of opposition to the current flow in an electrical circuit is known as?", arrayListOf("Voltage", "Current", "Capacitance", "Resistance"), 3),
//                Question("To get maximum work what should be the angle between force and displacement?", arrayListOf("0 degrees", "30 degrees", "60 degrees", "90 degrees"), 0)
//            )
//        ),
//        Topic(
//            "Marvel Super Heroes",
//            "This Marvel quiz contains questions about the Marvel franchise. Questions can be about any of the comics and movies.",
//            "Test your knowledge on the Marvel franchise",
//            listOf<Question>(
//                Question("Where is Captain America from?", arrayListOf("Brooklyn", "Ithaca", "Rochester", "Buffalo"), 0),
//                Question("How many Infinity Stones are there?", arrayListOf("5", "4", "6", "7"), 2),
//                Question("Who was Marvel Comics’ first original hero character?", arrayListOf("Captain America", "Iron Man", "Spider Man", "Human Torch"), 3),
//                Question("In what part of Africa is the fictional nation of Wakanda, home of Black Panther, located?", arrayListOf("Central Africa", "North Africa", "West Africa", "East Africa"), 3)
//            )
//        ),
//    )
    lateinit var topics : List<Topic>

    init {
        val jsonString = loadJsonFile()
        val jsonArray = JSONArray(jsonString)
        
    }
    private fun loadJsonFile(): String {
        var json = ""
        try {
            json = context.assets.open("questions.json").bufferedReader().use { it.readText() }
        } catch (ioEx : IOException) {
            Log.e("TopicRepo", "Error opening json file", ioEx)
        }
        return json
    }
    override fun getAll(): List<Topic> {
        return topics
    }

    override fun getTopic(topicIndex: Int): Topic {
        return topics[topicIndex]
    }
}