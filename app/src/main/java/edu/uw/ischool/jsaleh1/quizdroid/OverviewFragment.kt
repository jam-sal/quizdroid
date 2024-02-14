package edu.uw.ischool.jsaleh1.quizdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [OverviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OverviewFragment : Fragment() {
    lateinit var quizApp : QuizApp
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        quizApp = (activity?.application as QuizApp)
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topic = quizApp.getTopicRepository().getTopic(quizApp.selectedTopic)
        val fullDesc = topic.longDesc + "\nThere are ${topic.questions.size} questions."
        view.findViewById<TextView>(R.id.desc).setText(fullDesc)
        val questionFragment = QuestionFragment()
//        questionFragment.arguments = data
        val bundle = Bundle()
        bundle.putInt("numCorrect", 0)
        bundle.putInt("currentQNum", 0)
        questionFragment.arguments = bundle
        view.findViewById<Button>(R.id.start).setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.flFragment, questionFragment)
                commit()
            }
        }
    }
}