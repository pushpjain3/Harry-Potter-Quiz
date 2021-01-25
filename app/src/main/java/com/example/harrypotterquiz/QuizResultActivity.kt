package com.example.harrypotterquiz

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class QuizResultActivity : AppCompatActivity() {

    companion object{
        const val SCORE_EXTRA = "score_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        showGif()
        val score = intent.getStringExtra(SCORE_EXTRA)
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = " Congo! Your Score is $score / 5"


    }

    private fun showGif() {val imageView: ImageView = findViewById(R.id.imageView)
        Glide.with(this).load(R.drawable.image_congo).into(imageView)}

}