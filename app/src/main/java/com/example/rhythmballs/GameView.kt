package com.example.rhythmballs

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView : SurfaceView, Runnable {

    var playing = false
    var gameThread : Thread? = null

    lateinit var surfaceHolder: SurfaceHolder
    lateinit var canvas : Canvas

    lateinit var ball : Ball

    lateinit var paint: Paint

    private fun init(context: Context, width: Int, height: Int) {
        surfaceHolder = holder
        paint = Paint()

        ball = Ball(context, width, height)
    }

    constructor(context: Context?, width: Int, height: Int) : super(context) {
        init(context!!, width, height)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init(context!!, 0, 0)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        init(context!!, 0, 0)
    }

    fun resume() {
        playing = true
        gameThread = Thread(this)
        gameThread?.start()
    }

    override fun run() {
        while (playing) {
            update()
            draw()
            frames()
        }
    }

    fun update() {
        ball.update()
    }

    fun draw() {
        if (surfaceHolder.surface.isValid) {
            canvas = surfaceHolder.lockCanvas()

            canvas.drawColor(Color.BLACK)

            ball.draw(canvas)

            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }

    fun frames() {
        Thread.sleep(17)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        var touchX = event?.getX()!!.toInt();
        var touchY = event?.getY()!!.toInt();

        var touchR = Rect(touchX, touchY, touchX, touchY)

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                if (Rect.intersects(ball.detectCollision, touchR)) {
                    ball.click()
                }
            }
        }

        return true
    }
}