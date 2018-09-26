package com.lolilicker.cvl.customviewlearning_kt.database

import android.database.sqlite.SQLiteDatabase
import com.lolilicker.cvl.customviewlearning_kt.model.ForecastDataSource
import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by WangBo on 2018/9/26.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()): ForecastDataSource {
    fun <T : Any> SelectQueryBuilder.parseList(
            parser: (Map<String, Any?>) -> T): List<T> =
            parseList(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
            })

    public fun <T : Any> SelectQueryBuilder.parseOpt(
            parser: (Map<String, Any?>) -> T): T? =
            parseOpt(object : MapRowParser<T> {
                override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
            })

    fun SQLiteDatabase.clear(tableName: String) {
        execSQL("delete from $tableName")
    }

    override fun requestForecastByZipCode(zipCode:String, date:Long) = forecastDbHelper.use {
        val dailyRequest = "${ForecastDbHelper.DayForecastTable.CITY_ID} = ? " +
                "AND ${ForecastDbHelper.DayForecastTable.DATE} >= ?"
        val dailyForecast = select(ForecastDbHelper.DayForecastTable.NAME)
                .whereSimple(dailyRequest,zipCode,date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(ForecastDbHelper.CityForecastTable.NAME)
                .whereSimple("${ForecastDbHelper.CityForecastTable.ID} = ?", zipCode)
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {
        clear(ForecastDbHelper.CityForecastTable.NAME)
        clear(ForecastDbHelper.DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(ForecastDbHelper.CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach {
                insert(ForecastDbHelper.DayForecastTable.NAME, *it.map.toVarargArray())
            }
        }
    }

    fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
            Array<out Pair<K, V>> =  map({ Pair(it.key, it.value!!) }).toTypedArray()
}