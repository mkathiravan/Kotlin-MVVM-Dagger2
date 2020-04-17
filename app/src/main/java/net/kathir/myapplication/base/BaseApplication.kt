package net.kathir.myapplication.base

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.kathir.myapplication.di.component.DaggerAppComponent

class BaseApplication : DaggerApplication()
{
    override fun applicationInjector(): AndroidInjector<out dagger.android.support.DaggerApplication> {
        val application = DaggerAppComponent.builder().application(this).build()
        application.inject(this)
        return application

    }

}