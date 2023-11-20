package com.example.volleyball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var titleTopic: String = "Текст кнопки"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAspect: Button = findViewById(R.id.button_Aspect)
        buttonAspect.setOnClickListener {
            titleTopic = buttonAspect.text.toString()
            val intent = Intent(this, Activity_Victorina::class.java)
            intent.putExtra("BUTTON_TITLE", titleTopic)
            startActivity(intent)
        }

        val buttonHistory: Button = findViewById(R.id.button_History)
        buttonHistory.setOnClickListener {
            titleTopic = buttonHistory.text.toString()
            val intent = Intent(this, Activity_Victorina::class.java)
            intent.putExtra("BUTTON_TITLE", titleTopic)
            startActivity(intent)
        }

        val buttonRules: Button = findViewById(R.id.button_Rules)
        buttonRules.setOnClickListener {
            titleTopic = buttonRules.text.toString()
            val intent = Intent(this, Activity_Victorina::class.java)
            intent.putExtra("BUTTON_TITLE", titleTopic)
            startActivity(intent)
        }

        val buttonPlans: Button = findViewById(R.id.button_Plans)
        buttonPlans.setOnClickListener {
            titleTopic = buttonPlans.text.toString()
            val intent = Intent(this, Activity_Victorina::class.java)
            intent.putExtra("BUTTON_TITLE", titleTopic)
            startActivity(intent)
        }
    }
}