package com.lolilicker.cvl.customviewlearning_kt

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by WangBo on 2018/9/18.
 */
class ForecastListAdapter(val items:List<String>): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(TextView(p0.context))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        (p0.view as TextView).text = items[p1]
    }

    class ViewHolder(val view:View): RecyclerView.ViewHolder(view)
}