package com.example.harrypotterquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterquiz.adapter.ItemAdapter
import com.example.harrypotterquiz.data.Datasource

class MainActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {
    companion object{

        val MARKED_OPTIONS = mutableListOf<Int>()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataSet = Datasource().loadQuestions()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ItemAdapter(this, myDataSet, this)

        recyclerView.setHasFixedSize(true)

        val button: Button = findViewById(R.id.submit_button)
        button.setOnClickListener { loadResult() }


    }

    private fun loadResult() {

//        val answers = listOf(R.string.question_1_option_B, R.string.question_2_option_A, R.string.question_3_option_B, R.string.question_4_option_A, R.string.question_5_option_C)




        val intent = Intent(this, QuizResultActivity::class.java)

        startActivity(intent)


    }

    override fun onClick(position: Int) {
        Toast.makeText(this,"Question ${position+1}", Toast.LENGTH_LONG).show()
    }

    override fun onLongClick(position: Int) {
        Toast.makeText(this,"onLongClick ${position+1}", Toast.LENGTH_LONG).show()
    }



}