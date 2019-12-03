package com.example.hdad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hdad.R
import com.example.hdad.model.ItemContainer
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import kotlinx.android.synthetic.main.item_content_layout.view.*

class ParentAdapter(private val parents: MutableList<ItemContainer>) :
    RecyclerView.Adapter<ParentAdapter.VH>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_content_layout, parent, false)
        return VH(v)
    }

    override fun getItemCount(): Int = parents.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val parent = parents[position]
        val childLayoutManager =
            GridLayoutManager(holder.recyclerView.context, 2, LinearLayout.HORIZONTAL, false)
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(parent.child)
            setRecycledViewPool(viewPool)
        }
    }

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = itemView.rv_child
    }
}

/**/
class NestedRVComponent(private val parents: MutableList<ItemContainer>) :
    AdapterDelegate<MutableList<Any>>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_content_layout, parent, false))
    }

    override fun isForViewType(items: MutableList<Any>, position: Int): Boolean {
        return items[position] is ItemContainer
    }

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val parent = parents[position]
        val childLayoutManager = GridLayoutManager(
            (holder as ViewHolder).recyclerView.context,
            2,
            RecyclerView.HORIZONTAL,
            false
        )

        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(parent.child)
            setRecycledViewPool(viewPool)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = itemView.rv_child
    }
}
/**/