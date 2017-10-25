package com.example.piotr.subcomponentsexample

import android.app.Application
import com.example.piotr.subcomponentsexample.components.AppComponent
import com.example.piotr.subcomponentsexample.components.DaggerAppComponent
import com.example.piotr.subcomponentsexample.modules.AppModule
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import javax.inject.Inject

class App : Application() {

    @Inject lateinit var applicationScoped: ApplicationScoped

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initializeAppComponent()
        appComponent.injectMembers(this)
    }

    private fun initializeAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}