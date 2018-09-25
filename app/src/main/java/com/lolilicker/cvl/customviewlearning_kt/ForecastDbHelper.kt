package com.lolilicker.cvl.customviewlearning_kt

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by WangBo on 2018/9/25.
 */
class ForecastDbHelper() : ManagedSQLiteOpenHelper(App.instance, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(CityForecastTable.NAME, true, CityForecastTable.ID to INTEGER + PRIMARY_KEY)
        db?.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(CityForecastTable.NAME, true)
        db?.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy {
            ForecastDbHelper()
        }
    }

    object CityForecastTable {
        val NAME = "CityForecast"
        val ID = "_id"
        val CITY = "city"
        val COUNTRY = "country"
    }

    object DayForecastTable {
        val NAME = "DayForecast"
        val ID = "_id"
        val DATE = "date"
        val DESCRIPTION = "description"
        val HIGH = "high"
        val LOW = "low"
        val ICON_URL = "iconUrl"
        val CITY_ID = "cityId"
    }
}