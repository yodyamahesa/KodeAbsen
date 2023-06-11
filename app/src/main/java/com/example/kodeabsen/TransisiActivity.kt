package com.example.kodeabsen

import android.app.Activity
import android.content.Intent

object TransisiActivity {

    fun transisiKeBawah_Finish(activity: Activity, intent: Intent){
        activity.startActivity(intent)
        activity.finish()
        activity.overridePendingTransition(R.anim.stay,R.anim.slide_out_bottom);
    }

    fun transisiKeAtas_Finish(activity: Activity, intent: Intent){
        activity.startActivity(intent)
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_in_top, R.anim.stay);
    }

    fun transisiKeKanan_Finish(activity: Activity, intent: Intent){
        activity.startActivity(intent)
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    fun transisiKeKiri_Finish(activity: Activity, intent: Intent){
        activity.startActivity(intent)
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    fun transisiKosong_Finish(activity: Activity,intent: Intent){
        activity.startActivity(intent)
        activity.finish()
        activity.overridePendingTransition(0,0);
    }

}