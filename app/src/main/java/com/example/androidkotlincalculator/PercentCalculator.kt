package com.example.androidkotlincalculator

object PercentCalculator {
    var firstPercentNumber: Double = 0.0
    var secondPercentNumber: Double = 0.0
    var PercentOperation: Double = 0.0
    var answer: String = ""


    fun chooseOperation(lastOperation: String) {
        when (lastOperation) {
            "+" -> toAdd(firstPercentNumber, secondPercentNumber)
            "-" -> toSubtract(firstPercentNumber, secondPercentNumber)
            "*" -> toMultiply(firstPercentNumber, secondPercentNumber)
            "/" -> toDivide(firstPercentNumber, secondPercentNumber)
        }
    }


    fun toAdd(firstNumber: Double,secondNumber: Double) {
        secondPercentNumber = firstNumber / 100 * secondNumber
        PercentOperation = firstPercentNumber + secondPercentNumber
        answer = "$firstNumber + $secondNumber = $PercentOperation"
    }

    fun toSubtract(firstNumber: Double, secondNumber: Double) {
        secondPercentNumber = firstNumber / 100 * secondNumber
        PercentOperation = firstPercentNumber - secondPercentNumber
        answer = "$firstNumber - $secondNumber = $PercentOperation"
    }

    fun toMultiply(firstNumber: Double, secondNumber: Double) {
        secondPercentNumber = firstNumber / 100 * secondNumber
        PercentOperation = firstPercentNumber * secondPercentNumber
        answer = "$firstNumber * $secondNumber = $PercentOperation"
    }

    fun toDivide(firstNumber: Double, secondNumber: Double) {
        secondPercentNumber = firstNumber / 100 * secondNumber
        PercentOperation = firstPercentNumber / secondPercentNumber
        answer = "$firstNumber / $secondNumber = $PercentOperation"
    }

}