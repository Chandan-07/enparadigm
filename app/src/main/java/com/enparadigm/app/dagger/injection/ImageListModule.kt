package com.enparadigm.app.dagger.injection

import com.enparadigm.GetImageListUsecase
import com.enparadigm.data.executor.RepositoryImpl
import com.enparadigm.interactor.UseCase
import com.enparadigm.repository.Repository
import dagger.Module
import dagger.Provides

@Module
open class ImageListModule{

    @Provides
    fun provideRepositoryImp( repositoryImpl: RepositoryImpl) :Repository =repositoryImpl

    @Provides
    fun getImageListUseCase(getImageListUsecase: GetImageListUsecase): UseCase<GetImageListUsecase.RequestValues,GetImageListUsecase.ResponseValues> =
        getImageListUsecase
}