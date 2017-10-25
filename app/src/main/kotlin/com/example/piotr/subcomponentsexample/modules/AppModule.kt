package com.example.piotr.subcomponentsexample.modules

import android.content.Context
import com.example.piotr.subcomponentsexample.App
import com.example.piotr.subcomponentsexample.dagger.ForApplication
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    @ForApplication
    fun provideContext(): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideApplicationScoped(): ApplicationScoped {
        return ApplicationScoped()
    }
}