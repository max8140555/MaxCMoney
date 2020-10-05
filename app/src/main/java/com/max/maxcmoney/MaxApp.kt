package com.max.maxcmoney

import android.app.Application
import com.max.maxcmoney.network.VolleyService


class MaxApp : Application() {
    override fun onCreate() {
        super.onCreate()
        VolleyService.initialize(this)
    }
}