package com.example.piotr.subcomponentsexample.modules

import android.app.Application
import com.example.piotr.subcomponentsexample.App
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Application {
        return application
    }

    @Provides
    fun provideApplicationScoped(): ApplicationScoped {
        return ApplicationScoped()
    }
}