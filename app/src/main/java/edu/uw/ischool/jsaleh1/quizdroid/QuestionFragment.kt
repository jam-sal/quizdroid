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
    var data : Bundle? = null
    var qNum: Int = 1
    var correct:Int = 0
    var answerId: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        data = arguments
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questions = data?.getSerializable("questions") as ArrayList<*>
        val question = questions[0]()
        view.findViewById<TextView>(R.id.qNumber).setText("Question ${qNum}")
//        view.findViewById<TextView>(R.id.question).setText(questions[qNum - 1].question)
        val radioGroup = view.findViewById<RadioGroup>(R.id.answers)
        val submitBtm = view.findViewById<Button>(R.id.submit)
        radioGroup.setOnCheckedChangeListener {group, selectedId ->
            var selected  = view.findViewById<RadioButton>(selectedId)
            answerId = selectedId
            submitBtm.isVisible = true
        }
    }
}