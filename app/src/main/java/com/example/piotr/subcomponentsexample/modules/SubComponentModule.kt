package com.example.piotr.subcomponentsexample.modules

import com.example.piotr.subcomponentsexample.MainActivity
import dagger.Module


@Module(subcomponents = arrayOf(MainActivity.MainActivitySubComponent::class))
class SubComponentModule