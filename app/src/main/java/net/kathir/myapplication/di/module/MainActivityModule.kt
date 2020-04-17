package net.kathir.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.kathir.myapplication.repository.RepoRepository
import net.kathir.myapplication.ui.activity.main.MainViewModel

@Module
class MainActivityModule {

    @Provides
    fun providesMainActivityModule(repoRepository: RepoRepository) : MainViewModel
    {
        return MainViewModel(repoRepository)
    }
}