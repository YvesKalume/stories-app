package com.yvkalume.storyview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_UP
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import jp.shts.android.storiesprogressview.StoriesProgressView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgView = findViewById<ImageView>(R.id.imageView)
        imgView.setOnClickListener {
           val intent = Intent(this,StoryActivity::class.java)
            startActivity(intent)
        }

    }

}