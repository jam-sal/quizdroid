package edu.uw.ischool.jsaleh1.quizdroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.isVisible

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    lateinit var data : Bundle
    lateinit var quizApp:QuizApp
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        data = requireArguments()
        quizApp = (activity?.application as QuizApp)
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val topic = quizApp.getTopicRepository().getTopic(quizApp.selectedTopic)
        val questions = topic.questions
        val currentQ = data.getInt("currentQNum")

        val q  : Question = questions[currentQ]
        Log.i("Question", "${q.question}")
        view.findViewById<TextView>(R.id.qNumber).setText("Question ${currentQ + 1}")
        view.findViewById<TextView>(R.id.question).setText(q.question)

        val radioGroup = view.findViewById<RadioGroup>(R.id.answers)
        val answer1 = view.findViewById<RadioButton>(R.id.radioButton1)
        val answer2 = view.findViewById<RadioButton>(R.id.radioButton2)
        val answer3 = view.findViewById<RadioButton>(R.id.radioButton3)
        val answer4 = view.findViewById<RadioButton>(R.id.radioButton4)

        answer1.text = q.answers?.get(0)
        answer2.text = q.answers?.get(1)
        answer3.text = q.answers?.get(2)
        answer4.text = q.answers?.get(3)

        var selectedAnswer : Int? = -1
        val submitBtn = view.findViewById<Button>(R.id.submit)
        radioGroup.setOnCheckedChangeListener {group, selectedId ->
            var selected  = view.findViewById<RadioButton>(selectedId)
            selectedAnswer = q.answers?.indexOf(selected.text)
            submitBtn.isVisible = true
        }

        submitBtn.setOnClickListener{
            val resultFragment = ResultFragment()
            val bundle = Bundle()
            bundle.putInt("currentQNum", currentQ + 1)
            selectedAnswer?.let { it1 -> bundle.putInt("selectedAnswer", it1) }
            var correct = data.getInt("numCorrect")
            if(selectedAnswer == q.correct) {
                bundle.putInt("numCorrect", correct + 1)
            } else {
                bundle.putInt("numCorrect", correct)
            }
            resultFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.flFragment, resultFragment)
                commit()
            }
        }

    }
}