package com.example.bouncyballwallview

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#3F51B5",
    "#006064",
    "#1A237E",
    "#DD2C00"
).map {
    Color.parseColor(it)
}.toTypedArray()
val parts : Int = 2
val scGap : Float = 0.02f
val rFactor : Float = 9.8f
val delay : Long = 20
val barFactor : Float = 2f
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBouncyBallWall(scale : Float, w : Float, h : Float, paint : Paint) {
    val r : Float = Math.min(w, h) / rFactor
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    save()
    translate(w / 2,h / 2)
    save()
    translate(-w / 2 + r + (w / 2 - r) * sf2, 0f)
    drawCircle(0f, 0f, r * sf1, paint)
    restore()
    drawRect(RectF(w / 2 - w * 0.5f * sf2, -h / 2, w / 2, h / 2), paint)
    restore()
}

fun Canvas.drawBBWNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    drawBouncyBallWall(scale, w, h, paint)
}
