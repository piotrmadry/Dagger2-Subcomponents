package com.example.piotr.subcomponentsexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.piotr.subcomponentsexample.components.ActivityComponent
import com.example.piotr.subcomponentsexample.components.DaggerActivityComponent
import com.example.piotr.subcomponentsexample.modules.ActivityModule
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var activityScoped: ActivityScoped
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((this.application as App).appComponent)
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.injectMembers(this)

        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, MainFragment.newInstance(), "TAG")
                .addToBackStack(null)
                .commit()
    }
}
