package com.enparadigm.app.dagger

import com.enparadigm.app.AppScope
import com.enparadigm.app.MyApplication
import com.enparadigm.app.dagger.injection.ActivityBuilder
import com.enparadigm.app.dagger.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@AppScope
@Component(modules = [AppModule::class, ActivityBuilder::class,AndroidInjectionModule::class])
interface AppComponent{

    fun inject(application: MyApplication)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build() : AppComponent
    }
}