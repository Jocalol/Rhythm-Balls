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
    var failed = false

    var bitmap : Bitmap
    var successBitmap : Bitmap
    var failureBitmap : Bitmap

    var clickable = true

    var detectCollision : Rect

    var paint = Paint()


    constructor(context: Context, width: Int, height: Int, decayTime : Int) {
        bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.inicio_bola_a)
        bitmap = Bitmap.createScaledBitmap(bitmap, 250, 250, false)

        successBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.bola_fim_a)
        successBitmap = Bitmap.createScaledBitmap(successBitmap, 250, 250, false)

        failureBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.bolo_errada_a)
        failureBitmap = Bitmap.createScaledBitmap(failureBitmap, 250, 250, false)

        x = width
        y = height

        decayProgress = decayTime
        lifetime = decayProgress

        detectCollision = Rect(x,y, bitmap.width, bitmap.height)
    }

    fun click() {
        clickable = false
        bitmap = successBitmap

    }

    fun update() {
        if (decayProgress > 0) {
            decayProgress--
        } else {
            decayProgress = 0

            if (clickable) {
                failed = true
            }

            y += 3
            if (paint.alpha > 35) {
                paint.alpha -= 35
            } else {
                paint.alpha = 0
                clickable = false
            }
        }


        detectCollision.left = x
        detectCollision.top = y
        detectCollision.right = x + bitmap.width
        detectCollision.bottom = y + bitmap.height

    }
    fun draw(canvas: Canvas) {
        if (failed) { bitmap = failureBitmap }
        canvas.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
    }
}