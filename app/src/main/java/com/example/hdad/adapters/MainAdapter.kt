package com.example.hdad.adapters

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainAdapter : ListDelegationAdapter<MutableList<Any>>() {
    init {
        delegatesManager.addDelegate(NestedRVComponent(mutableListOf()))
    }
}