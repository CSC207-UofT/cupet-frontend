package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IFetchUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;

public interface IMatchedPetProfilePresenter extends FetchPetProfileOutputBoundary {
    void setMatchedPetProfilePresenter(IFetchUserProfileViewModel fetchUserProfileViewModel);
}
