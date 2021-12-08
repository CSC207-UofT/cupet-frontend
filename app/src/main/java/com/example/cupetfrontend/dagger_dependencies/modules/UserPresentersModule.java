package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.presenters.abstracts.*;
import com.example.cupetfrontend.presenters.user.CreateUserPresenter;
import com.example.cupetfrontend.presenters.user.EditUserAccountPresenter;
import com.example.cupetfrontend.presenters.user.EditUserProfilePresenter;
import com.example.cupetfrontend.presenters.user.FetchUserAccountPresenter;
import com.example.cupetfrontend.presenters.user.FetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.user.GetPetsPresenter;
import com.example.cupetfrontend.presenters.user.SetUserProfileImagePresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes={APIGatewaysModule.class})
public class UserPresentersModule {
    @Singleton
    @Provides
    public ICreateUserPresenter provideUserPresenter () {
        return new CreateUserPresenter();
    }


    @Singleton
    @Provides
    public IEditUserProfilePresenter provideEditUserProfilePresenter () {
        return new EditUserProfilePresenter();
    }

    @Singleton
    @Provides
    public FetchUserAccountOutputBoundary provideFetchUserAccountPresenter () {
        return new FetchUserAccountPresenter();
    }

    @Singleton
    @Provides
    public IFetchUserProfilePresenter provideFetchUserProfile () {
        return new FetchUserProfilePresenter();
    }

    @Singleton
    @Provides
    public IGetPetsPresenter provideGetPetsPresenter () {
        return new GetPetsPresenter();
    }


    @Singleton
    @Provides
    public ISetUserProfileImagePresenter provideSetUserProfileImagePresenter () {
        return new SetUserProfileImagePresenter();
    }

    @Singleton
    @Provides
    public IEditUserAccountPresenter provideEditUserAccountPresenter(){
        return new EditUserAccountPresenter();
    }
}
