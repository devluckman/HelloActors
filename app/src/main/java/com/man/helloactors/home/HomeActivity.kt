package com.man.helloactors.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import com.man.helloactors.R
import com.man.helloactors.adapter.MainAdapter
import com.man.helloactors.detail.DetailActivity
import com.man.helloactors.model.ActorsItem
import com.man.helloactors.network.ApiRepository
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity(), HomeActivityView {

    private lateinit var presenter: HomeActivityPresenter
    private lateinit var adapter: MainAdapter


    private var actors : MutableList<ActorsItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        rvListActors.layoutManager = LinearLayoutManager(this)
        setupIn()
    }

    private fun setupIn(){
        presenter = HomeActivityPresenter(this, ApiRepository(), Gson())
        adapter = MainAdapter(actors){
            startActivity<DetailActivity>("key" to it)
        }
        presenter.getActorList()
        rvListActors.adapter = adapter
    }

    override fun showLoading() {
        progressbar.visibility = View.VISIBLE
        rvListActors.visibility = View.GONE
    }

    override fun hideLoading() {
        progressbar.visibility = View.GONE
        rvListActors.visibility = View.VISIBLE
    }

    override fun showActorList(data: List<ActorsItem>) {
        actors.addAll(data)
        adapter.notifyDataSetChanged()
        rvListActors.scrollToPosition(0)
    }
}
