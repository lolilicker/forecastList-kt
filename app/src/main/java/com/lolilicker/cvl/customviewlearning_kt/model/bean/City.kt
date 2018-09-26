package com.lolilicker.cvl.customviewlearning_kt.model.bean

data class City(
        val id: Int,
        val name: String,
        val coord: Coordinates,
        val country: String,
        val population: Int
)