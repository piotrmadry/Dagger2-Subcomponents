package com.example.piotr.subcomponentsexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject lateinit var applicationScoped: ApplicationScoped
//    @Inject lateinit var activityScoped: ActivityScoped
//    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        AndroidInjection.inject(this)

//
//        supportFragmentManager.beginTransaction()
//                .add(R.id.main_container, MainFragment.newInstance(), "TAG")
//                .addToBackStack(null)
//                .commit()
    }

    @Subcomponent
    interface MainActivitySubComponent : AndroidInjector<MainActivity> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<MainActivity>()
    }
}
