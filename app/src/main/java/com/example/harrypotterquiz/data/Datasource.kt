package com.example.harrypotterquiz.data

import com.example.harrypotterquiz.R
import com.example.harrypotterquiz.model.Question

class Datasource {
    fun loadQuestions(): List<Question>{
        return listOf<Question>(
            Question(R.string.question_1, R.drawable.image_question_1, R.string.question_1_option_A, R.string.question_1_option_B, R.string.question_1_option_C),
            Question(R.string.question_2, R.drawable.image_question_2, R.string.question_2_option_A, R.string.question_2_option_B, R.string.question_2_option_C),
            Question(R.string.question_3, R.drawable.image_question_3, R.string.question_3_option_A, R.string.question_3_option_B, R.string.question_3_option_C),
            Question(R.string.question_4, R.drawable.image_question_4, R.string.question_4_option_A, R.string.question_4_option_B, R.string.question_4_option_C),
            Question(R.string.question_5, R.drawable.image_question_5, R.string.question_5_option_A, R.string.question_5_option_B, R.string.question_5_option_C)
        )
    }
}