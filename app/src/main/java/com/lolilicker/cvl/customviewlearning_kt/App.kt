package com.lolilicker.cvl.customviewlearning_kt

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by WangBo on 2018/9/21.
 */
class App: Application() {
    companion object {
        var instance by Delegates.notNull<Application>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}