package com.example.androidkotlincalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidkotlincalculator.databinding.ActivityMainBinding

class PercentActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var buttons: PercentButtons = TODO()
    var calculatorNumber: String = ""
    private var calculatorOperation: String = ""
    private var checkTextView: String = ""


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            textView.text = ""
            button0.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "0"
            }
            button1.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "1"
            }
            button2.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "2"
            }
            button3.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "3"
            }
            button4.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "4"
            }
            button5.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "5"
            }
            button6.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "6"
            }
            button7.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "7"
            }
            button8.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "8"
            }
            button9.setOnClickListener {
                textView.text = textView.text
                calculatorNumber = "9"
            }
            buttonPlus.setOnClickListener {
                checkTextView = textView.text.toString()
                if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1){
                    calculatorOperation = "+"
                    textView.text = "${textView.text}+"
                }
                else {
                    calculatorOperation = "+"
                    textView.text = buttons.text
                }
            }
            buttonMinus.setOnClickListener {
                checkTextView = textView.text.toString()
                if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1){
                    calculatorOperation = "-"
                    textView.text = "${textView.text}+"
                }
                else {
                    calculatorOperation = "-"
                    textView.text = buttons.text
                }
            }
            buttonMultiply.setOnClickListener {
                checkTextView = textView.text.toString()
                if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1){
                    calculatorOperation = "/"
                    textView.text = "${textView.text}+"
                }
                else {
                    calculatorOperation = "/"
                    textView.text = buttons.text
                }
            }

            buttonDivide.setOnClickListener {
                checkTextView = textView.text.toString()
                if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1){
                    calculatorOperation = "*"
                    textView.text = "${textView.text}+"
                }
                else {
                    calculatorOperation = "*"
                    textView.text = buttons.text
                }
            }

            buttonPoint.setOnClickListener {
                checkTextView = textView.text.toString()
                if (buttons.buttonPointHandler(checkTextView) == 1) textView.text = "0."
                else if (buttons.buttonPointHandler(checkTextView) == 2)
                    textView.text = textView.text.toString() + "."
                else if (buttons.buttonPointHandler(checkTextView) == 3)
                    textView.text = textView.text.toString() + "0."

            }

            buttonEqual.setOnClickListener {
                checkTextView = textView.text.toString()
                if (buttons.buttonEqualHandler(checkTextView)) {
                    textView.text = Calculator.answer
                    StorySingleton.setStoryEntry(Calculator.answer)
                }
            }
            buttonDelete.setOnClickListener {
                checkTextView = textView.text.toString()
                if (buttons.buttonDeleteHandler(checkTextView)) textView.text = buttons.text
            }
            buttonDelete.setOnLongClickListener {
                buttons.buttonClearAll()
                calculatorNumber = ""
                calculatorOperation = ""
                checkTextView = ""
                textView.text = ""
                true
            }
        }
    }
}