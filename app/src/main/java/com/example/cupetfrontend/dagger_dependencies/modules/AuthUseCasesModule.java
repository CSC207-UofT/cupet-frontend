package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.use_cases.LoginUseCase;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.input_boundaries.LoginInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {AuthOutputBoundariesModule.class, APIGatewaysModule.class})
public class AuthUseCasesModule {
    @Singleton
    @Provides
    public LoginInputBoundary provideLogin(IAuthAPIGateway authAPIGateway,
                                           LoginOutputBoundary outputBoundary){
        return new LoginUseCase(authAPIGateway, outputBoundary);
    }
}
