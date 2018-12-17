package com.man.helloactors.network

import com.man.helloactors.BuildConfig

object ActorsRest {
    fun getActors(): String {
        return BuildConfig.BASE_URL
    }
}