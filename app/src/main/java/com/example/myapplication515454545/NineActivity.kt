package com.example.myapplication515454545

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class NineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nine_activity)

        val textView = findViewById<View>(R.id.textView) as TextView
        textView.text = "9"
    }
}