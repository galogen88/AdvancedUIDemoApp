package com.example.customdrawable

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.Rect
import android.graphics.Shader
import android.graphics.drawable.Drawable
import android.os.SystemClock

class MulticolorAnimatedGradientDrawable(
    private val colors: IntArray = defaultColors
) : Drawable() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val duration = 5000L * colors.size

    private var previousDrawTime = 0
    private val extenderColorsCount = colors.size + 2

    override fun onBoundsChange(bounds: Rect?) {
        super.onBoundsChange(bounds)

        val colorsExtended = IntArray(extenderColorsCount)
        System.arraycopy(colors, 0, colorsExtended, 0, colors.size)
        colorsExtended[colors.size] = colors[0]
        colorsExtended[colors.size + 1] = colors[1]

        val gradient =
            LinearGradient(
                0f,
                0f,
                getBounds().width() * (colors.size + 1).toFloat(),
                0f,
                colorsExtended,
                null,
                Shader.TileMode.CLAMP
            )
        paint.shader = gradient
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }

    override fun draw(canvas: Canvas) {
        val now = SystemClock.uptimeMillis()
        val timeDelta = (now - previousDrawTime) % duration

        val dx = bounds.width() * colors.size * timeDelta / duration.toFloat()

        canvas.save()
        canvas.translate(-dx, 0f)
        canvas.drawRect(
            0f,
            0f,
            bounds.width() * (extenderColorsCount).toFloat(),
            bounds.height().toFloat(),
            paint
        )
        canvas.restore()

        invalidateSelf()
    }

    companion object {
        private val defaultColors = intArrayOf(
            Color.parseColor("#FF48CCE0"),
            Color.parseColor("#FF505ADD"),
            Color.parseColor("#FFBE40C0"),
            Color.parseColor("#FFFBA82B")
        )
    }
}
