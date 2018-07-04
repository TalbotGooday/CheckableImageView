package com.gooday.checkableimagebutton

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createRoot())
    }

    private fun createRoot(): ViewGroup {
        val linearLayout = LinearLayout(this)
        val layoutButton = Button(this)
        layoutButton.setText(R.string.in_layout)
        layoutButton.setOnClickListener {
            startActivity(MainActivity.newIntent(this@IntroActivity, true))
        }

        val codeButton = Button(this)
        codeButton.setText(R.string.in_code)
        codeButton.setOnClickListener {
            startActivity(MainActivity.newIntent(this@IntroActivity, false))
        }
        val largeImageButton = Button(this)
        largeImageButton.setText(R.string.large_image)
        largeImageButton.setOnClickListener {
            startActivity(LargeImageActivity.newIntent(this@IntroActivity))
        }

        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.gravity = Gravity.CENTER
        linearLayout.addView(layoutButton)
        linearLayout.addView(codeButton)
        linearLayout.addView(largeImageButton)

        return linearLayout
    }
}
