package com.lolilicker.cvl.customviewlearning_kt.model

data class Forecast(
        val dt: Long,
        val temp: Temperature,
        val pressure: Double,
        val humidity: Int,
        val weather: List<Weather>,
        val speed: Double,
        val deg: Int,
        val clouds: Int
)