package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IRegisterViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.UserCreatorOutputBoundary;

public interface ICreateUserPresenter extends UserCreatorOutputBoundary {
    void setRegisterViewModel(IRegisterViewModel registerViewModel);
}
