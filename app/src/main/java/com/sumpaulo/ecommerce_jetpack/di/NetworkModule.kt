package com.sumpaulo.ecommerce_jetpack.di

import com.sumpaulo.ecommerce_jetpack.core.Config
import com.sumpaulo.ecommerce_jetpack.data.datastore.AuthDataStore
import com.sumpaulo.ecommerce_jetpack.data.service.AuthService
import com.sumpaulo.ecommerce_jetpack.data.service.CategoriesService
import com.sumpaulo.ecommerce_jetpack.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton                  //pegar o token já armazenado
    fun provideOkHttpClient(dataStore: AuthDataStore) = OkHttpClient.Builder().addInterceptor {
        val token = runBlocking {
            dataStore.getData().first().token
        }

        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
      return  Retrofit.Builder()
          .baseUrl(Config.BASE_URL)
          .client(okHttpClient)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
    }


    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService{
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }
}