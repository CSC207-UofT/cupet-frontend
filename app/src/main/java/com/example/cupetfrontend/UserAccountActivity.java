package com.example.cupetfrontend;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.user.FetchUserAccountPresenter;
import org.w3c.dom.Text;

public class UserAccountActivity extends AppCompatActivity {
    private UserAccountViewModel userAccountViewModel;
    TextView username_view;
    TextView address_view;
    TextView city_view;
    TextView password_view;
    ImageView profile_picture;


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

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IUserController userController = dependencySelector.getControllers().getUserController();

        FetchUserAccountPresenter fetchUserAccountPresenter = dependencySelector.getUserPresenters().getFetchUserAccountPresenter();
        userAccountViewModel = new UserAccountViewModel(userController);
        fetchUserAccountPresenter.setUserAccountViewModel(userAccountViewModel);
        initializeViews();
        userAccountViewModel.getUserInformation();
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
                            userAccountResult.getCity(), userAccountResult.getPassword(),
                            userAccountResult.getImage_url());
                }
            }
        });
    }

    private void onUserAccountSuccess(String firstname, String lastname, String address, String city, String password, String image_url){

        address_view.setText(address);

        city_view.setText(city);

        password_view.setText(password);

        String name = firstname + " " + lastname;
        username_view.setText(name);
        Glide.with(this).load(image_url).into(profile_picture);
    }

    private void onUserAccountFailure(String errorMessage){
        System.out.println("User Account Error");
    }
}