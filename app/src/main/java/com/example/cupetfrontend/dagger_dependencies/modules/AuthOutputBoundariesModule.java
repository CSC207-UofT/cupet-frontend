package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.presenters.abstracts.ILoginPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;

import dagger.Binds;
import dagger.Module;

@Module(includes = {AuthPresentersModule.class})
public abstract class AuthOutputBoundariesModule {
    @Binds
    abstract LoginOutputBoundary provideLoginOutputBoundary(
            ILoginPresenter presenter);
}
