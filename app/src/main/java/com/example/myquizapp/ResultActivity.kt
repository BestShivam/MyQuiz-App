package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    var tvName : TextView? = null
    var correctAnswer : Int = 0
    var totalQuestion : Int = 0
    var user_name = ""
    var btnFinish : Button? = null
    var tvScore : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvName = findViewById(R.id.tvCandidateName)
        btnFinish = findViewById(R.id.btnFinish)
        tvScore = findViewById(R.id.tvScore)
        user_name = intent.getStringExtra(Constraints.USER_NAME).toString()
        correctAnswer = intent.getIntExtra(Constraints.CORRECT_ANSWER,0)
        totalQuestion = intent.getIntExtra(Constraints.TOTAL_QUESTION,0)
        tvName?.text = user_name
        tvScore?.text = "Your score is $correctAnswer out of $totalQuestion"

        btnFinish?.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}