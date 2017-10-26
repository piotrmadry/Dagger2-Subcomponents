package com.example.piotr.subcomponentsexample.views.user.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.piotr.subcomponentsexample.R
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import javax.inject.Inject

class FragmentA : BaseFragment() {

    @Inject lateinit var activityScoped: ActivityScoped

    companion object {
        fun newInstance(): Fragment {
            return FragmentA()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.button_fragment_a, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityScoped.run()
    }
}