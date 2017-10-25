package com.example.piotr.subcomponentsexample.modules

import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {
//
//    @Provides
//    @ForActivity
//    fun provideContext(): Context {
//        return activity
//    }
//
//    @Provides
//    @ForActivity
//    fun privideActivity(): Activity {
//        return activity
//    }

    @Provides
    fun provideActivityScoped(): ActivityScoped {
        return ActivityScoped()
    }
}