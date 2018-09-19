package com.lolilicker.cvl.customviewlearning_kt.domain

/**
 * Created by WangBo on 2018/9/18.
 */
data class ForecastList(val city:String,val country:String,val dailyForecast:List<Forecast>){
    operator fun get(position:Int):Forecast = dailyForecast.get(position)
    fun size():Int = dailyForecast.size
}