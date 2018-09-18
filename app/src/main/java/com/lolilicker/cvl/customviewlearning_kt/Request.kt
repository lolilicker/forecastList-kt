package com.lolilicker.cvl.customviewlearning_kt

import com.google.gson.Gson
import com.lolilicker.cvl.customviewlearning_kt.model.ForecastResult
import java.net.URL

/**
 * Created by WangBo on 2018/9/18.
 */
class Request(val zipcode:String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute():ForecastResult{
        val forecastJsonStr = URL(COMPLETE_URL+zipcode).readText()
        return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)
    }
}