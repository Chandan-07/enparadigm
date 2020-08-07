package com.enparadigm.app.dagger.injection

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactory{
    @Binds
    abstract fun bindViewModelFactory(factory: CleanArchViewModelFactory): ViewModelProvider.Factory
}