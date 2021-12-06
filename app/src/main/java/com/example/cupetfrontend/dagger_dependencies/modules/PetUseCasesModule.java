package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.EditPetInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.FetchPetProfileInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetPotentialMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.IntendToMatchInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.PetCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.RejectMatchInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.SetPetProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.UnMatchPetInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.IntendToMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.RejectMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.SetPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.UnMatchPetOutputBoundary;
import com.example.cupetfrontend.use_cases.pet.EditPet;
import com.example.cupetfrontend.use_cases.pet.FetchPetProfile;
import com.example.cupetfrontend.use_cases.pet.GetMatches;
import com.example.cupetfrontend.use_cases.pet.GetPotentialMatches;
import com.example.cupetfrontend.use_cases.pet.IntendToMatch;
import com.example.cupetfrontend.use_cases.pet.PetCreator;
import com.example.cupetfrontend.use_cases.pet.RejectMatch;
import com.example.cupetfrontend.use_cases.pet.SetPetProfileImage;
import com.example.cupetfrontend.use_cases.pet.UnMatchPet;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes={APIGatewaysModule.class, PetOutputBoundariesModule.class})
public class PetUseCasesModule {
    @Singleton
    @Provides
    public EditPetInputBoundary provideEditPet(
            IPetAPIGateway petAPIGateway, EditPetOutputBoundary outputBoundary){
        return new EditPet(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public FetchPetProfileInputBoundary provideFetchPetProfile(
            IPetAPIGateway petAPIGateway, FetchPetProfileOutputBoundary outputBoundary) {
        return new FetchPetProfile(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public GetMatchesInputBoundary provideGetMatches (
            IPetAPIGateway petAPIGateway, GetMatchesOutputBoundary outputBoundary) {
        return new GetMatches(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public GetPotentialMatchesInputBoundary provideGetPotentialMatches(
            IPetAPIGateway petAPIGateway, GetPotentialMatchesOutputBoundary outputBoundary) {
        return new GetPotentialMatches(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public IntendToMatchInputBoundary provideIntendToMatch(
            IPetAPIGateway petAPIGateway, IntendToMatchOutputBoundary outputBoundary) {
        return new IntendToMatch(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public PetCreatorInputBoundary providePetCreator(
            IPetAPIGateway petAPIGateway, PetCreatorOutputBoundary outputBoundary) {
        return new PetCreator(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public RejectMatchInputBoundary provideRejectMatch(
            IPetAPIGateway petAPIGateway, RejectMatchOutputBoundary outputBoundary) {
        return new RejectMatch(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public SetPetProfileImageInputBoundary provideSetPetProfileImage(
            IPetAPIGateway petAPIGateway, SetPetProfileImageOutputBoundary outputBoundary) {
        return new SetPetProfileImage(petAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public UnMatchPetInputBoundary provideUnMatchPet(
            IPetAPIGateway petAPIGateway, UnMatchPetOutputBoundary outputBoundary) {
        return new UnMatchPet(petAPIGateway, outputBoundary);
    }
}
