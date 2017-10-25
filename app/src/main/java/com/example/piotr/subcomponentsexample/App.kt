package com.example.piotr.subcomponentsexample

import android.app.Activity
import android.app.Application
import com.example.piotr.subcomponentsexample.components.AppComponent
import com.example.piotr.subcomponentsexample.components.DaggerAppComponent
import com.example.piotr.subcomponentsexample.modules.AppModule
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : HasActivityInjector, Application() {

    @Inject lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

    @Inject lateinit var applicationScoped: ApplicationScoped

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initializeAppComponent()
        appComponent.inject(this)
    }

    private fun initializeAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule())
                .build()
    }
}