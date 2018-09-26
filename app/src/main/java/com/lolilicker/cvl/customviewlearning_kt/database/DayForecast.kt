package com.lolilicker.cvl.customviewlearning_kt.database

/**
 * Created by WangBo on 2018/9/25.
 */
class DayForecast(var map: MutableMap<String, Any?>) {
    var date: String by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: String, description: String, high: Int, low: Int,
                iconUrl: String, cityId: Long)
            : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}