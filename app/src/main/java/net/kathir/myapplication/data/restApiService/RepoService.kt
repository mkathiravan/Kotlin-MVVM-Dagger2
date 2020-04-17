package net.kathir.myapplication.data.restApiService

import io.reactivex.Single
import net.kathir.myapplication.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoService
{
    @GET("orgs/Google/repos")
    fun getRepositories(): Single<List<Repo>>
}