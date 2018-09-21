package com.lolilicker.cvl.customviewlearning_kt

import android.app.Application

/**
 * Created by WangBo on 2018/9/21.
 */
class App: Application() {
    companion object {
        private var instance:Application? = null
        public fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}