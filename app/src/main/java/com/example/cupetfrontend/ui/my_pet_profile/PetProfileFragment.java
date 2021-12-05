package com.example.cupetfrontend.ui.my_pet_profile;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.databinding.FragmentMyPetProfileBinding;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;
import com.example.cupetfrontend.ui.register.RegisterResult;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * The fragment for my pet profile page.
 */
public class PetProfileFragment extends MainActivityFragment {
    private ImageView petImage;
    private TextView petName;
    private TextView petAge;
    private TextView petBreed;
    private TextView petBio;
    private PetProfileViewModel petProfileViewModel;
    private FragmentMyPetProfileBinding binding;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        petImage = binding.petProfileImage;
        petName = binding.petProfileName;
        petAge = binding.petProfileAge;
        petBreed = binding.petProfileBreed;
        petBio = binding.petProfileBio;
    }

    /**
     * Setup views of the fragment
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentMyPetProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initializeDependencySelector();

        IPetController petController = dependencySelector.getControllers().getPetController();
        IFetchPetProfilePresenter fetchPetProfilePresenter = dependencySelector.getPetPresenters().getFetchPetProfilePresenter();
        petProfileViewModel = new PetProfileViewModel(petController);
        fetchPetProfilePresenter.setPetProfileViewModel(petProfileViewModel);

        // get token from session manager
        ISessionManager sessionManager = dependencySelector.getSessionManager();
        String token = sessionManager.getToken();

        // get petId from pet session manager
        IPetSessionManager petSessionManager = dependencySelector.getPetSessionManager();
        String petId = petSessionManager.getPetId();

        petProfileViewModel.fetchPetProfile(token, petId);

        initializeViews();
        setUpObservePetProfileResult();
        setUpEditBtn();

        // TODO: remove this test code later
        petProfileViewModel.onPetProfileSuccess("", "Koko", "10", "Golden Retriever", "Hellooo!");

        return root;
    }

    /**
     * Set up this activity as an observer that observes the result of pet profile.
     *
     * Update the displayed views when the pet profile result has changed.
     */
    private void setUpObservePetProfileResult() {

        petProfileViewModel.getPetProfileResult().observe(getViewLifecycleOwner(), new Observer<PetProfileResult>() {
            @Override
            public void onChanged(@Nullable PetProfileResult petProfileResult) {
                if (petProfileResult == null) {
                    return;
                }

                if (petProfileResult.isError()){
                    onPetProfileFailure(petProfileResult.getErrorMessage());
                } else {
                    onPetProfileSuccess(
                            petProfileResult.getPetImage(),
                            petProfileResult.getPetName(),
                            petProfileResult.getPetAge(),
                            petProfileResult.getPetBreed(),
                            petProfileResult.getPetBio());
                }
                // finish(); // unused
            }
        });
    }

    /**
     * Set up the edit button of the page:
     *  - ensure that MainActivity displays the button
     *  - link the button to the edit pet page
     */
    private void setUpEditBtn() {
        getMainActivity().showEditButton();
        getMainActivity().setEditBtnNavTarget(R.id.nav_edit_pet);
    }

    /**
     * When success fetching a pet profile, set them to corresponding ImageView & TextViews.
     */
    private void onPetProfileSuccess(String petImageStr, String petNameStr, String petAgeStr, String petBreedStr, String petBioStr) {
        petName.setText(petNameStr);
        petAge.setText(petAgeStr);
        petBreed.setText(petBreedStr);
        petBio.setText(petBioStr);
        if (petImageStr != "") {
            Glide.with(this).load(petImageStr).into(petImage);
        } else {
            Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwn2UIl7YtjhkbxoIuoI4E7yyXH1KC6GvRqg&usqp=CAU").into(petImage);
        }
    }

    /**
     * Display a Fetch pet profile failed toast message.
     * @param errorMessage The error message to display
     */
    private void onPetProfileFailure(String errorMessage) {
        System.out.println("Fetch pet profile failed");
        Toast.makeText(getApplicationContext(), "Fetch pet profile failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}
