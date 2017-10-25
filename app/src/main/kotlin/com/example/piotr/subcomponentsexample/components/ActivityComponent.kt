package com.example.piotr.subcomponentsexample.components

import android.app.Activity
import com.example.piotr.subcomponentsexample.MainActivity
import com.example.piotr.subcomponentsexample.dagger.ActivityScope
import com.example.piotr.subcomponentsexample.dagger.ForActivity
import com.example.piotr.subcomponentsexample.modules.ActivityModule
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import dagger.MembersInjector

@ActivityScope
@dagger.Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent : MembersInjector<MainActivity> {

    @ForActivity
    fun activity(): Activity

    fun activityScoped(): ActivityScoped

    fun plus(): FragmentSubComponent
}