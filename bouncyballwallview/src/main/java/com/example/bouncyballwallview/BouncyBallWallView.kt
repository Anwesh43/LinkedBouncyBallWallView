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
