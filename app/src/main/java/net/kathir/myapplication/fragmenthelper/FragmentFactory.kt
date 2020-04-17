package com.example.daggermvvmretrofit.fragment_helper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import net.kathir.myapplication.R


object FragmentFactory {

    fun <T : Fragment> getFragment(aClass: Class<T>): T? {

        try {
            return aClass.newInstance()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        return null
    }

    fun <F : Fragment> getCurrentFragment(context: Context): F? {
        return if (findFragmentPlaceHolder() == 0) null else (context as AppCompatActivity).supportFragmentManager.findFragmentById(findFragmentPlaceHolder()) as F?
    }

    private fun findFragmentPlaceHolder(): Int {
        return R.id.fl_main_container
    }
}
