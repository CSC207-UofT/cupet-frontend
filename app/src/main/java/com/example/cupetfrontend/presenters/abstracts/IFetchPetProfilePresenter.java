package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IPetProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;

public interface IFetchPetProfilePresenter extends FetchPetProfileOutputBoundary {
    void setPetProfileViewModel(IPetProfileViewModel petProfileViewModel);
}
