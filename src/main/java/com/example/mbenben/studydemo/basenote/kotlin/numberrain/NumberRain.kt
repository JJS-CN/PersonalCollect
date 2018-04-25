package com.skateboard.numberrain

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.mbenben.studydemo.R

/**
 * 原GitHub地址：https://github.com/skateboard1991/NumberRain
 */
class NumberRain(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private var normalColor: Int = Color.GREEN

    private var hightLightColor: Int = Color.YELLOW

    private var textSize = 15 * resources.displayMetrics.density

    constructor(context: Context) : this(context, null)

    init {
        if (attrs != null) {
            parseAttrs(attrs)
        }
        initNormal()
    }

    private fun parseAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberRain)
        normalColor = typedArray.getColor(R.styleable.NumberRain_nr_normalColor, Color.GREEN)
        hightLightColor = typedArray.getColor(R.styleable.NumberRain_nr_highLightColor, Color.RED)
        textSize = typedArray.getDimension(R.styleable.NumberRain_nr_textSize, textSize)
        typedArray.recycle()
    }

    private fun initNormal() {
        orientation = HORIZONTAL
        setBackgroundColor(Color.BLACK)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        addRainItems()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    private fun addRainItems() {
        val count = measuredWidth / textSize.toInt()
        for (i in 0 until count) {
            val numberRainItem = NumberRainItem(context)
            numberRainItem.hightLightColor = hightLightColor
            numberRainItem.textSize = textSize
            numberRainItem.normalColor = normalColor
            val layoutParams = LayoutParams(textSize.toInt() + 10, measuredHeight)
            numberRainItem.startOffset = (Math.random() * 1000).toLong()
            addView(numberRainItem, layoutParams)
        }
    }
}