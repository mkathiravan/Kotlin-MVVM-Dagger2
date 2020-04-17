package net.kathir.myapplication.di.module

import dagger.Module
import dagger.Provides
import net.kathir.myapplication.repository.RepoRepository
import net.kathir.myapplication.ui.activity.list.ListRepoViewModel

@Module
class FragmentViewModelProvider{

    @Provides
    fun providesListRepoFragmentModule(repository: RepoRepository): ListRepoViewModel {
        return ListRepoViewModel(repository)
    }
}