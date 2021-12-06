package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.presenters.abstracts.ICreatePetPresenter;
import com.example.cupetfrontend.presenters.abstracts.IEditPetPresenter;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;
import com.example.cupetfrontend.presenters.abstracts.IGetPotentialMatchesPresenter;
import com.example.cupetfrontend.presenters.abstracts.IUnMatchPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.UnMatchPetOutputBoundary;

import dagger.Binds;
import dagger.Module;

@Module(includes={PetPresentersModule.class})
public abstract class PetOutputBoundariesModule {
    @Binds
    abstract PetCreatorOutputBoundary providePetCreatorOutputBoundary(
            ICreatePetPresenter createPetPresenter);

    @Binds abstract EditPetOutputBoundary provideEditPetOutputBoundary(
            IEditPetPresenter editPetPresenter);


    @Binds abstract FetchPetProfileOutputBoundary provideFetchPetProfileOutputBoundary(
            IFetchPetProfilePresenter fetchPetProfilePresenter);


    @Binds abstract GetMatchesOutputBoundary provideGetMatchesOutputBoundary(
            IGetMatchesPresenter getMatchesPresenter);

    @Binds abstract GetPotentialMatchesOutputBoundary provideGetPotentialMatchesOutputBoundary(
            IGetPotentialMatchesPresenter getPotentialMatchesPresenter);

    @Binds abstract UnMatchPetOutputBoundary provideUnMatchPetOutputBoundary(
            IUnMatchPresenter unMatchPresenter);
}
