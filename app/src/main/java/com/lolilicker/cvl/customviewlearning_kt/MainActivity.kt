package com.lolilicker.cvl.customviewlearning_kt

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.lolilicker.cvl.customviewlearning_kt.domain.Forecast
import com.lolilicker.cvl.customviewlearning_kt.model.RequestForecastCommand
import com.lolilicker.cvl.customviewlearning_kt.model.server.ServerDataMapper
import com.lolilicker.cvl.customviewlearning_kt.model.server.ForecastServer
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val API = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7&APPID=15646a06818f61f7b8d7823ca833e1ce&q=BeiJing";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result =  RequestForecastCommand("BeiJing").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result,
                       object :ForecastListAdapter.OnItemClickLisener{
                           override fun invoke(forecast: Forecast) {
                               toast(forecast.date)
                           }
                       })
            }
        }
    }
}
