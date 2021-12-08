package com.example.cupetfrontend.ui.matched_pet_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.databinding.FragmentMatchedPetProfileBinding;
import com.example.cupetfrontend.presenters.abstracts.IMatchedPetProfilePresenter;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

public class MatchedPetProfileFragment extends MainActivityFragment {
    private FragmentMatchedPetProfileBinding binding;

    @Inject
    public IUserController userController;
    @Inject
    IMatchedPetProfilePresenter matchedPetProfilePresenter;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IContactInfoViewModel contactInfoViewModel;
    @Inject
    public IMatchedPetProfileViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMatchedPetProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //getApplicationContext().getAppComponent().inject(this);
        matchedPetProfilePresenter.setMatchedPetProfileViewModel(viewModel);

        if (viewModel.getContext() != null) {
            setUpPetProfile(viewModel.getContext().getSelectedMatchedPet());
            setUpVisitOwnerProfileButtonClickedListener();
            setUpObserveGetUserContactInfoResult();
        }

        return root;
    }

    private void setUpPetProfile(PetModel petModel) {
        String petHeading = petModel.getPetName() + ", " + petModel.getPetAge();
        binding.petHeading.setText(petHeading);
        binding.breed.setText(petModel.getPetBreed());
        binding.petBio.setText(petModel.getPetImageUrl());
    }


    private void setUpVisitOwnerProfileButtonClickedListener(){
        binding.visitOwnerProfileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO: Navigate to User's public profile
            }
        });
    }

    private void setUpObserveGetUserContactInfoResult() {
        viewModel.getUserContactInfoResult().observe(getViewLifecycleOwner(), new Observer<MatchedPetProfileOwnerContactInfoResult>() {
            @Override
            public void onChanged(MatchedPetProfileOwnerContactInfoResult fetchUserContactInfoResult) {
                if (fetchUserContactInfoResult == null) {
                    return;
                }
                if (fetchUserContactInfoResult.isError()) {
                    onFetchUserContactInfoFailure(fetchUserContactInfoResult.getErrorMessage());
                } else {
                    onFetchUserContactInfoSuccess(fetchUserContactInfoResult.getOwnerContactInfoData());
                }
            }
        });
    }

    private void onFetchUserContactInfoSuccess(UserProfileData userProfileData) {
        String imgUrl = null;
        if (!userProfileData.getProfileImgUrl().equals("")){
            imgUrl = userProfileData.getProfileImgUrl();
        }
        contactInfoViewModel.setContactInfoData(userProfileData.getEmail(),
                userProfileData.getPhoneNumber(), userProfileData.getFacebook(),
                userProfileData.getInstagram(), imgUrl);
    }

    private void onFetchUserContactInfoFailure(String errorMessage) {
        Toast.makeText(getApplicationContext(), "Request failed" + errorMessage,
                Toast.LENGTH_SHORT).show();
    }




}
