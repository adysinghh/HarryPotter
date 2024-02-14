package com.adyy.harrypotter.di

import com.adyy.harrypotter.core.utils.Constants.BASE_URL
import com.adyy.harrypotter.data.api.CharacterApi
import com.adyy.harrypotter.data.repository.CharacterRepositoryImpl
import com.adyy.harrypotter.domain.repository.CharacterRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit) : CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideCharacterRepository(api: CharacterApi) : CharacterRepository {
        return CharacterRepositoryImpl(api)
    }


}