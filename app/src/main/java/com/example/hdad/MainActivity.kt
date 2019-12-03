package com.example.hdad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hdad.adapters.ParentAdapter
import com.example.hdad.model.ItemContainer
import com.example.hdad.model.ItemContent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {

        mainRV.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = ParentAdapter(getItems())
        }

    }

    fun getItems(): MutableList<ItemContainer> {
        return mutableListOf<ItemContainer>(
            ItemContainer(
                mutableListOf(
                    ItemContent("content"),
                    ItemContent("content"),
                    ItemContent("content")
                )
            )
        )
    }
}
