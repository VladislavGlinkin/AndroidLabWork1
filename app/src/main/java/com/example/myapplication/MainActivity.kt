package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.DataGenerator.Companion.findIndexes
import com.example.myapplication.DataGenerator.Companion.generateRandomNumbers

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)
        resultTextView = findViewById(R.id.resultTextView)

        val findIndexButton: Button = findViewById(R.id.findIndexButton)
        findIndexButton.setOnClickListener {
            val inputText = inputEditText.text.toString().trim()
            if (inputText.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите входные данные до поиска индексов", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val numbers = inputEditText.text.toString().split(",").map { it.trim().toIntOrNull() ?: 0 }

            if (numbers.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите входные данные до поиска индексов", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val (firstNegativeIndex, lastPositiveIndex) = findIndexes(numbers)

            val result = "Индекс первого отрицательного числа: $firstNegativeIndex\n" +
                    "Индекс последнего положительного числа: $lastPositiveIndex"
            resultTextView.text = result
        }

        val generateInputButton: Button = findViewById(R.id.generateInputButton)
        generateInputButton.setOnClickListener {
            val input = generateRandomNumbers()
            inputEditText.setText(input.joinToString(", "))
        }
    }
}
