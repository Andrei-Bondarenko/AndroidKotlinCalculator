package com.example.androidkotlincalculator

object Calculator {
   var firstNumber: Double = 0.0
   var secondNumber: Double = 0.0
   var operation: Double = 0.0
   var answer: String = ""


    fun chooseOperation(lastOperation: String) {
        when (lastOperation) {
            "+" -> toAdd(firstNumber, secondNumber)
            "-" -> toSubtract(firstNumber, secondNumber)
            "*" -> toMultiply(firstNumber, secondNumber)
            "/" -> toDivide(firstNumber, secondNumber)
        }
    }

    fun toAdd(firstNumber: Double, secondNumber: Double) {
        operation = firstNumber + secondNumber
        answer = "$firstNumber + $secondNumber = $operation"
        StorySingleton.setStoryEntry(answer)
    }

    fun toSubtract(firstNumber: Double, secondNumber: Double) {
        operation = firstNumber - secondNumber
        answer = "$firstNumber - $secondNumber = $operation"
        StorySingleton.setStoryEntry(answer)
    }

    fun toMultiply(firstNumber: Double, secondNumber: Double) {
        operation = firstNumber * secondNumber
        answer = "$firstNumber * $secondNumber = $operation"
        StorySingleton.setStoryEntry(answer)
    }

    fun toDivide(firstNumber: Double, secondNumber: Double) {
        operation = firstNumber / secondNumber
        answer = "$firstNumber / $secondNumber = $operation"
        StorySingleton.setStoryEntry(answer)
    }

}