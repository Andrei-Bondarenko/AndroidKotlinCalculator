package com.example.androidkotlincalculator

object PercentCalculator {
    var firstPercentNumber: Double = 0.0
    var secondPercentNumber: Double = 0.0
    var percentOperation: Double = 0.0
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
        percentOperation = firstPercentNumber + secondPercentNumber
        answer = "$firstNumber + $secondNumber = $percentOperation"
    }

    fun toSubtract(firstNumber: Double, secondNumber: Double) {
        secondPercentNumber = firstNumber / 100 * secondNumber
        percentOperation = firstPercentNumber - secondPercentNumber
        answer = "$firstNumber - $secondNumber = $percentOperation"
    }

    fun toMultiply(firstNumber: Double, secondNumber: Double) {
        secondPercentNumber = firstNumber / 100 * secondNumber
        percentOperation = firstPercentNumber * secondPercentNumber
        answer = "$firstNumber * $secondNumber = $percentOperation"
    }

    fun toDivide(firstNumber: Double, secondNumber: Double) {
        secondPercentNumber = firstNumber / 100 * secondNumber
        percentOperation = firstPercentNumber / secondPercentNumber
        answer = "$firstNumber / $secondNumber = $percentOperation"
    }

}