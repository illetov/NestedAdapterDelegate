package com.example.hdad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hdad.R
import com.example.hdad.model.ItemContent
import kotlinx.android.synthetic.main.item_content_template.view.*

class ChildAdapter(private val children: List<ItemContent>) :
    RecyclerView.Adapter<ChildAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_template, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = children.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val child = children[position]
        holder.textView.text = child.data
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = itemView.textView
    }
}