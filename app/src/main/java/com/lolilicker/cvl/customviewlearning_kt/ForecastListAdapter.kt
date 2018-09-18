package com.lolilicker.cvl.customviewlearning_kt

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lolilicker.cvl.customviewlearning_kt.domain.ForecastList

/**
 * Created by WangBo on 2018/9/18.
 */
class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(TextView(p0.context))
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        with(weekForecast.dailyForecast[p1]){
            (p0.view as TextView).text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}