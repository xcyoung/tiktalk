package com.xcyoung.tik_talk.widget

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.xcyoung.tik_talk.R

class CheckMenuView : ConstraintLayout {
    private var curPosition : Int = -1
    private var onItemSelectedListener :OnItemSelectedListener? = null
    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context,attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        if(context == null && attrs == null) return
        LayoutInflater.from(context).inflate(R.layout.layout_check_menu, this, true)
        val ta = context!!.obtainStyledAttributes(attrs, R.styleable.CheckMenuView)
        //背景色drawble
        val backgroudColors = ta.getColorStateList(R.styleable.CheckMenuView_item_colors)
        createCheckItem(backgroudColors)
        ta.recycle()
    }

    private fun createCheckItem(backgroudColors:ColorStateList?){
        if(backgroudColors == null) return
        for (i in 0..childCount){
            val child = getChildAt(i)
            if(child is CheckItemView) {
                child.setItem(backgroudColors)
                if(i == 0){
                    child.isSelected = true
                    curPosition = i
                }
                child.setOnClickListener {
                    if(curPosition == i) return@setOnClickListener
                    if(curPosition != -1) getChildAt(curPosition).isSelected = false
                    it.isSelected = true
                    curPosition = i
                    onItemSelectedListener?.onItemSelected(i,it as CheckItemView)
                }
            }
        }
    }

    fun setOnItemSelectedListener(listener: OnItemSelectedListener){
        this.onItemSelectedListener = listener
    }

    interface OnItemSelectedListener{
        fun onItemSelected(position:Int,item:CheckItemView)
    }
}