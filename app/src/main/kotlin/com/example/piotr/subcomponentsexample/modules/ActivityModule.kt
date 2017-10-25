package com.example.piotr.subcomponentsexample.modules

import android.app.Activity
import android.content.Context
import com.example.piotr.subcomponentsexample.dagger.ForActivity
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ForActivity
    fun provideContext(): Context {
        return activity
    }

    @Provides
    @ForActivity
    fun privideActivity(): Activity {
        return activity
    }

    @Provides
    fun provideActivityScoped(): ActivityScoped {
        return ActivityScoped()
    }
}