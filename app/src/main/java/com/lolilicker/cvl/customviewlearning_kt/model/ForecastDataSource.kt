package com.lolilicker.cvl.customviewlearning_kt.model

import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList

/**
 * Created by WangBo on 2018/9/26.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode:String, date:Long):ForecastList?
}