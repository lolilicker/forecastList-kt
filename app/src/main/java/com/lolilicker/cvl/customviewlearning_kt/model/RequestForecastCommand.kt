package com.lolilicker.cvl.customviewlearning_kt.model

import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList

/**
 * Created by WangBo on 2018/9/26.
 */
class RequestForecastCommand(val zipCode: String,
                             val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}