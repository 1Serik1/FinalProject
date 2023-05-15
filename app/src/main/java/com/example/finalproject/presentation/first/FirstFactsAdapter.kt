package com.example.finalproject.presentation.first

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.data.local.FactsDataClass

class FirstFactsAdapter(
    private val listener: FirstFactsFragment
) : RecyclerView.Adapter<FirstFactsAdapter.ViewHolder>() {
    private val arrayOfFacts = ArrayList<FactsDataClass>()

    @SuppressLint("NotifyDataSetChanged")
    fun setListOfFacts(arrayListOfFacts: List<FactsDataClass>) {
        this.arrayOfFacts.clear()
        this.arrayOfFacts.addAll(arrayListOfFacts)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById(R.id.item_director)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val movie = arrayOfFacts[i]
        viewHolder.itemView.setOnClickListener {
            listener.onClick(arrayOfFacts.get(i))
        }
        Glide.with(viewHolder.itemView.context)
            .load(arrayOfFacts.get(i).URL).fitCenter().into(viewHolder.itemImage)
        viewHolder.itemDetail.text = movie.shortDescCard
        viewHolder.itemTitle.text = movie.numberOfFacts
    }

    override fun getItemCount(): Int {
        return arrayOfFacts.size
    }

    interface Listener {
        fun onClick(card: FactsDataClass)
    }

}