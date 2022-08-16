package com.example.transitions

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.transitions.databinding.ContactListLayoutBinding

class TransitionsDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ContactListLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnClickListener {
            val newScene = Scene.getSceneForLayout(
                binding.root,
                R.layout.contact_info_layout,
                this
            )
            val transition = ChangeBounds().apply {
                duration = 3000
                interpolator = AccelerateDecelerateInterpolator()
            }
            TransitionManager.go(newScene, transition)

        }
    }
}
