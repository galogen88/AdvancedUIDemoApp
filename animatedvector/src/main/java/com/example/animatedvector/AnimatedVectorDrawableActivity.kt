package com.example.animatedvector

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.animatedvector.databinding.PlayPauseButtonLayoutBinding

class AnimatedVectorDrawableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = PlayPauseButtonLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playPauseView.apply {
            val animation = drawable as AnimatedVectorDrawable
            setOnClickListener { animation.start() }
        }

    }
}
