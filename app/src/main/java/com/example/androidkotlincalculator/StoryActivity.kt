package com.example.androidkotlincalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlincalculator.databinding.ActivityMainBinding

class StoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var checkTextView: String = ""
    private var buttonBackToMain: Button? = null
    private var buttonBackToPercent: Button? = null




        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            with(binding)
            {
                setContentView(root)
            textView.text = StorySingleton.getStoryList().toString()
            buttonBackToMain = findViewById(R.id.buttonBackToMain)
            buttonBackToMain.setOnClickListener(View.OnClickListener {
                val intent:Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })
            buttonBackToPercent = findViewById(R.id.buttonBackToPercent)
            buttonBackToPercent.setOnClickListener(View.OnClickListener { view: View? ->
                val intent = Intent(this, PercentActivity::class.java)
                startActivity(intent)
            })
        }
    }
}