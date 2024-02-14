package edu.uw.ischool.jsaleh1.quizdroid

import android.app.Application
import android.util.Log

class QuizApp : Application() {
    private var topicRepository : iTopicRepository = TopicRepository()
    var selectedTopic: Int = 0
    override fun onCreate() {
        super.onCreate()
        Log.i("CREATE", "QuizApp created")
    }

    fun getTopicRepository(): iTopicRepository {
        return topicRepository
    }

}