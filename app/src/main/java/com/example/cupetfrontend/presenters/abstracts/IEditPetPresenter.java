package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IEditPetViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;

public interface IEditPetPresenter extends EditPetOutputBoundary {
    void setEditPetViewModel(IEditPetViewModel editPetViewModel);

}
