package com.gooday.checkableimagebutton

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class LargeImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_large_image)

        image.addOnClickListener(
                View.OnClickListener {
                    Toast.makeText(this@LargeImageActivity, "isChecked large image: ${image.isChecked}", Toast.LENGTH_SHORT).show()
                }
        )
    }

    companion object {
        fun newIntent(context: Context): Intent {

            return Intent(context, LargeImageActivity::class.java)
        }
    }
}
