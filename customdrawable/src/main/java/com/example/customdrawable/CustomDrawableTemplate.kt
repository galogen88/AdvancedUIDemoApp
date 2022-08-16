package com.example.customdrawable

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.drawable.Drawable

class CustomDrawableTemplate : Drawable() {
    override fun draw(canvas: Canvas) {
        // make your drawing here
    }

    override fun onBoundsChange(bounds: Rect?) {
        super.onBoundsChange(bounds)

        // update bound
    }

    override fun setAlpha(alpha: Int) {
        // apply alpha to your drawable
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        // apply color filter to our drawable
    }

    override fun getOpacity(): Int {
        // is drawable opaque?
        return PixelFormat.OPAQUE
    }
}
