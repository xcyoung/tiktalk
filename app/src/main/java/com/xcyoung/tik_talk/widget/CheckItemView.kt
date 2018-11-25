package com.xcyoung.tik_talk.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.core.graphics.drawable.DrawableCompat
import com.xcyoung.tik_talk.R
import kotlinx.android.synthetic.main.layout_check_item.view.*


class CheckItemView: RelativeLayout {
    private var iconDrawable :Drawable? = null
    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context,attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        if(context == null && attrs == null) return
        LayoutInflater.from(context).inflate(R.layout.layout_check_item, this, true)
        val ta = context!!.obtainStyledAttributes(attrs, R.styleable.CheckItemView)
        text.text = ta.getString(R.styleable.CheckItemView_text)
        iconDrawable = ta.getDrawable(R.styleable.CheckItemView_icon)
        ta.recycle()
    }

    fun setItem(iconTint:ColorStateList?) {
        if (iconDrawable != null) {
            val state = iconDrawable!!.constantState
            iconDrawable = DrawableCompat.wrap(if (state == null) iconDrawable!! else state.newDrawable()).mutate()
            DrawableCompat.setTintList(iconDrawable!!, iconTint)
        }
        this.icon.setImageDrawable(iconDrawable)
        this.text.setTextColor(iconTint)
    }
}