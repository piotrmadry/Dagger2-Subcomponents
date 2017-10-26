package com.example.piotr.subcomponentsexample.modules

import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun scoped(): ActivityScoped {
        return ActivityScoped()
    }
}