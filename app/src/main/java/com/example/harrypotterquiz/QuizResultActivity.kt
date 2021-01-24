package com.example.harrypotterquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class QuizResultActivity : AppCompatActivity() {

    companion object{
        const val SCORE_EXTRA = "score_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

    }
}