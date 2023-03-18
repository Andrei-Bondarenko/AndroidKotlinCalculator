package com.example.androidkotlincalculator

class PercentButtons {
    private var numberList: ArrayList<String> = ArrayList()
    var operationList: ArrayList<String> = ArrayList()
    var lastOperation = ""
    var text = ""
    var num1 = 0.0
    var lastChar = '\u0000'
    private val checkOperationButtons: CheckOperationButtons = TODO()


    fun buttonOperationHandler(calculatorOperation: String, checkTextView: String): Int {
        if (checkTextView != "") {
            if (checkOperationButtons.toCheckOperationButtons(checkTextView)) {
                if (lastOperation == "") {
                    lastOperation = calculatorOperation
                    numberList.add(checkTextView)
                    operationList.add(calculatorOperation)
                } else {
                    if (lastOperation != "=") {
                        val list = checkTextView.split(lastOperation).toMutableList()
                        lastOperation = calculatorOperation
                        operationList.add(calculatorOperation)
                        numberList.add(list[list.size - 1])
                    } else {
                        operationList.add(calculatorOperation)
                        lastOperation = calculatorOperation
                    }
                }
                return 1
            } else {
                text = checkTextView.substring(0, checkTextView.length - 1) + calculatorOperation
                if (lastOperation != "=") {
                    lastOperation = calculatorOperation
                    val list = text.split(lastOperation).toMutableList()
                    if (list.contains("")) {
                        list.remove("")
                    }
                    numberList.removeAt(numberList.lastIndex)
                    operationList.removeAt(operationList.lastIndex)
                    operationList.add(calculatorOperation)
                    numberList.add(list[list.size - 1])
                } else {
                    numberList.removeAt(numberList.lastIndex)
                    operationList.removeAt(operationList.lastIndex)
                    operationList.add(calculatorOperation)
                    lastOperation = calculatorOperation
                }
                lastOperation = calculatorOperation
                return 2
            }
        }else return 3
    }

    fun buttonPointHandler(checkTextView: String):Int {
        return 1
    }


    fun buttonEqualHandler(checkTextView: String): Boolean {
        if (checkOperationButtons.toCheckOperationButtons(checkTextView)) {
            if (lastOperation != "") {
                var list = checkTextView.split(lastOperation).toMutableList()
                numberList.add(list[list.size - 1])
                num1 = numberList[0].toDouble()
                for (i in numberList.indices) {
                    if (i > 0) {
                        lastOperation = operationList[i - 1]
                        PercentCalculator.firstPercentNumber = num1
                        PercentCalculator.secondPercentNumber = numberList[i].toDouble()
                        PercentCalculator.chooseOperation(lastOperation)
                        num1 =PercentCalculator.percentOperation
                    }
                }
                lastOperation = "="
                num1 = PercentCalculator.percentOperation
                PercentCalculator.secondPercentNumber = 0.0
                numberList.clear()
                operationList.clear()
                numberList.add(num1.toString())
                text = "$num1"
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
                operationList.removeAt(operationList.lastIndex)
                text = checkTextView.substring(0, checkTextView.length - 1)
            }
            return true
        } else return false
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