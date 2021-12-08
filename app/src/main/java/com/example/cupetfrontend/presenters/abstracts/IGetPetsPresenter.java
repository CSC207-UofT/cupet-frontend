package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IViewMyPetsViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;

public interface IGetPetsPresenter extends GetPetsOutputBoundary {
    void setGetPetsViewModel(IViewMyPetsViewModel getPetsViewModel);
}
