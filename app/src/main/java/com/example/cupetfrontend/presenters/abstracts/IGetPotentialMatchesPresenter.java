package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IPotentialMatchesViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;

public interface IGetPotentialMatchesPresenter extends GetPotentialMatchesOutputBoundary {
    void setPotentialMatchesViewModel(IPotentialMatchesViewModel viewModel);
}
