package com.example.progressbar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btn.setOnClickListener{
            startActivity(Intent(this@Main3Activity, Main4Activity::class.java))
        }

        progressBarHorizontal.progress = 25

        var progressStatus = 0;

        val handler: Handler = Handler()

        Thread(Runnable {
            while (progressStatus < 46) {
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
