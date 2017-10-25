package com.example.piotr.subcomponentsexample.components

import com.example.piotr.subcomponentsexample.MainFragment
import com.example.piotr.subcomponentsexample.dagger.FragmentScope
import dagger.MembersInjector
import dagger.Subcomponent


@FragmentScope
@Subcomponent()
interface FragmentSubComponent: MembersInjector<MainFragment>