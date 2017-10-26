package com.example.piotr.subcomponentsexample.components

import com.example.piotr.subcomponentsexample.App
import com.example.piotr.subcomponentsexample.modules.ActivityBuildersModule
import com.example.piotr.subcomponentsexample.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@dagger.Component(
        modules = arrayOf(
                AppModule::class,
                AndroidSupportInjectionModule::class,
                ActivityBuildersModule::class
        ))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}