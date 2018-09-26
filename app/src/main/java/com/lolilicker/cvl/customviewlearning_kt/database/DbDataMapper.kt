package com.lolilicker.cvl.customviewlearning_kt.database

import com.lolilicker.cvl.customviewlearning_kt.domain.Forecast
import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList

/**
 * Created by WangBo on 2018/9/26.
 */
class DbDataMapper {
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map {
            convertDayToDomain(it)
        }
        ForecastList(_id,city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }

    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) =
            with(forecast) {
                DayForecast(date, description, high, low, icon, cityId)
            }
}