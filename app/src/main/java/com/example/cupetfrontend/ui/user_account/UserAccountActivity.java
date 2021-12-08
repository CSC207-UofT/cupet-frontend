package com.example.cupetfrontend.ui.user_account;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IFetchUserAccountPresenter;
import com.example.cupetfrontend.presenters.user.FetchUserAccountPresenter;
import com.example.cupetfrontend.ui.edit_account.EditUserAccountFragment;

import javax.inject.Inject;

public class UserAccountActivity extends AppCompatActivity {
    private UserAccountViewModel userAccountViewModel;
    TextView username_view;
    TextView address_view;
    TextView city_view;
    TextView password_view;
    ImageView profile_picture;
    Button editUserAccount_button;

    @Inject
    public IUserController userController;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IFetchUserAccountPresenter fetchUserAccountPresenter;

    private void setFieldError(EditText field, Integer errorState){
        if (errorState != null){
            field.setError(getString(errorState));
        }
    };

    public void initializeViews(){
        address_view = findViewById(R.id.UserAccountAddress_textView);

        city_view = findViewById(R.id.UserAccountCity_textView);
        password_view = findViewById(R.id.UserAccountPassword_textview);

        profile_picture = findViewById(R.id.imageView);
        username_view = findViewById(R.id.UserAccountName_textView);
        editUserAccount_button = findViewById(R.id.EditUserAccount_button);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IUserController userController = dependencySelector.getControllers().getUserController();

        String userToken = sessionManager.getToken();

        FetchUserAccountPresenter fetchUserAccountPresenter = dependencySelector.getUserPresenters().getFetchUserAccountPresenter();
        userAccountViewModel = new UserAccountViewModel(userController);
        fetchUserAccountPresenter.setUserAccountViewModel(userAccountViewModel);


        userAccountViewModel.getUserInformation(userToken);
        initializeViews();
        setUpObserveUserProfileResult();
        editUserAccount_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditUserAccountActivity();
            }
        });


    }

    public void openEditUserAccountActivity(){
        Intent intent = new Intent(this, EditUserAccountFragment.class);
    }

    public void setUpObserveUserProfileResult(){
        userAccountViewModel.getUserAccountResult().observe(this, new Observer<UserAccountResult>() {
            @Override
            public void onChanged(UserAccountResult userAccountResult) {
                if (userAccountResult == null){
                    return;
                }

                if (userAccountResult.isError()){
                    onUserAccountFailure(userAccountResult.getErrorMessage());
                }
                else{
                    onUserAccountSuccess(userAccountResult.getFirstName(),
                            userAccountResult.getLastName(), userAccountResult.getAddress(),
                            userAccountResult.getCity(),
                            userAccountResult.getImage_url());
                }
            }
        });
    }
    private void onUserAccountSuccess(String firstname, String lastname, String address, String city, String image_url){

        address_view.setText(address);

        city_view.setText(city);


        String name = firstname + " " + lastname;
        username_view.setText(name);
        Glide.with(this).load(image_url).into(profile_picture);
    }

    private void onUserAccountFailure(String errorMessage){
        System.out.println("User Account Error");
    }
}