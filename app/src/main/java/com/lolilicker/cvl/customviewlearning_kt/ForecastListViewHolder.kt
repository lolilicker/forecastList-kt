package com.lolilicker.cvl.customviewlearning_kt

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.lolilicker.cvl.customviewlearning_kt.domain.Forecast
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListViewHolder(val view: View,val itemClick:ForecastListAdapter.OnItemClickLisener) :
        RecyclerView.ViewHolder(view){


    init{

    }

    fun bindForecast(forecast:Forecast){
        with(forecast){
            Picasso.get().load(icon).into(itemView.icon)
            itemView.date.text = date
            itemView.description.text = description
            itemView.maxTemperature.text = "$high"
            itemView.minTemperature.text = "$low"
            itemView.setOnClickListener({ itemClick(forecast) })
        }
    }

}