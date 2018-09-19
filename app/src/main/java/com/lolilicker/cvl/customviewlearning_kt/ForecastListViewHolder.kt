package com.lolilicker.cvl.customviewlearning_kt

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.lolilicker.cvl.customviewlearning_kt.domain.Forecast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class ForecastListViewHolder(val view: View,val itemClick:ForecastListAdapter.OnItemClickLisener) :
        RecyclerView.ViewHolder(view){
    private val iconView: ImageView
    private val dateView: TextView
    private val descriptionView: TextView
    private val maxTemperatureView: TextView
    private val minTemperatureView: TextView

    init{
        iconView = view.find(R.id.icon)
        dateView = view.find(R.id.date)
        descriptionView = view.find(R.id.description)
        maxTemperatureView = view.find(R.id.maxTemperature)
        minTemperatureView = view.find(R.id.minTemperature)
    }

    fun bindForecast(forecast:Forecast){
        with(forecast){
            Picasso.get().load(icon).into(iconView)
            dateView.text = date
            descriptionView.text = description
            maxTemperatureView.text = "$high"
            minTemperatureView.text = "$low"
            itemView.setOnClickListener({ itemClick(forecast) })
        }
    }

}