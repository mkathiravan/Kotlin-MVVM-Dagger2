package net.kathir.myapplication
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.daggermvvmretrofit.fragment_helper.FragmentFactory
import com.example.daggermvvmretrofit.fragment_helper.FragmentNavigationFactory
import com.example.daggermvvmretrofit.ui.activity.list.ListRepoFragment
import dagger.android.support.DaggerAppCompatActivity
import net.kathir.myapplication.ui.activity.main.MainViewModel
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var mMainViewModel: MainViewModel

    lateinit var fragmentNavigationFactory: FragmentNavigationFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fragmentNavigationFactory = FragmentNavigationFactory(this)
        fragmentNavigationFactory.make(ListRepoFragment()).replace(false)
    }

    fun <F : Fragment> getCurrentFragment(): Fragment? {
        return FragmentFactory.getCurrentFragment<Fragment>(this)
    }


    private fun findFragmentPlaceHolder(): Int {
        return R.id.fl_main_container
    }
}

