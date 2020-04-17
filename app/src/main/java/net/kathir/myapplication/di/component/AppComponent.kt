package net.kathir.myapplication.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import net.kathir.myapplication.base.BaseApplication
import net.kathir.myapplication.di.module.ActivityModule
import net.kathir.myapplication.di.module.AppModule
import net.kathir.myapplication.di.module.ContextModule
import net.kathir.myapplication.di.module.FragmentModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    ContextModule::class,
    FragmentModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(instance: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(daggerApplication: DaggerApplication): Builder

        fun build(): AppComponent
    }
}