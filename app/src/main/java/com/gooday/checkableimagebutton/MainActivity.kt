package com.gooday.checkableimagebutton

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.gooday.cibLib.CheckableImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isLayout = intent.getBooleanExtra(IS_LAYOUT, false)

        if (isLayout) {
            setContentView(R.layout.activity_main)
            image.addOnClickListener(
                    View.OnClickListener {
                        Toast.makeText(this@MainActivity, "isChecked in layout: ${image.isChecked}", Toast.LENGTH_SHORT).show()
                    }
            )
        } else
            setContentView(createRoot())

    }

    private fun createRoot(): ViewGroup {
        val linearLayout = LinearLayout(this)

        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.gravity = Gravity.CENTER

        val checkableImageView = CheckableImageView(this)
        checkableImageView.resChecked = R.drawable.ic_star_active
        checkableImageView.resUnchecked = R.drawable.ic_star_not_active
        checkableImageView.isChecked = false

        checkableImageView.addOnClickListener(
                View.OnClickListener {
                    Toast.makeText(this@MainActivity, "isChecked: ${checkableImageView.isChecked}", Toast.LENGTH_SHORT).show()
                }
        )

        linearLayout.addView(checkableImageView)

        return linearLayout
    }

    companion object {
        const val IS_LAYOUT = "isLayout"
        fun newIntent(context: Context, isLayout: Boolean): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(IS_LAYOUT, isLayout)

            return intent
        }
    }
}
