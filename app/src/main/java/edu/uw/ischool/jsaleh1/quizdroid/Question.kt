package edu.uw.ischool.jsaleh1.quizdroid

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class Question(var question: String?, var answers: ArrayList<String>?, var correct: Int)