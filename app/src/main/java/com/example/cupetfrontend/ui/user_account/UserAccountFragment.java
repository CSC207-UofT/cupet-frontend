package com.example.cupetfrontend.ui.user_account;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentUserAccountBinding;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IFetchUserAccountPresenter;
import com.example.cupetfrontend.presenters.user.FetchUserAccountPresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;
import com.example.cupetfrontend.ui.edit_account.EditUserAccountFragment;

import javax.inject.Inject;

public class UserAccountFragment extends MainActivityFragment {
    private UserAccountViewModel userAccountViewModel;
    private TextView username_view;
    private TextView address_view;
    private TextView city_view;
    private TextView password_view;
    private ImageView profile_picture;
    private Button editUserAccount_button;
    private FragmentUserAccountBinding binding;

    @Inject
    public IUserController userController;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IFetchUserAccountPresenter fetchUserAccountPresenter;



    public void initializeViews(){
        address_view = binding.UserAccountAddressTextView;
        city_view = binding.UserAccountCityTextView;
        password_view = binding.UserAccountPasswordTextview;
        profile_picture = binding.imageView;
        username_view = binding.UserAccountNameTextView;
        editUserAccount_button = binding.EditUserAccountButton;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentUserAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ((App) getApplicationContext()).getAppComponent().inject(this);

        String userToken = sessionManager.getToken();

        fetchUserAccountPresenter = dependencySelector.getUserPresenters().getFetchUserAccountPresenter();

        userAccountViewModel = new UserAccountViewModel(userController);
        fetchUserAccountPresenter.setUserAccountViewModel(userAccountViewModel);


        userAccountViewModel.getUserInformation(userToken);

        initializeViews();
        setUpObserveUserProfileResult();
        setUpEditBtn();

        return root;

    }


    private void  setUpEditBtn(){

        getMainActivity().showEditButton();
        getMainActivity().setEditBtnNavTarget(R.id.nav_account_settings);
    }

    public void setUpObserveUserProfileResult(){
        userAccountViewModel.getUserAccountResult().observe(getViewLifecycleOwner(), new Observer<UserAccountResult>() {
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