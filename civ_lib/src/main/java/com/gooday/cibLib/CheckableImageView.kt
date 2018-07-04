package com.gooday.cibLib

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable


class CheckableImageView : android.support.v7.widget.AppCompatImageView, Checkable, View.OnClickListener {
    private var onClickListeners: ArrayList<OnClickListener> = ArrayList()

    var resChecked = android.R.drawable.checkbox_on_background
    var resUnchecked = android.R.drawable.checkbox_off_background

    private var mChecked = false
        set(value) {
            field = value

            if (value) {
                if (resChecked != 0)
                    setImageResource(resChecked)
            } else {
                if (resUnchecked != 0)
                    setImageResource(resUnchecked)
            }
        }

    constructor(context: Context) : this(context, null) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        setOnClickListener(this)

        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CheckableImageView)
            resChecked = a.getResourceId(R.styleable.CheckableImageView_checked_image, android.R.drawable.checkbox_on_background)
            resUnchecked = a.getResourceId(R.styleable.CheckableImageView_unchecked_image, android.R.drawable.checkbox_off_background)
            mChecked = a.getBoolean(R.styleable.CheckableImageView_item_checked, false)
            a.recycle()
        }

        setImageResource(resUnchecked)
    }

    override fun onClick(v: View?) {
        toggle()

        onClickListeners.forEach { listener -> listener.onClick(v) }
    }

    override fun setChecked(checked: Boolean) {
        mChecked = checked
    }

    override fun isChecked(): Boolean {
        return mChecked
    }

    override fun toggle() {
        mChecked = !mChecked
    }

    fun addOnClickListener(listener: OnClickListener) {
        if (listener != this)
            onClickListeners.add(listener)
    }
}
