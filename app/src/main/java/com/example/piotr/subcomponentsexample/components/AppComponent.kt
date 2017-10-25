package com.example.piotr.subcomponentsexample.components

import android.app.Application
import com.example.piotr.subcomponentsexample.App
import com.example.piotr.subcomponentsexample.modules.ActivityBuildersModule
import com.example.piotr.subcomponentsexample.modules.AppModule
import com.example.piotr.subcomponentsexample.modules.SubComponentModule
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@dagger.Component(modules = arrayOf(
        AppModule::class,
        SubComponentModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class
))
interface AppComponent {

    fun applicationScoped(): ApplicationScoped

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun appModule(module: AppModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}