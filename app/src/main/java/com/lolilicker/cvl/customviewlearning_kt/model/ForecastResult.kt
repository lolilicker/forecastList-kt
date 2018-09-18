package com.lolilicker.cvl.customviewlearning_kt.model

data class ForecastResult(
        val city: City,
        val cod: String,
        val message: Double,
        val cnt: Int,
        val list: List<Forecast>
)