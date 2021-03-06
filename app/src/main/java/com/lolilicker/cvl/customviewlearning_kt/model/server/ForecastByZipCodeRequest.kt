package com.lolilicker.cvl.customviewlearning_kt.model.server

import android.util.Log
import com.google.gson.Gson
import com.lolilicker.cvl.customviewlearning_kt.model.bean.ForecastResult

/**
 * Created by WangBo on 2018/9/26.
 */
class ForecastByZipCodeRequest(val zipCode:String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        Log.d("request",forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}