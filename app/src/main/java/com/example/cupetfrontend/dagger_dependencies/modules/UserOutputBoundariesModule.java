package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.presenters.abstracts.*;
import com.example.cupetfrontend.presenters.user.EditUserAccountPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.user.*;

import dagger.Binds;
import dagger.Module;

@Module(includes = {UserPresentersModule.class})
public abstract class UserOutputBoundariesModule {
    @Binds
    abstract UserCreatorOutputBoundary bindUserCreatorOutputBoundary(
            ICreateUserPresenter presenter);

    @Binds
    abstract GetPetsOutputBoundary bindGetPetsOutputBoundary(
            IGetPetsPresenter presenter);

    @Binds
    abstract FetchUserProfileOutputBoundary bindFetchUserProfileOutputBoundary(
            IFetchUserProfilePresenter presenter);

    @Binds
    abstract EditUserProfileOutputBoundary bindEditUserProfileOutputBoundary(
            IEditUserProfilePresenter presenter);

    @Binds
    abstract SetUserProfileImageOutputBoundary bindUserProfileImageOutputBoundary(
            ISetUserProfileImagePresenter presenter
    );

    @Binds
    abstract EditUserAccountOutputBoundary bindEditUserAccountOutputBoundary(
            IEditUserAccountPresenter editUserAccountPresenter);

    @Binds
    abstract FetchUserAccountOutputBoundary bindFetchUserAccountOutputBoundary(
            IFetchUserAccountPresenter presenter
    );

}
