package com.lolilicker.cvl.customviewlearning_kt

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.lolilicker.cvl.customviewlearning_kt.domain.Forecast
import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList

/**
 * Created by WangBo on 2018/9/18.
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: OnItemClickLisener) :
        RecyclerView.Adapter<ForecastListViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ForecastListViewHolder {
        return ForecastListViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_forecast,
                p0, false), itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(p0: ForecastListViewHolder, p1: Int) {
        p0.bindForecast(weekForecast[p1])
    }

    public interface OnItemClickLisener {
        operator fun invoke(forecast: Forecast)
    }
}