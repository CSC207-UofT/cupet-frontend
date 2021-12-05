package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.ILoginViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;

public interface ILoginPresenter extends LoginOutputBoundary {
    void setLoginViewModel(ILoginViewModel loginViewModel);
}
