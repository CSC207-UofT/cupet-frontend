package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.ICreaterPetViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;

public interface ICreatePetPresenter extends PetCreatorOutputBoundary {
    void setCreatePetViewModel(ICreaterPetViewModel creatorPetViewModel);
}
