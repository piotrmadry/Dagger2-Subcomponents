package com.example.piotr.subcomponentsexample.views.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.piotr.subcomponentsexample.R
import dagger.Subcomponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }

    @Subcomponent
    interface BaseActivitySubComponent : AndroidInjector<BaseActivity> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<BaseActivity>()
    }
}
