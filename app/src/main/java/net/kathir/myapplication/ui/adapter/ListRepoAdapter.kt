package net.kathir.myapplication.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import net.kathir.myapplication.R
import net.kathir.myapplication.data.model.Repo
import net.kathir.myapplication.databinding.ItemListRepoBinding
import net.kathir.myapplication.ui.activity.list.ListRepoViewModel

class ListRepoAdapter(lifeCycleOwner: LifecycleOwner,
                      listRepoViewModel: ListRepoViewModel,
                      val listener: SetOnItemClickListener) : RecyclerView.Adapter<ListRepoAdapter.RepoViewHolder>() {
    lateinit var binding: ItemListRepoBinding
    var listData = ArrayList<Repo>()


    init {
        listRepoViewModel.getRepos().observe(lifeCycleOwner, Observer<List<Repo>>() {
            listData.clear()
            if (it != null) {
                listData.addAll(it)
                notifyDataSetChanged()
            }
        })
        hasStableIds()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RepoViewHolder {
        val mView = LayoutInflater.from(p0.context).inflate(R.layout.item_list_repo, p0, false)
        binding = DataBindingUtil.bind(mView)!!
        return RepoViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemId(position: Int): Long {
        return listData[position].id
    }

    override fun onBindViewHolder(p0: RepoViewHolder, p1: Int) {
        binding.setVariable(BR.strForks, listData[p1].forks.toString())
        binding.setVariable(BR.strStars, listData[p1].stars.toString())
        binding.setVariable(BR.strRepoName, listData[p1].name)
        binding.setVariable(BR.strDescription, listData[p1].description)

        p0.itemView.setOnClickListener {
            listener.onItemClicked()
        }
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    interface SetOnItemClickListener {
        fun onItemClicked()
    }
}