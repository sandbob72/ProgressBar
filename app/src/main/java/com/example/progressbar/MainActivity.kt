package com.example.progressbar

import android.app.Application
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import com.beardedhen.androidbootstrap.BootstrapProgressBar
import com.beardedhen.androidbootstrap.TypefaceProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var progressStatus = 0
    var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener {
            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
        }


        progressBarHorizontal.progress = 0

    }
}
