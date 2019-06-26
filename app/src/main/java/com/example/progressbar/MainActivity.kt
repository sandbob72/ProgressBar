package com.example.progressbar

import android.app.Application
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.beardedhen.androidbootstrap.BootstrapProgressBar
import com.beardedhen.androidbootstrap.TypefaceProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar1.setProgress(75)
        progressBar2.setProgress(75)

    }
}
