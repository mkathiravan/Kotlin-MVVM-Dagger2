package com.example.daggermvvmretrofit.ui.activity.list


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggermvvmretrofit.fragment_helper.FragmentNavigationFactory
import dagger.android.support.DaggerFragment
import net.kathir.myapplication.R
import net.kathir.myapplication.data.model.Repo
import net.kathir.myapplication.databinding.FragmentListBinding
import net.kathir.myapplication.ui.activity.list.ListRepoViewModel
import net.kathir.myapplication.ui.activity.login.LoginActivity
import net.kathir.myapplication.ui.adapter.ListRepoAdapter
import javax.inject.Inject

class ListRepoFragment : DaggerFragment(), ListRepoAdapter.SetOnItemClickListener {
    lateinit var fragmentNavigationFactory: FragmentNavigationFactory


    lateinit var binding: FragmentListBinding


    @Inject
    lateinit var listRepoViewModel: ListRepoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mView = inflater.inflate(R.layout.fragment_list, container, false)
        binding = DataBindingUtil.bind<FragmentListBinding>(mView)!!
        fragmentNavigationFactory = activity?.let { FragmentNavigationFactory(it) }!!
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvList.layoutManager = LinearLayoutManager(activity)
        binding.rvList.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        binding.rvList.adapter = ListRepoAdapter(this, listRepoViewModel, this)
        observeListRepoViewModel()
    }

    private fun observeListRepoViewModel() {
        listRepoViewModel.getRepos().observe(this, Observer<List<Repo>>() {
            if (it != null) {
                binding.setVariable(BR.isError, false)
                binding.setVariable(BR.isLoading, false)
                Log.d("SIZE", "${it.size}")
            }
        })

        listRepoViewModel.getRepoLoadError().observe(this, Observer<Boolean>() {
            if (it != null) {
                binding.setVariable(BR.isError, it)
                binding.setVariable(BR.isLoading, false)
            }
        })

        listRepoViewModel.getLoading().observe(this, Observer<Boolean>() {
            if (it != null) {
                binding.setVariable(BR.isError, false)
                binding.setVariable(BR.isLoading, true)
            }
        })

    }

    open fun onShow() {

    }

    override fun onItemClicked() {
        fragmentNavigationFactory.make(LoginActivity::class.java).start()
    }
}