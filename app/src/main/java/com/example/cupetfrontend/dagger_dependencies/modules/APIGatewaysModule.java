package com.example.cupetfrontend.dagger_dependencies.modules;

import android.content.Context;

import com.example.cupetfrontend.drivers.api.AuthAPIGateway;
import com.example.cupetfrontend.drivers.api.HTTPRequestManager;
import com.example.cupetfrontend.drivers.api.PetAPIGateway;
import com.example.cupetfrontend.drivers.api.UserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {AppModule.class})
public class APIGatewaysModule {
    @Provides
    @Singleton
    public IServerRequestManager provideRequestManager(Context context) {
        return new HTTPRequestManager(context);
    }

    @Provides
    @Singleton
    public IAuthAPIGateway provideUserAPIGateway(IServerRequestManager requestManager) {
        return new AuthAPIGateway(requestManager);
    }

    @Provides
    @Singleton
    public IUserAPIGateway provideAuthAPIGateway(IServerRequestManager requestManager) {
        return new UserAPIGateway(requestManager);
    }

    @Provides
    @Singleton
    public IPetAPIGateway providePetAPIGateway(IServerRequestManager requestManager) {
        return new PetAPIGateway(requestManager);
    }
}
