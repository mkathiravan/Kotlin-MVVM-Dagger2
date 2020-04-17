package com.example.daggermvvmretrofit.ui.activity.list


import androidx.fragment.app.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kathir.myapplication.di.module.FragmentViewModelProvider

@Module
abstract class ListRepoFragmentProvider {
    @ContributesAndroidInjector(modules = [FragmentViewModelProvider::class])
    abstract fun provideListRepoFragmentFactory(): ListFragment

    /*@ContributesAndroidInjector
    abstract fun provideListRepoFragmentFactory(): ListFragment*/

}