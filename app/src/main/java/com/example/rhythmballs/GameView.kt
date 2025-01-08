package com.example.rhythmballs

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.navigation.NavController

class GameView : SurfaceView, Runnable {

    var playing = false
    var gameThread : Thread? = null
    var musicThread: Thread? = null

    var frameCounter : Int = 0

    lateinit var surfaceHolder: SurfaceHolder
    lateinit var canvas : Canvas
    lateinit var mediaPlayer: MediaPlayer

    lateinit var song : List<SongNote>
    var rhythmBalls = arrayListOf<Ball>()
    var points = 0

    lateinit var gameContext : Context

    var onGameOver : () -> Unit = {}

    private fun init(context: Context, width: Int, height: Int) {
        surfaceHolder = holder

        gameContext = context

        song = WriteSong()

        mediaPlayer = MediaPlayer.create(context, R.raw.zelda_gaming)

        mediaPlayer.start()
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

        rhythmBalls.forEach {
            it.update()
        }

        song.forEach {
            if (it.timestamp == frameCounter) {

                rhythmBalls.add(Ball(gameContext, it.x?:0, it.y?:0, it.decaySpeed?:0))
                Log.d("game", "Created ball at: x = " + it.x + " y = " + it.y)
                if (it.timestamp == secondsToFrames(10f)) {
                    mediaPlayer.stop()
                    mediaPlayer.release()
                }
            }
        }

        frameCounter++

    }

    fun draw() {
        if (surfaceHolder.surface.isValid) {
            canvas = surfaceHolder.lockCanvas()

            canvas.drawColor(Color.BLACK)

            rhythmBalls.forEach {
                it.draw(canvas)
            }
            rhythmBalls.forEach {
                it.draw(canvas)
            }

            surfaceHolder.unlockCanvasAndPost(canvas)
        }
    }

    var callGameOverOnce = false
    fun frames() {
        Thread.sleep(17)
        /*if (frameCounter == secondsToFrames(10f)) {
            playing = false
            Handler(Looper.getMainLooper()).post {
                if (!callGameOverOnce) {
                    onGameOver()
                    callGameOverOnce = true
                }
                gameThread?.join()
            }
        }*/
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        var touchX = event!!.x.toInt();
        var touchY = event.y.toInt();

        var touchR = Rect(touchX, touchY, touchX, touchY)

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                rhythmBalls.forEach {
                    if (Rect.intersects(it.detectCollision, touchR) and !it.failed) {
                        it.click()
                        points++
                    }
                }
            }
        }

        return true
    }
}