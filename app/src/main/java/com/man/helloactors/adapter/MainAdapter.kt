package com.man.helloactors.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.man.helloactors.R
import com.man.helloactors.model.ActorsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemlist.view.*

class MainAdapter(val actors : List<ActorsItem>,
                  private val clicklistener : (ActorsItem) -> Unit)
    : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.itemlist, parent, false))
    }

    override fun getItemCount(): Int = actors.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(actors[position], clicklistener)
    }

    inner class MyViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        fun bind(actorsItem: ActorsItem, clicklistener: (ActorsItem) -> Unit){
            itemView.txtName.text = actorsItem.name
            itemView.txtDob.text = actorsItem.dob
            Picasso.get().load(actorsItem.image)
                    .into(itemView.imgActor)
            itemView.setOnClickListener {
                clicklistener(actorsItem)
            }
        }

    }
}