package com.example.harrypotterquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterquiz.adapter.ItemAdapter
import com.example.harrypotterquiz.data.Datasource

interface OnCheckedChangeListener{
    fun onCheckedChanged(position: Int, checkedId: Int)

}

class MainActivity : AppCompatActivity(){
    companion object{
//        val MARKED_OPTIONS = mutableListOf<Int>()

//        val answers = listOf(R.string.question_1_option_B,
//                R.string.question_2_option_A,
//                R.string.question_3_option_B,
//                R.string.question_4_option_A,
//                R.string.question_5_option_C)
        val answers = listOf(R.id.item_option_2,
        R.id.item_option_1,
        R.id.item_option_2,
        R.id.item_option_1,
        R.id.item_option_3)


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataSet = Datasource().loadQuestions()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ItemAdapter(this, myDataSet, listener)

        recyclerView.setHasFixedSize(true)

        val button: Button = findViewById(R.id.submit_button)
        button.setOnClickListener { loadResult() }

    }

    private fun loadResult() {


        val intent = Intent(this, QuizResultActivity::class.java)
        intent.putExtra(QuizResultActivity.SCORE_EXTRA, score)
        startActivity(intent)
        Toast.makeText(this,"Your Score is $score", Toast.LENGTH_LONG).show()
        this.finishAfterTransition()
    }

    var score =0

    private val listener = object: OnCheckedChangeListener {
        override fun onCheckedChanged(position: Int, checkedId: Int) {

            val radioButton1: RadioButton = findViewById(R.id.item_option_1)
            val radioButton2: RadioButton = findViewById(R.id.item_option_2)
            val radioButton3: RadioButton = findViewById(R.id.item_option_3)

            if(checkedId == answers[position]){
                score+= 1
            }







        }
    }


}