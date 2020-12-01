package com.yvkalume.storyview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import jp.shts.android.storiesprogressview.StoriesProgressView


class StoryActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        val storyView = findViewById<StoriesProgressView>(R.id.storyView)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val storyUserName = findViewById<TextView>(R.id.storyUserName)

        val images = arrayListOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3)

        val user = User("Yves Kalume",images)

        storyView.setStoriesCount(user.storiesImage.size)
        storyView.setStoryDuration(3000L)
        storyUserName.text = user.name
        imageView.setImageResource(user.storiesImage[counter])

        storyView.setStoriesListener(object : StoriesProgressView.StoriesListener{
            override fun onNext() {
                imageView.setImageResource(user.storiesImage[++counter])
            }

            override fun onPrev() {
                imageView.setImageResource(user.storiesImage[--counter])
            }

            override fun onComplete() {
                finish()
            }

        })

        storyView.startStories()

        imageView.setOnClickListener {
            storyView.skip()
        }

        imageView.setOnLongClickListener {
            storyView.pause()

            true
        }
    }
}