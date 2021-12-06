package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.presenters.abstracts.ICreateUserPresenter;
import com.example.cupetfrontend.presenters.abstracts.IEditUserProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.IFetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.IGetPetsPresenter;
import com.example.cupetfrontend.presenters.abstracts.ISetUserProfileImagePresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.SetUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.UserCreatorOutputBoundary;

import dagger.Binds;
import dagger.Module;

@Module(includes={UserPresentersModule.class})
public abstract class UserOutputBoundariesModule {
    @Binds
    abstract UserCreatorOutputBoundary bindUserCreatorOutputBoundary(
            ICreateUserPresenter presenter);

    @Binds abstract GetPetsOutputBoundary bindGetPetsOutputBoundary(
            IGetPetsPresenter presenter);

    @Binds abstract FetchUserProfileOutputBoundary bindFetchUserProfileOutputBoundary(
            IFetchUserProfilePresenter presenter);

    @Binds abstract EditUserProfileOutputBoundary bindEditUserProfileOutputBoundary(
            IEditUserProfilePresenter presenter);

    @Binds abstract SetUserProfileImageOutputBoundary bindUserProfileImageOutputBoundary(
            ISetUserProfileImagePresenter presenter
    );
}
