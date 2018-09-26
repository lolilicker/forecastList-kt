package com.lolilicker.cvl.customviewlearning_kt.model

/**
 * Created by WangBo on 2018/9/26.
 */
interface Command<T> {
    fun execute(): T
}