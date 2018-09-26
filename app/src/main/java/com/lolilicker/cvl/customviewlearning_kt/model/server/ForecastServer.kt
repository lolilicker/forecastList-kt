package com.lolilicker.cvl.customviewlearning_kt.model.server

import com.lolilicker.cvl.customviewlearning_kt.model.ForecastDataSource
import com.lolilicker.cvl.customviewlearning_kt.database.ForecastDb
import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList

/**
 * Created by WangBo on 2018/9/18.
 */
class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()): ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: String, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertFromDataModel(result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode,date)
    }
}