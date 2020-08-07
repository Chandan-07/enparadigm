package com.enparadigm.app.dagger.injection

import com.enparadigm.app.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(includes = [ImageListViewModelModule::class,ImageListModule::class])
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun foo(): MainActivity
}