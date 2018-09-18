package com.lolilicker.cvl.customviewlearning_kt

import android.util.Log
import java.net.URL

/**
 * Created by WangBo on 2018/9/18.
 */
class Request(val url:String) {
    public fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }
}