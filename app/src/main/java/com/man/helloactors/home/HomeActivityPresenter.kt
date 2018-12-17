package com.man.helloactors.home

import com.google.gson.Gson
import com.man.helloactors.model.ResponseActors
import com.man.helloactors.network.ActorsRest
import com.man.helloactors.network.ApiRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class HomeActivityPresenter (private val view: HomeActivityView,
                             private val apiRepository: ApiRepository,
                             private val gson: Gson) {
    fun getActorList(){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(ActorsRest.getActors()),
                    ResponseActors::class.java)
            uiThread {
                view.hideLoading()
                view.showActorList(data.actors)
            }
        }
    }

}