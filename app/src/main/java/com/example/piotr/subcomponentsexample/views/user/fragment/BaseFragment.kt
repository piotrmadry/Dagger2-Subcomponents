package com.example.piotr.subcomponentsexample.views.user.fragment

import android.content.Context
import android.support.v4.app.Fragment
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection

open class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @Subcomponent
    interface BaseFragmentSubComponent : AndroidInjector<BaseFragment> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<BaseFragment>()
    }
}