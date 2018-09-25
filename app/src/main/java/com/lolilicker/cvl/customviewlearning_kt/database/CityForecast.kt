package com.lolilicker.cvl.customviewlearning_kt.database

import com.lolilicker.cvl.customviewlearning_kt.domain.Forecast

/**
 * Created by WangBo on 2018/9/25.
 */
class CityForecast(val map: Map<String, Any?>, val dailyForecast: List<DayForecast>) {
    var _id by map
    var city by map
    var country by map

    constructor(_id: Long, city: String, country: String, dailyForecast: List<DayForecast>) :
            this(HashMap(), dailyForecast) {
        this._id = _id
        this.city = city
        this.country = country
    }
}