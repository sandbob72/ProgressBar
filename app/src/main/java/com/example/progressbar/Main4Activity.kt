package com.example.progressbar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btn.setOnClickListener{
            startActivity(Intent(this@Main4Activity, Main5Activity::class.java))
        }

        progressBarHorizontal.progress = 46

        var progressStatus = 46

        val handler: Handler = Handler()

        Thread(Runnable {
            while (progressStatus < 69) {
                progressStatus += 1

                try {
                    Thread.sleep(80)
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
