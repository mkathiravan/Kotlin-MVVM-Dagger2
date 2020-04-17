package net.kathir.myapplication.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.kathir.myapplication.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}