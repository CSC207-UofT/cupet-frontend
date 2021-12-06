package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IUnMatchViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.UnMatchPetOutputBoundary;

public interface IUnMatchPresenter extends UnMatchPetOutputBoundary {
    void setUnMatchViewModel(IUnMatchViewModel viewModel);

}
