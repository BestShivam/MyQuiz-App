package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizQuestionActivity : AppCompatActivity() ,View.OnClickListener {
    var questionList = ArrayList<Question>()
    var correctAnswer : Int = 0
    var user_name : String = ""
    var currentSelectedOptionPosition : Int =0
    var currentQuestionNumber : Int = 1
    var tvQuestion : TextView? = null
    var Image : ImageView? = null
    var progressBar: ProgressBar? = null
    var tvProgress : TextView? = null
    var tvOptionOne : TextView? = null
    var tvOptionTwo : TextView? = null
    var tvOptionThree : TextView? = null
    var tvOptionFour : TextView? = null
    var btnSubmit : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvQuestion  = findViewById(R.id.tvQuestion)
        Image = findViewById(R.id.questionImage)
        progressBar = findViewById(R.id.progressBar)
        tvOptionOne = findViewById(R.id.option_one)
        tvOptionTwo = findViewById(R.id.option_two)
        tvOptionThree = findViewById(R.id.option_three)
        tvOptionFour = findViewById(R.id.option_four)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvProgress = findViewById(R.id.tvProgress)
        progressBar = findViewById(R.id.progressBar)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        questionList = Constraints.getQuestion()
        getQuestion()
        user_name = intent.getStringExtra(Constraints.USER_NAME).toString()

    }

    private fun getQuestion() {
        defaultOptionTv()
        var question = questionList!![currentQuestionNumber - 1]
        Image?.setImageResource(question.Image)
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        progressBar?.progress = currentQuestionNumber
        tvProgress?.text = "$currentQuestionNumber/${progressBar?.max}"


    }

    private fun defaultOptionTv(){
        var options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for(option in options){
            option.setTextColor(Color.BLACK)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.option_border)
        }
    }

    private fun selectedOptionView(textView: TextView,selectedOptionNum : Int){
        defaultOptionTv()
        currentSelectedOptionPosition = selectedOptionNum
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.background = ContextCompat.getDrawable(this,R.drawable.selected_options_border)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one->{
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.option_two ->{
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.option_three ->{
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.option_four ->{
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btnSubmit ->{
                btnSubmit?.let {
                    if(currentSelectedOptionPosition == 0){
                        currentQuestionNumber= currentQuestionNumber + 1
                        if(currentQuestionNumber <= questionList.size ){
                            btnSubmit?.text = "SUBMIT"
                            getQuestion()
                        }else{
                            var intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constraints.USER_NAME,user_name)
                            intent.putExtra(Constraints.CORRECT_ANSWER,correctAnswer)
                            intent.putExtra(Constraints.TOTAL_QUESTION,questionList.size)
                            startActivity(intent)
                            finish()
                        }
                    }else{
                        var answer : Int = questionList?.get(currentQuestionNumber - 1)!!.answer
                        if(currentSelectedOptionPosition != answer){
                            answerView(currentSelectedOptionPosition,R.drawable.wrong_option_border)
                        }else{
                            correctAnswer = correctAnswer + 1
                        }
                        answerView(answer,R.drawable.correct_option_border)
                        if(currentQuestionNumber == questionList.size){
                            btnSubmit?.text = "FINISH"
                        }else{
                            btnSubmit?.text = "NEXT"
                        }
                        currentSelectedOptionPosition = 0

                    }

                }
            }
        }

    }
    fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                tvOptionOne?.let {
                    it.background = ContextCompat.getDrawable(this,drawableView)
                }
            }
            2 -> {
                tvOptionTwo?.let {
                    it.background = ContextCompat.getDrawable(this,drawableView)
                }
            }
            3 -> {
                tvOptionThree?.let {
                    it.background = ContextCompat.getDrawable(this,drawableView)
                }
            }
            4 -> {
                tvOptionFour?.let {
                    it.background = ContextCompat.getDrawable(this,drawableView)
                }
            }

        }
    }
}