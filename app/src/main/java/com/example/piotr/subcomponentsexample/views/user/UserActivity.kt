package com.example.piotr.subcomponentsexample.views.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.piotr.subcomponentsexample.R
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import com.example.piotr.subcomponentsexample.views.base.BaseActivity
import javax.inject.Inject

class UserActivity : BaseActivity() {
    @Inject lateinit var applicationScoped: ApplicationScoped
    @Inject lateinit var activityScoped: ActivityScoped
    @Inject lateinit var presenter: UserPresenter

    companion object {
        val EXTRA_NAME = "extra_name"
        fun newIntent(context: Context, name: String): Intent {
            return Intent(context, UserActivity::class.java).putExtra(EXTRA_NAME, name)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)

        applicationScoped.run()
        activityScoped.run()
        presenter.run()
    }
}