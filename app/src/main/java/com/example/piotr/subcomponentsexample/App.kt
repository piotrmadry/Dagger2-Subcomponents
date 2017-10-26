package com.example.piotr.subcomponentsexample

import android.app.Activity
import android.app.Application
import com.example.piotr.subcomponentsexample.components.AppComponent
import com.example.piotr.subcomponentsexample.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : HasActivityInjector, Application() {

    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

    override fun onCreate() {
        super.onCreate()
        initializeAppComponent().inject(this)
    }

    private fun initializeAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}