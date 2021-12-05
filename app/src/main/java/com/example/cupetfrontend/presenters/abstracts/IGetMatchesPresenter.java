package com.example.cupetfrontend.presenters.abstracts;


import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;


public interface IGetMatchesPresenter extends GetMatchesOutputBoundary {
    void setGetMatchesViewModel(IGetMatchesViewModel getMatchesViewModel);
}
