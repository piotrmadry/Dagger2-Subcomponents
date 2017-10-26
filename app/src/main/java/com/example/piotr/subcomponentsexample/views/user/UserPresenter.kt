package com.example.piotr.subcomponentsexample.views.user

import android.app.Application
import android.content.Context
import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class UserPresenter @Inject constructor(@Named("Intent Name") private val name: String,
                                        @Named("Application Context") private val context: Context,
                                        private val activity: UserActivity) {

    fun run() {
        Log.d("DAGGER", "Injected String " + name + " && Activity is instance of " + activity.localClassName)
        Log.d("DAGGER", "Activity context instance of Application " + (context is Application))
    }
}