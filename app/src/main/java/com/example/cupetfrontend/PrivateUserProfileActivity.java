package com.example.cupetfrontend;

import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IPrivateProfilePresenter;
import com.example.cupetfrontend.presenters.user.FetchUserProfilePresenter;

public class PrivateUserProfileActivity extends AppCompatActivity {
    private String firstName;
    private String lastName;
    private String biography;
    private int age;
    private PrivateUserProfileViewModel privateUserProfileViewModel;


    private void setFieldError(EditText field, Integer errorState){
        if (errorState != null){
            field.setError(getString(errorState));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_user_profile);


        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IUserController userController = dependencySelector.getControllers().getUserController();

        FetchUserProfilePresenter fetchUserProfilePresenter = dependencySelector.getUserPresenters().getFetchUserProfilePresenter();
        privateUserProfileViewModel = new PrivateUserProfileViewModel(userController);
        fetchUserProfilePresenter.setPrivateUserProfileViewModel(privateUserProfileViewModel);

        privateUserProfileViewModel.getProfileInformation();
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
                    onPrivateProfileSuccess(privateUserProfileResult.getFirstName(), privateUserProfileResult.getLastName(), privateUserProfileResult.getBiography());
                }
            }
        });

    }

    private void onPrivateProfileSuccess(String firstName, String lastName, String biography){
        TextView Biography_view = findViewById(R.id.UserProfileBiography);
        Biography_view.setText(biography);
        TextView name_view = findViewById(R.id.name_textview);
        String name = firstName + "" + lastName;
        Biography_view.setText(name);

    }

    private void onPrivateProfileFailure(String errorMessage){
        System.out.println("Profile Error");
    }
}
