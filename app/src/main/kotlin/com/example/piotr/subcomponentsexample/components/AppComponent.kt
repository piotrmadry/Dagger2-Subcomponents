package com.example.piotr.subcomponentsexample.components

import android.content.Context
import com.example.piotr.subcomponentsexample.App
import com.example.piotr.subcomponentsexample.dagger.ForApplication
import com.example.piotr.subcomponentsexample.modules.AppModule
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import dagger.MembersInjector
import javax.inject.Singleton

@Singleton
@dagger.Component(modules = arrayOf(AppModule::class))
interface AppComponent : MembersInjector<App> {
    @ForApplication
    fun context(): Context

    fun applicationScoped(): ApplicationScoped
}