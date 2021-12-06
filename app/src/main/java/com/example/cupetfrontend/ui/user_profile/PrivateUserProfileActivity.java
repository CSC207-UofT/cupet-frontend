package com.example.cupetfrontend.ui.user_profile;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.user.FetchUserProfilePresenter;

public class PrivateUserProfileActivity extends AppCompatActivity {
    private PrivateUserProfileViewModel privateUserProfileViewModel;
    TextView biography_view;
    ImageView profile_picture;
    TextView instagram_view;
    TextView phoneNumber_view;
    TextView facebook_view;

    private void setFieldError(EditText field, Integer errorState){
        if (errorState != null){
            field.setError(getString(errorState));
        }
    };
    private void initializeViews(){
        biography_view = findViewById(R.id.UserProfileBiography);
        profile_picture = findViewById(R.id.UserProfilePicture);
        instagram_view = findViewById(R.id.UserInstagramLink_textview);
        phoneNumber_view = findViewById(R.id.UserPhoneNumberLink_textview);
        facebook_view = findViewById(R.id.UserFaceBookLink_textview);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_user_profile);


        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IUserController userController = dependencySelector.getControllers().getUserController();

        FetchUserProfilePresenter fetchUserProfilePresenter = dependencySelector.getUserPresenters().getFetchUserProfilePresenter();
        privateUserProfileViewModel = new PrivateUserProfileViewModel(userController);
        fetchUserProfilePresenter.setPrivateProfileViewModel(privateUserProfileViewModel);
        privateUserProfileViewModel.getProfileInformation();
        initializeViews();
        privateUserProfileViewModel.getPrivateUserProfileResult().observe(this, new Observer<PrivateUserProfileResult>() {
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
