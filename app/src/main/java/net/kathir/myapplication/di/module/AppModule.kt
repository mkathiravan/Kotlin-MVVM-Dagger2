package net.kathir.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.kathir.myapplication.data.restApiService.RepoService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [])
class AppModule {

    companion object {
        val BASE_URL = "https://api.github.com/"
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): RepoService {
        return retrofit.create(RepoService::class.java)
    }

}