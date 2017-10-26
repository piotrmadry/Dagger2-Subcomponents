package com.example.piotr.subcomponentsexample.views.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import com.example.piotr.subcomponentsexample.R
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import com.example.piotr.subcomponentsexample.scoped.ApplicationScoped
import com.example.piotr.subcomponentsexample.views.base.BaseActivity
import com.example.piotr.subcomponentsexample.views.user.fragment.FragmentA
import com.example.piotr.subcomponentsexample.views.user.fragment.FragmentB
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class UserActivity : HasSupportFragmentInjector, BaseActivity() {

    @Inject lateinit var injector: DispatchingAndroidInjector<Fragment>
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

        findViewById<Button>(R.id.button_fragment_a).setOnClickListener({
            openFragment(FragmentA.newInstance())
        })

        findViewById<Button>(R.id.button_fragment_b).setOnClickListener({
            openFragment(FragmentB.newInstance())
        })
    }

    fun openFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return injector
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
