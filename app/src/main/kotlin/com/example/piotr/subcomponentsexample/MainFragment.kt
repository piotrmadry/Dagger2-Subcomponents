package com.example.piotr.subcomponentsexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.piotr.subcomponentsexample.scoped.ActivityScoped
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject lateinit var activityScoped: ActivityScoped

    companion object {
        fun newInstance(): Fragment {
            return MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).activityComponent.plus().injectMembers(this)
    }
}