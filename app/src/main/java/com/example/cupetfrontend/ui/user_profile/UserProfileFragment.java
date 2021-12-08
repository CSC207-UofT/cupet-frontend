package com.example.cupetfrontend.ui.user_profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentUserProfileBinding;
import com.example.cupetfrontend.presenters.abstracts.IFetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditUserProfileContext;
import com.example.cupetfrontend.ui.MainActivityFragment;
import com.example.cupetfrontend.presenters.view_model_abstracts.IContactInfoViewModel;

import javax.inject.Inject;

public class UserProfileFragment extends MainActivityFragment {
    private UserProfileViewModel viewModel;
    private FragmentUserProfileBinding binding;

    @Inject
    public IUserController userController;
    @Inject
    public IFetchUserProfilePresenter fetchUserProfilePresenter;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IContactInfoViewModel contactInfoViewModel;
    @Inject
    public IEditUserProfileViewModel editUserProfileViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getApplicationContext().getAppComponent().inject(this);

        viewModel = new UserProfileViewModel(userController);
        fetchUserProfilePresenter.setViewModel(viewModel);

        viewModel.fetchUserProfile(sessionManager.getToken(), sessionManager.getUserId());

        viewModel.getFetchUserProfileResult().observe(getViewLifecycleOwner(), new Observer<FetchUserProfileResult>() {
            @Override
            public void onChanged(FetchUserProfileResult fetchUserProfileResult) {
                if (fetchUserProfileResult == null){
                    return;
                }

                if (fetchUserProfileResult.isError()){
                    onFetchUserProfileFailure(fetchUserProfileResult.getErrorMessage());
                } else {
                    onFetchUserProfileSuccess(fetchUserProfileResult.getUserProfileData());
                }
            }
        });

        getMainActivity().showEditButton();
        getMainActivity().setEditBtnNavTarget(R.id.nav_edit_user_profile);

        return root;
    }

    private void onFetchUserProfileSuccess(UserProfileData userProfileData){
        contactInfoViewModel.setContactInfoData(userProfileData.getEmail(),
                userProfileData.getPhoneNumber(), userProfileData.getFacebook(),
                userProfileData.getInstagram(), null);

        if (!userProfileData.getProfileImgUrl().equals("")){
            Glide.with(this).load(userProfileData.getProfileImgUrl())
                    .into(binding.userProfileImage);
        }

        String headerText = userProfileData.getFirstName() + " " +
                userProfileData.getLastName();

        binding.userProfileHeader.setText(headerText);
        binding.userProfileBiography.setText(userProfileData.getBiography());

        editUserProfileViewModel.setContext(new EditUserProfileContext(
                userProfileData
        ));
    }

    private void onFetchUserProfileFailure(String errorMessage){
        Toast.makeText(getApplicationContext(), "Fetch User Profile Failed: " +
                errorMessage, Toast.LENGTH_SHORT).show();
    }
}
