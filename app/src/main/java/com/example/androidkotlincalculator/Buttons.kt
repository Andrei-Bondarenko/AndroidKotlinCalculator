package com.example.androidkotlincalculator

class Buttons {
    private var numberList: ArrayList<String> = ArrayList()
    var operationList: ArrayList<String> = ArrayList()
    private var lastOperation = ""
    var text = ""
    var num1 = 0.0
    var lastChar = '\u0000'
    private val checkOperationButtons: CheckOperationButtons = TODO()


    fun buttonOperationHandler(calculatorOperation: String, checkTextView: String): Int {
        if (checkOperationButtons.toCheckOperationButtons(checkTextView)) {
            if (lastOperation == "") {
                lastOperation = calculatorOperation
                numberList.add(checkTextView)
                operationList.add(calculatorOperation)
            } else {
                val list = checkTextView.split(lastOperation).toTypedArray()
                lastOperation = calculatorOperation
                operationList.add(calculatorOperation)
                numberList.add(list[list.size - 1])
            }
            return 1
        } else {
            text = checkTextView.substring(0, checkTextView.length - 1) + calculatorOperation
            var checkTextView = text
            lastOperation = calculatorOperation
            return 2
        }
    }


    fun buttonEqualHandler(checkTextView: String): Boolean {
        if (checkOperationButtons.toCheckOperationButtons(checkTextView)) {
            if (lastOperation != "") {
                num1 = numberList[0].toDouble()
                for (i in numberList.indices) {
                    if (i > 0) {
                        if (operationList[i] != null) {
                            lastOperation = operationList[i - 1]
                            Calculator.firstNumber = num1
                            Calculator.secondNumber = numberList[i].toDouble()
                            Calculator.chooseOperation(lastOperation)
                        }
                    }
                }
                lastOperation = "="
                num1 = Calculator.operation
                Calculator.secondNumber = 0.0
                numberList.clear()
                operationList.clear()
                numberList.add(num1.toString())
            }
            return true
        }
        return false
    }

    fun buttonDeleteHandler(checkTextView: String): Boolean {
        if (checkTextView != "") {
            lastChar = checkTextView[checkTextView.length - 1]
            if (lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/' && lastChar != '.' && lastChar != '=') {
                numberList[numberList.lastIndex].substring(0, numberList[numberList.lastIndex].length - 1
                )
                text = checkTextView.substring(0, checkTextView.length - 1)
            } else if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '.' || lastChar == '=') {
                operationList.remove(operationList[operationList.lastIndex])
                text = checkTextView.substring(0, checkTextView.length - 1)
            }
            return true
        }
        return false
    }
    fun buttonClearAll() {
        numberList.clear()
        operationList.clear()
        lastOperation = ""
        text = ""
        num1 = 0.0
        lastChar = '\u0000'
    }
}
