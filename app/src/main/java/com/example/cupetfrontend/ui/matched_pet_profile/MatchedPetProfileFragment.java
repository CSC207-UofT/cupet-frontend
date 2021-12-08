package com.example.cupetfrontend.ui.matched_pet_profile;

import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.databinding.FragmentMatchedPetProfileBinding;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

public class MatchedPetProfileFragment extends MainActivityFragment {
    @Inject
    public IMatchedPetProfileViewModel viewModel;
    @Inject
    public ISessionManager sessionManager;
    private FragmentMatchedPetProfileBinding binding;


}
