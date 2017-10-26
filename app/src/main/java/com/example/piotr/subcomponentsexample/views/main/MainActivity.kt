package com.example.piotr.subcomponentsexample.views.main

import android.os.Bundle
import android.widget.Button
import com.example.piotr.subcomponentsexample.R
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import com.example.piotr.subcomponentsexample.views.base.BaseActivity
import com.example.piotr.subcomponentsexample.views.user.UserActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var applicationScoped: ApplicationScoped
    @Inject lateinit var activityScoped: ActivityScoped

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        applicationScoped.run()
        activityScoped.run()

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(UserActivity.newIntent(this, "Dagger"))
        }
    }
}