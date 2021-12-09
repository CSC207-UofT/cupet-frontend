package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.presenters.abstracts.ICreatePetPresenter;
import com.example.cupetfrontend.presenters.abstracts.IEditPetPresenter;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;
import com.example.cupetfrontend.presenters.abstracts.IGetPotentialMatchesPresenter;
import com.example.cupetfrontend.presenters.abstracts.IMatchedPetProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.IUnMatchPresenter;
import com.example.cupetfrontend.presenters.pet.CreatePetPresenter;
import com.example.cupetfrontend.presenters.pet.EditPetPresenter;
import com.example.cupetfrontend.presenters.pet.FetchPetProfilePresenter;
import com.example.cupetfrontend.presenters.pet.GetMatchesPresenter;
import com.example.cupetfrontend.presenters.pet.GetPotentialMatchesPresenter;
import com.example.cupetfrontend.presenters.pet.IntendToMatchPresenter;
import com.example.cupetfrontend.presenters.pet.RejectMatchPresenter;
import com.example.cupetfrontend.presenters.pet.SetPetProfileImagePresenter;
import com.example.cupetfrontend.presenters.pet.UnMatchPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.IntendToMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.RejectMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.SetPetProfileImageOutputBoundary;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PetPresentersModule {
    @Singleton
    @Provides
    public ICreatePetPresenter provideCreatePetPresenter() {
        return new CreatePetPresenter();
    }

    @Singleton
    @Provides
    public IEditPetPresenter provideEditPetPresenter() {
        return new EditPetPresenter();
    }

    @Singleton
    @Provides
    public IFetchPetProfilePresenter provideFetchPetProfilePresenter() {
        return new FetchPetProfilePresenter();
    }

    @Singleton
    @Provides
    public IGetMatchesPresenter provideGetMatchesPresenter() {
        return new GetMatchesPresenter();
    }

    @Singleton
    @Provides
    public IGetPotentialMatchesPresenter provideGetPotentialMatchesPresenter() {
        return new GetPotentialMatchesPresenter();
    }

    @Singleton
    @Provides
    public IntendToMatchOutputBoundary provideIntendToMatchPresenter() {
        return new IntendToMatchPresenter();
    }

    @Singleton
    @Provides
    public RejectMatchOutputBoundary provideRejectMatchPresenter() {
        return new RejectMatchPresenter();
    }

    @Singleton
    @Provides
    public SetPetProfileImageOutputBoundary provideSetPetProfileImagePresenter() {
        return new SetPetProfileImagePresenter();
    }

    @Singleton
    @Provides
    public IUnMatchPresenter provideUnMatchPetPresenter() {
        return new UnMatchPresenter();
    }
}
