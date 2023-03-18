package com.example.androidkotlincalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidkotlincalculator.databinding.ActivityMainBinding
import com.example.androidkotlincalculator.databinding.ActivityPercentBinding

class PercentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPercentBinding
    private var buttons: PercentButtons = PercentButtons()
    var calculatorNumber: String = ""
    private var calculatorOperation: String = ""
    private var checkTextView: String = ""


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPercentBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            textView.text = ""
            button0.setOnClickListener {
                textView.text = "${textView.text}0"
                calculatorNumber = "0"
            }
            button1.setOnClickListener {
                textView.text = "${textView.text}1"
                calculatorNumber = "1"
            }
            button2.setOnClickListener {
                textView.text = "${textView.text}2"
                calculatorNumber = "2"
            }
            button3.setOnClickListener {
                textView.text = "${textView.text}3"
                calculatorNumber = "3"
            }
            button4.setOnClickListener {
                textView.text = "${textView.text}4"
                calculatorNumber = "4"
            }
            button5.setOnClickListener {
                textView.text = "${textView.text}5"
                calculatorNumber = "5"
            }
            button6.setOnClickListener {
                textView.text = "${textView.text}6"
                calculatorNumber = "6"
            }
            button7.setOnClickListener {
                textView.text = "${textView.text}7"
                calculatorNumber = "7"
            }
            button8.setOnClickListener {
                textView.text = "${textView.text}8"
                calculatorNumber = "8"
            }
            button9.setOnClickListener {
                textView.text = "${textView.text}9"
                calculatorNumber = "9"
            }
            buttonPlus.setOnClickListener {
                if (textView.text.toString() != "") {
                    if (buttons.lastOperation == "=") {
                        textView.text = buttons.text
                    }
                    checkTextView = textView.text.toString()
                    calculatorOperation = "+"
                    if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1) {
                        textView.text = "$checkTextView+"
                    } else if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 2) {
                        textView.text = buttons.text
                    }
                }
            }
            buttonMinus.setOnClickListener {
                if (textView.text.toString() != "") {
                    if (buttons.lastOperation == "=") {
                        textView.text = buttons.text
                    }
                    checkTextView = textView.text.toString()
                    calculatorOperation = "-"
                    if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1) {
                        textView.text = "$checkTextView-"
                    } else if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 2) {
                        textView.text = buttons.text
                    }
                }
            }
            buttonMultiply.setOnClickListener {
                if (textView.text.toString() != "") {
                    if (buttons.lastOperation == "=") {
                        textView.text = buttons.text
                    }
                    checkTextView = textView.text.toString()
                    calculatorOperation = "*"
                    if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1) {
                        textView.text = "$checkTextView*"
                    } else if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 2) {
                        textView.text = buttons.text
                    }
                }
            }

            buttonDivide.setOnClickListener {
                if (textView.text.toString() != "") {
                    if (buttons.lastOperation == "=") {
                        textView.text = buttons.text
                    }
                    checkTextView = textView.text.toString()
                    calculatorOperation = "/"
                    if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 1) {
                        textView.text = "$checkTextView/"
                    } else if (buttons.buttonOperationHandler(calculatorOperation, checkTextView) == 2) {
                        textView.text = buttons.text
                    }
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
                if (buttons.buttonDeleteHandler(checkTextView)) textView.text =
                    buttons.text
            }
            buttonDelete.setOnLongClickListener {
                buttons.buttonClearAll()
                calculatorNumber = ""
                calculatorOperation = ""
                checkTextView = ""
                textView.text = ""
                true
            }

            buttonBack.setOnClickListener {
                val intent = Intent(this@PercentActivity, MainActivity::class.java)
                startActivity(intent)
            }

            buttonStory.setOnClickListener {
                val intent = Intent(this@PercentActivity, StoryActivity::class.java)
                startActivity(intent)
            }
        }
    }
}