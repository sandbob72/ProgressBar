package com.example.progressbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class Main6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        progressBarHorizontal.progress = 89

        var progressStatus = 0;

        val handler: Handler = Handler()

        Thread(Runnable {
            while (progressStatus < 100) {
                progressStatus += 1

                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                handler.post(Runnable {
                    progressBarHorizontal.progress = progressStatus

                })
            }
        }).start()
    }
}
