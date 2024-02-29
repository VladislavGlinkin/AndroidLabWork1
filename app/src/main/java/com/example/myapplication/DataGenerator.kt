package com.example.myapplication

import kotlin.random.Random

class DataGenerator {
    companion object {
        fun generateRandomNumbers(): List<Int> {
            val random = Random(System.currentTimeMillis())
            val size = 10 // Размер списка
            return List(size) {
                random.nextInt(
                    -100,
                    100
                )
            } // Генерация случайных чисел от -100 до 100
        }

        fun findIndexes(numbers: List<Int>): Pair<Int, Int> {
            val firstNegativeIndex = numbers.indexOfFirst { it < 0 }
            val lastPositiveIndex = numbers.indexOfLast { it > 0 }

            return Pair(firstNegativeIndex, lastPositiveIndex)
        }
    }
}