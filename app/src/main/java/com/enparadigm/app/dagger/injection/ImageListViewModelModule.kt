package com.enparadigm.app.dagger.injection

import androidx.lifecycle.ViewModel
import com.enparadigm.app.ui.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ImageListViewModelModule : ViewModelFactory(){


    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun ImageListViewModel(weatherViewModel: WeatherViewModel) : ViewModel
}