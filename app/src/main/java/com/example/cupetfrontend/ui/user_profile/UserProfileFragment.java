package com.example.cupetfrontend.ui.user_profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentCreatePetBinding;
import com.example.cupetfrontend.databinding.FragmentUserProfileBinding;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.user.FetchUserProfilePresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;

public class UserProfileFragment extends MainActivityFragment {
    private PrivateUserProfileViewModel privateUserProfileViewModel;
    private FragmentUserProfileBinding binding;

    TextView biography_view;
    ImageView profile_picture;
    TextView instagram_view;
    TextView phoneNumber_view;
    TextView facebook_view;


    private void initializeViews(){
        biography_view = binding.UserProfileBiography;
        profile_picture = binding.UserProfilePicture;
        instagram_view = binding.UserInstagramLinkTextview;
        phoneNumber_view = binding.UserPhoneNumberLinkTextview;
        facebook_view = binding.UserFaceBookLinkTextview;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initializeDependencySelector();

        IUserController userController = dependencySelector.getControllers().getUserController();

        FetchUserProfilePresenter fetchUserProfilePresenter = dependencySelector.getUserPresenters().getFetchUserProfilePresenter();
        privateUserProfileViewModel = new PrivateUserProfileViewModel(userController);
        fetchUserProfilePresenter.setPrivateProfileViewModel(privateUserProfileViewModel);
//        privateUserProfileViewModel.getProfileInformation();
        initializeViews();

        privateUserProfileViewModel.getPrivateUserProfileResult().observe(getViewLifecycleOwner(), new Observer<PrivateUserProfileResult>() {
            @Override
            public void onChanged(PrivateUserProfileResult privateUserProfileResult) {
                if (privateUserProfileResult == null){
                    return;
                }

                if (privateUserProfileResult.isError()){
                    onPrivateProfileFailure(privateUserProfileResult.getErrorMessage());
                }
                else{
                    onPrivateProfileSuccess(privateUserProfileResult.getBiography(),
                            privateUserProfileResult.getInstagram(), privateUserProfileResult.getFacebook(),
                            privateUserProfileResult.getPhoneNumber(), privateUserProfileResult.getImage_url());
                }
            }
        });

        getMainActivity().showEditButton();
        getMainActivity().setEditBtnNavTarget(R.id.nav_edit_user_profile);

        return root;
    }

    private void onPrivateProfileSuccess(String biography, String instagram, String facebook, String phoneNumber, String image_url){
        biography_view.setText(biography);
        instagram_view.setText(instagram);
        facebook_view.setText(facebook);
        phoneNumber_view.setText(phoneNumber);
        Glide.with(this).load(image_url).into(profile_picture);
    }

    private void onPrivateProfileFailure(String errorMessage){
        System.out.println("Profile Error");
    }
}
