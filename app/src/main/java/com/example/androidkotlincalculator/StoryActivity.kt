package com.example.androidkotlincalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlincalculator.databinding.ActivityMainBinding
import com.example.androidkotlincalculator.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityStoryBinding
    private var buttonBackToMain: Button? = null
    private var buttonBackToPercent: Button? = null




        @SuppressLint("SuspiciousIndentation")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityStoryBinding.inflate(layoutInflater)
            with(binding)
            {
                setContentView(root)
            textView.text = StorySingleton.getStoryList().toString()
                buttonBackToMain.setOnClickListener{
                    val intent = Intent(this@StoryActivity,MainActivity::class.java)
                    startActivity(intent)
                }
                buttonBackToPercent.setOnClickListener {
                    val intent = Intent(this@StoryActivity, PercentActivity::class.java)
                    startActivity(intent)
                }
        }
    }
}