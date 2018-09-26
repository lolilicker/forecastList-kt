package com.lolilicker.cvl.customviewlearning_kt.database

import android.database.sqlite.SQLiteDatabase
import com.lolilicker.cvl.customviewlearning_kt.App
import org.jetbrains.anko.db.*

/**
 * Created by WangBo on 2018/9/25.
 */
class ForecastDbHelper() : ManagedSQLiteOpenHelper(App.instance, DB_NAME, null, DB_VERSION) {
    companion object {
        const val DB_NAME = "forecast.db"
        const val DB_VERSION = 3
        val instance by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }

    object CityForecastTable {
        const val NAME = "CityForecast"
        const val ID = "_id"
        const val CITY = "city"
        const val COUNTRY = "country"
    }

    object DayForecastTable {
        const val NAME = "DayForecast"
        const val ID = "_id"
        const val DATE = "date"
        const val DESCRIPTION = "description"
        const val HIGH = "high"
        const val LOW = "low"
        const val ICON_URL = "iconUrl"
        const val CITY_ID = "cityId"
    }
}