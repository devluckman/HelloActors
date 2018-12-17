package com.man.helloactors.home

import com.man.helloactors.model.ActorsItem

interface HomeActivityView {
    fun showLoading()
    fun hideLoading()
    fun showActorList(data : List<ActorsItem>)
}