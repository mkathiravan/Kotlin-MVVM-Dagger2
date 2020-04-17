package net.kathir.myapplication.repository

import io.reactivex.Single
import net.kathir.myapplication.data.model.Repo
import net.kathir.myapplication.data.restApiService.RepoService
import javax.inject.Inject

class RepoRepository @Inject constructor(private val repoService: RepoService)
{
    fun getRepositories() : Single<List<Repo>>
    {
        return repoService.getRepositories();
    }
}