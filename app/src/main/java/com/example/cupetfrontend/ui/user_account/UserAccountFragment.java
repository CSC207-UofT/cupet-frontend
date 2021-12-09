package com.example.cupetfrontend.ui.user_account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentUserAccountBinding;
import com.example.cupetfrontend.presenters.abstracts.IFetchUserAccountPresenter;
import com.example.cupetfrontend.presenters.data_models.UserAccountData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserAccountViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditUserAccountContext;
import com.example.cupetfrontend.ui.MainActivityFragment;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class UserAccountFragment extends MainActivityFragment {
    private UserAccountViewModel userAccountViewModel;
    private FragmentUserAccountBinding binding;

    @Inject
    public IUserController userController;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IFetchUserAccountPresenter fetchUserAccountPresenter;
    @Inject
    public IEditUserAccountViewModel editUserAccountViewModel;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentUserAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ((App) getApplicationContext()).getAppComponent().inject(this);

        String userToken = sessionManager.getToken();

        userAccountViewModel = new UserAccountViewModel(userController);
        fetchUserAccountPresenter.setUserAccountViewModel(userAccountViewModel);

        userAccountViewModel.fetchUserAccount(userToken);

        setUpObserveUserProfileResult();
        setUpEditBtn();

        return root;

    }


    private void setUpEditBtn(){
        getMainActivity().showEditButton();
        getMainActivity().setEditBtnNavTarget(R.id.nav_edit_account);
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
                    onUserAccountSuccess(userAccountResult.getAccountData());
                }
            }
        });
    }
    private void onUserAccountSuccess(UserAccountData userAccountData){
        binding.userAccountAddress.setText(userAccountData.getHomeAddress());
        binding.userAccountCity.setText(userAccountData.getCity());

        String name = userAccountData.getFirstName() + " " + userAccountData.getLastName();
        binding.userAccountName.setText(name);
        binding.userAccountEmail.setText(userAccountData.getEmail());

        if (sessionManager.getCachedUserData() != null &&
                !sessionManager.getCachedUserData().getProfileImgUrl().equals("")){
            Glide.with(this).load(sessionManager.
                    getCachedUserData().getProfileImgUrl()).into(binding.imageView);
        }

        editUserAccountViewModel.setContext(new EditUserAccountContext(
                userAccountData
        ));
    }

    private void onUserAccountFailure(String errorMessage){
        String toastMessage = "Fetch user account failed: " + errorMessage;
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}