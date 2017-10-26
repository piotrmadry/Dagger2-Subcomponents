package com.example.piotr.subcomponentsexample.modules

import android.content.Context
import com.example.piotr.subcomponentsexample.App
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import com.example.piotr.subcomponentsexample.views.base.BaseActivity
import com.example.piotr.subcomponentsexample.views.user.UserActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module(subcomponents = arrayOf(BaseActivity.BaseActivitySubComponent::class))
class AppModule {

    @Provides
    @Singleton
    @Named("Application Context")
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    fun provideApplicationScoped(): ApplicationScoped {
        return ApplicationScoped()
    }
}

@Module
class BaseModule {

    @Provides
    fun provideActivityScoped(): ActivityScoped {
        return ActivityScoped()
    }
}

@Module
class UserModule {
    @Provides
    @Named("Intent Name")
    fun provideString(activity: UserActivity): String {
        return activity.intent.getStringExtra(UserActivity.EXTRA_NAME)
    }

}
