package com.example.piotr.subcomponentsexample.modules

import com.example.piotr.subcomponentsexample.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class))
    abstract fun mainActivity(): MainActivity
}
