package com.example.myapplication.viewtest

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView: AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d("yanshuang", "onLayout $index")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("yanshuang", "onDraw $index")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("yanshuang", "onMeasure $index")
    }

    var index: Int = -1;
}