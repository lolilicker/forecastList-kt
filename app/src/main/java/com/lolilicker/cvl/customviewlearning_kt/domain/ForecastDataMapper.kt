package com.lolilicker.cvl.customviewlearning_kt.domain

import com.lolilicker.cvl.customviewlearning_kt.model.Forecast
import com.lolilicker.cvl.customviewlearning_kt.model.ForecastResult
import java.text.DateFormat
import java.util.*
import com.lolilicker.cvl.customviewlearning_kt.domain.Forecast as ModelForecast

/**
 * Created by WangBo on 2018/9/18.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast:ForecastResult):ForecastList{
        return ForecastList(forecast.city.name,forecast.city.country,convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list:List<Forecast>):List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}