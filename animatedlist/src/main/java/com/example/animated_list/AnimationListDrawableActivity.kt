package com.example.animated_list

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animated_list.databinding.AnimationListLayoutBinding

class AnimationListDrawableActivity : AppCompatActivity() {

    private lateinit var gradientAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = AnimationListLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gradientAnimation = binding.root.background as AnimationDrawable
    }

    override fun onStart() {
        super.onStart()
        gradientAnimation.apply {
            setExitFadeDuration(resources.getInteger(com.example.uikit.R.integer.anim_extra_long))
            start()
        }
    }

    override fun onStop() {
        super.onStop()
        gradientAnimation.stop()
    }
}
