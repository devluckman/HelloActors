package com.man.helloactors.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.man.helloactors.R
import com.man.helloactors.model.ActorsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var data : ActorsItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        data = intent.getParcelableExtra("key")
        loadData(data)
    }

    private fun loadData(actorsItem: ActorsItem){
        Picasso.get().load(actorsItem.image)
                .into(imgActor_detail)
        txtName_detail.text = actorsItem.name
        txtDob_detail.text = actorsItem.dob
        txtDesc_detail.text = actorsItem.description
    }
}