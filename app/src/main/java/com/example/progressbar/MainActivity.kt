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

    var isStartedBnext = false
    var isStartedBpre = false
    var progressStatus2 = 0
    var handLer: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn.setOnClickListener {
            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
        }
        //--------------------------------------------------------------------------------------//
        //--------------------------------------------------------------------------------------//
        var progressStatus = 0

        var progressDefault = 25

        val handler: Handler = Handler()

        bNext.setOnClickListener {

            Thread(Runnable {
                while (progressStatus < progressDefault) {
                    progressStatus += 1

                    try {
                        Thread.sleep(50)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    handler.post(Runnable {
                        progressBarHorizontal.progress = progressStatus
                    })
                }
            }).start()

            if (progressStatus == progressDefault){
                progressDefault += 25
                return@setOnClickListener
            }

        }

        bPre.setOnClickListener {

            Thread(Runnable {
                while (progressStatus > progressDefault) {
                    progressStatus -= 1

                    try {
                        Thread.sleep(50)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    handler.post(Runnable {
                        progressBarHorizontal.progress = progressStatus
                    })
                }
            }).start()

            if (progressStatus == progressDefault) {
                progressDefault -= 25
                return@setOnClickListener
            }
        }

        //--------------------------------------------------------------------------------------//
        //--------------------------------------------------------------------------------------//

        handLer = Handler(Handler.Callback {
            if (isStartedBnext) {
                progressStatus2++
            }
            if (progressStatus2 == 25) {
                isStartedBnext = false
            }
            if (progressStatus2 == 50) {
                isStartedBnext = false
            }
            if (progressStatus2 == 75) {
                isStartedBnext = false
            }
            if (progressStatus2 == 100) {
                isStartedBnext = false
            }
            progressBarHorizontal2.progress = progressStatus2
            handLer?.sendEmptyMessageDelayed(0, 80)

            true
        })
        handLer?.sendEmptyMessage(0)

    }


    fun bNEXT(view: View) {
        isStartedBnext = !isStartedBnext
    }
}
