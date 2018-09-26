package com.lolilicker.cvl.customviewlearning_kt.model

import com.lolilicker.cvl.customviewlearning_kt.database.ForecastDb
import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList
import com.lolilicker.cvl.customviewlearning_kt.model.server.ForecastServer

/**
 * Created by WangBo on 2018/9/26.
 */
class ForecastProvider(val sources:List<ForecastDataSource> = SOURCE) {
    companion object {
        val DAY_IN_MILLIS = 1000*60*60*24
        val SOURCE = listOf(ForecastDb(),ForecastServer())
    }

    fun requestByZipCode(zipCode: String, days: Int): ForecastList
            = sources.firstResult { requestSource(it, days, zipCode) }

    inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?) : R {
        for (element in this){
            val result = predicate(element)
            if (result != null) return result
        }
        throw NoSuchElementException("No element matching predicate was found.")
    }

    fun requestSource(source: ForecastDataSource, days: Int, zipCode: String):
            ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}