package net.kathir.myapplication.ui.activity.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import net.kathir.myapplication.data.model.Repo
import net.kathir.myapplication.repository.RepoRepository

class MainViewModel constructor(val repoRepository: RepoRepository) : ViewModel()
{
    private var compositeDisposable: CompositeDisposable ? = null
    var repos = MutableLiveData<List<Repo>>()
    var repoLoadError = MutableLiveData<Boolean> ()
    var loading = MutableLiveData<Boolean>()

    init {
        compositeDisposable = CompositeDisposable()
        fetchRepos()
    }

    private fun fetchRepos() {
            loading.value = true
           val repoDisposable = repoRepository.getRepositories().subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(object : DisposableSingleObserver<List<Repo>>() {
                   override fun onSuccess(t: List<Repo>) {
                       repos.value = t
                       loading.value = false
                       repoLoadError.value = false
                   }

                   override fun onError(e: Throwable) {
                       repoLoadError.value = true
                       loading.value = false
                   }
               })
        compositeDisposable?.add(repoDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.clear()
        compositeDisposable = null
    }
}