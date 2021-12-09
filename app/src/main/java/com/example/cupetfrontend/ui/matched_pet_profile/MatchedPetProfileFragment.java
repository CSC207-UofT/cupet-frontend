package com.example.cupetfrontend.ui.matched_pet_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.databinding.FragmentMatchedPetProfileBinding;
import com.example.cupetfrontend.presenters.abstracts.IFetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.IMatchedPetProfilePresenter;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UserProfileContext;
import com.example.cupetfrontend.ui.MainActivityFragment;

import javax.inject.Inject;

public class MatchedPetProfileFragment extends MainActivityFragment {
    private FragmentMatchedPetProfileBinding binding;

    @Inject
    public IUserController userController;
    @Inject
    public IFetchUserProfilePresenter presenter;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IContactInfoViewModel contactInfoViewModel;
    @Inject
    public IMatchedPetProfileViewModel viewModel;
    @Inject
    public IUserProfileViewModel userProfileViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMatchedPetProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getApplicationContext().getAppComponent().inject(this);
        presenter.setViewModel(viewModel);

        if (viewModel.getContext() != null) {
            viewModel.fetchUserProfile(sessionManager.getToken(), viewModel.getContext().
                    getSelectedMatchedPet().getUserId());

            setUpPetProfile(viewModel.getContext().getSelectedMatchedPet());
            setUpVisitOwnerProfileButtonClickedListener(viewModel.getContext().
                    getSelectedMatchedPet().getUserId());
            setUpObserveGetUserContactInfoResult();
        }
        return root;
    }

    /**
     * Set up pet profile for pet selected from Get Matches Fragment
     *
     * @param petModel the selected matched pet
     */
    private void setUpPetProfile(PetModel petModel) {
        String petHeading = petModel.getPetName() + ", " + petModel.getPetAge();
        binding.petHeading.setText(petHeading);
        binding.breed.setText(petModel.getPetBreed());
        binding.petBio.setText(petModel.getPetImageUrl());
    }

    /**
     * Sets up the user contact information fragment for the owner of the selected matched pet
     */
    private void setUpVisitOwnerProfileButtonClickedListener(String userId) {
        binding.visitOwnerProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProfileViewModel.setContext(new UserProfileContext(userId));

                getMainActivity().navigate(R.id.nav_public_user_profile);
            }
        });
    }

    /**
     * Set up this fragment as an observer that observes the result of obtaining the user profile
     * data for the selected pet's owner.
     * <p>
     * Update the displayed views when the MatchedPetProfileOwnerContactInfoResult
     * result has changed.
     */
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

    /**
     * Display a Fetch User Contact Info Success toast message and set up Contact Info Fragment
     * for user.
     */
    private void onFetchUserContactInfoSuccess(UserProfileData userProfileData) {
        Toast.makeText(getApplicationContext(), "Fetch User Contact Info Success", Toast.LENGTH_SHORT).show();

        String imgUrl = null;
        if (!userProfileData.getProfileImgUrl().equals("")) {
            imgUrl = userProfileData.getProfileImgUrl();
        }
        contactInfoViewModel.setContactInfoData(userProfileData.getEmail(),
                userProfileData.getPhoneNumber(), userProfileData.getFacebook(),
                userProfileData.getInstagram(), imgUrl);
    }

    /**
     * Display a FetchUserProfile failed toast message.
     *
     * @param errorMessage The error message to display
     */
    private void onFetchUserContactInfoFailure(String errorMessage) {
        Toast.makeText(getApplicationContext(), "Request failed" + errorMessage,
                Toast.LENGTH_SHORT).show();
    }
}
