package com.example.progressbar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btn.setOnClickListener{
            startActivity(Intent(this@Main5Activity, Main6Activity::class.java))
        }

        progressBarHorizontal.progress = 69

        var progressStatus = 0;

        val handler: Handler = Handler()

        Thread(Runnable {
            while (progressStatus < 89) {
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
