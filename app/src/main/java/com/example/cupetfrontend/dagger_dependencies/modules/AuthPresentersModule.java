package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.presenters.LoginPresenter;
import com.example.cupetfrontend.presenters.abstracts.ILoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthPresentersModule {

    @Singleton
    @Provides
    public ILoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }
}
