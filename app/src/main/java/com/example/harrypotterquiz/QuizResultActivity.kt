package com.example.harrypotterquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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



        showGif(R.drawable.image_congo, R.id.imageView)
        val score = intent.getIntExtra(SCORE_EXTRA, 0)
        val resultText: TextView = findViewById(R.id.result_text)
        val endImage: ImageView = findViewById(R.id.end_image)


        resultText.text =when(score){
            0 -> "Sorry! Your Score is $score better luck next time"
            1 -> "Sorry! Your Score is $score better luck next time"
            2 -> "Sorry! Your Score is $score better luck next time"
            3 -> "Hurray! Your Score is $score, Well Played"
            4 -> "Hurray! Your Score is $score, Well Played"
            else -> "Hurray! Your Score is $score, Well Played"
        }
        when(score){
            0 -> {showGif(R.drawable.voldie_smile, R.id.end_image)
            showGif(R.drawable.image_sorry, R.id.imageView)}
            1 -> {showGif(R.drawable.voldie_smile, R.id.end_image)
                showGif(R.drawable.image_sorry, R.id.imageView)}
            2 -> {showGif(R.drawable.voldie_smile, R.id.end_image)
                showGif(R.drawable.image_sorry, R.id.imageView)}
            3 -> {showGif(R.drawable.voldie_smile, R.id.end_image)
                showGif(R.drawable.image_sorry, R.id.imageView)}
            4 -> {showGif(R.drawable.hermione_smiles, R.id.end_image)
                showGif(R.drawable.image_congo, R.id.imageView)}
            5 -> {showGif(R.drawable.hermione_smiles, R.id.end_image)
                showGif(R.drawable.image_congo, R.id.imageView)}
        }

        val playAgainButton: Button = findViewById(R.id.play_again)
        playAgainButton.setOnClickListener { playAgain() }


    }

    private fun playAgain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()

    }

    private fun showGif(imageId: Int, imageViewId: Int) {val imageView: ImageView = findViewById(imageViewId)
        Glide.with(this).load(imageId).into(imageView)}

}