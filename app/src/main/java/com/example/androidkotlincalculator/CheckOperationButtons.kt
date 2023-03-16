package com.example.androidkotlincalculator

import android.annotation.SuppressLint

class CheckOperationButtons {
    var lastChar = '\u0000'

    @SuppressLint("SuspiciousIndentation")
    fun toCheckOperationButtons(checkTextView:String): Boolean {
        if (checkTextView != "") lastChar = checkTextView[checkTextView.length - 1]
            if (lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/' && lastChar != '.' && lastChar != '\u0000' ) return true
        return false
    }
}