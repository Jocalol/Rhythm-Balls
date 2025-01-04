package com.example.rhythmballs

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log

class Ball {
    var x = 0
    var y = 0
    var lifetime = 0
    var decayProgress = 17 * 5

    var bitmap : Bitmap

    var clickable = true

    var detectCollision : Rect

    var paint = Paint()


    constructor(context: Context, width: Int, height: Int) {
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.inicio_bola_a)
        bitmap = Bitmap.createScaledBitmap(bitmap, 250, 250, false)

        lifetime = decayProgress

        detectCollision = Rect(x,y, bitmap.width, bitmap.height)
    }

    fun click() {
        clickable = false
    }

    fun update() {
        if (clickable) {

            if (decayProgress > 0) {
                decayProgress--
            } else {
                decayProgress = 0
                y += 3
                if (paint.alpha > 35) {
                    paint.setAlpha(paint.alpha - 35)
                } else {
                    paint.setAlpha(0)
                    clickable = false
                }
            }
        }

        detectCollision.left = x
        detectCollision.top = y
        detectCollision.right = x + bitmap.width
        detectCollision.bottom = y + bitmap.height

        Log.d("game", lifetime.toString())
    }
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
    }
}