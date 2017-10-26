package com.example.piotr.subcomponentsexample.modules

import com.example.piotr.subcomponentsexample.views.main.MainActivity
import com.example.piotr.subcomponentsexample.views.user.UserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(BaseModule::class))
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(BaseModule::class, UserModule::class))
    abstract fun userActivity(): UserActivity
}