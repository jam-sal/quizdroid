package edu.uw.ischool.jsaleh1.quizdroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    lateinit var data : Bundle
    lateinit var quizApp:QuizApp
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        quizApp = (activity?.application as QuizApp)
        data = requireArguments()
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topic = quizApp.getTopicRepository().getTopic(quizApp.selectedTopic)
        val questions = topic.questions
        val currentQNum = data.getInt("currentQNum")
        val currentQ = questions[currentQNum-1]
        val correctAnswer = currentQ.answers?.get(currentQ.correct)
        val selectedId = data.getInt("selectedAnswer")
        val selectedAnswer = currentQ.answers?.get(selectedId)

        Log.i("Result", "${correctAnswer}")
        Log.i("Result", "${selectedAnswer}")

        val selected = view.findViewById<TextView>(R.id.selected)
        val correct = view.findViewById<TextView>(R.id.correct)
        val numCorrect = view.findViewById<TextView>(R.id.numCorrect)

        selected.text = "You chose: ${selectedAnswer}"
        correct.text = "The correct answer was: ${correctAnswer}"
        numCorrect.text = "You have ${data.getInt("numCorrect")} out of ${questions.size} correct"


        var questionFragment = QuestionFragment()
        questionFragment.arguments = data
        if(currentQNum == 4) {
            view.findViewById<Button>(R.id.next).text = "Finish"
        }

        view.findViewById<Button>(R.id.next).setOnClickListener {
            Log.i("Result", "Next clicked")
            if(currentQNum == 4) {
                var next = Intent()
                next = Intent(getActivity(), MainActivity::class.java)
                getActivity()?.startActivity(next)
            } else  {
                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.flFragment, questionFragment)
                    commit()
                }
            }
        }
    }

}