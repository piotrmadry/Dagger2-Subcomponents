package com.example.piotr.subcomponentsexample.components

import com.example.piotr.subcomponentsexample.App
import com.example.piotr.subcomponentsexample.modules.ActivityBuildersModule
import com.example.piotr.subcomponentsexample.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = arrayOf(
                AppModule::class,
                AndroidSupportInjectionModule::class,
                ActivityBuildersModule::class
        ))
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}