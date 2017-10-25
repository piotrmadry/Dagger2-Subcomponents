package com.example.piotr.subcomponentsexample.modules

import android.app.Activity
import com.example.piotr.subcomponentsexample.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class ActivityBuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindMainActivityInjectorFactory(builder: MainActivity.MainActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}
