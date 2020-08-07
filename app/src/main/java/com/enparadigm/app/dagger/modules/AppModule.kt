package com.enparadigm.app.dagger.modules

import android.content.Context
import com.enparadigm.UseCaseHandler
import com.enparadigm.app.AppScope
import com.enparadigm.app.MyApplication
import com.enparadigm.app.UiThread
import com.enparadigm.data.executor.DataSource
import com.enparadigm.data.executor.DataSourceImpl
import com.enparadigm.data.executor.JobExecutor
import com.enparadigm.executor.PostThreadExecutor
import com.enparadigm.executor.ThreadExecutor
import dagger.Module
import dagger.Provides

@Module
open class AppModule{

    @Provides
    @AppScope
    fun provideApplication(application: MyApplication): Context{
          return application
    }

    @Provides
    @AppScope
    fun dataSource(context: Context): DataSource {
        return DataSourceImpl(context)
    }


    @Provides
    @AppScope
    fun provideThreadExecutor(jobExecutor: JobExecutor) : ThreadExecutor{
        return  jobExecutor
    }

    @AppScope
    @Provides
    fun providePostExecutionThread(uiThread: UiThread): PostThreadExecutor {
        return uiThread
    }

    @AppScope
    @Provides
    fun provideUseCaseHandler(): UseCaseHandler {
        return UseCaseHandler.getInstance
    }

}