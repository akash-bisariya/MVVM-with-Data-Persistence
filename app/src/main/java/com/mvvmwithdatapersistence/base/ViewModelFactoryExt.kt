package com.mvvmwithdatapersistence.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

inline fun <reified T:ViewModel> AppCompatActivity.getViewModel(noinline creator: (() -> T)? = null) : T{

    return if(creator == null){
        ViewModelProviders.of(this).get(T::class.java)
    }
    else{
        ViewModelProviders.of(this, BaseViewModelFactory(creator)).get(T::class.java)
    }
}

