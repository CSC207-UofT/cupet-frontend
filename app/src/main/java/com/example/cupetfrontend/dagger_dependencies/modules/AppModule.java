package com.example.cupetfrontend.dagger_dependencies.modules;

import android.content.Context;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;

/**
 * Module for providing the application context as a dagger dependency.
 */
@Module
public class AppModule {
    private final Context context;

    public AppModule(@NonNull Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    @NonNull
    public Context provideContext(){
        return context;
    }

}
