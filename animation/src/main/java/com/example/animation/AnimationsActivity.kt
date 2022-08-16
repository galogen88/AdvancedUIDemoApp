package com.example.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.databinding.RocketTripLayoutBinding

class AnimationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = RocketTripLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnClickListener {
            showViewPropertyAnimator(binding)
        }
    }

    private fun showObjectAnimator(binding: RocketTripLayoutBinding) {

        val start = binding.rocket.y
        val end = binding.moon.y - binding.moon.height / 2

        ObjectAnimator.ofFloat(binding.rocket, View.TRANSLATION_Y, start, end).apply {
            duration = 3000
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }
    }

    private fun showValueAnimator(binding: RocketTripLayoutBinding) {

        val start = binding.rocket.y
        val end = binding.moon.y - binding.moon.height / 2
        val distance = end - start

        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 3000
            interpolator = AccelerateDecelerateInterpolator()

            addUpdateListener {
                val progress = it.animatedValue as Float

                binding.moon.scaleX = progress
                binding.moon.scaleY = progress

                binding.rocket.y = start + distance * progress
            }

            start()
        }

    }


    private fun showViewPropertyAnimator(binding: RocketTripLayoutBinding) {

        val start = binding.rocket.y
        val end = binding.moon.y - binding.moon.height / 2

        binding.rocket.animate()
            .translationY(end - start)
            .rotationBy(180f)
            .scaleX(0.1f)
            .scaleY(0.1f)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setDuration(3000)
            .start()


    }
}
