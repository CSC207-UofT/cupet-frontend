package com.example.cupetfrontend.ui.matched_pet_profile_fragment;

import androidx.lifecycle.Observer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.cupetfrontend.databinding.DisplayPetProfileFragmentBinding;
import com.example.cupetfrontend.ui.my_pet_profile.PetProfileResult;


public class DisplayPetProfileFragment extends Fragment {
    private DisplayPetProfileFragmentBinding binding;
    private DisplayPetProfileViewModel displayPetProfileViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DisplayPetProfileFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initializeViewModel();
        initializeDisplayPetProfileObserver();
        return root;
    }

    private void initializeDisplayPetProfileObserver(){
        displayPetProfileViewModel.getPetProfileData().observe(getViewLifecycleOwner(), new Observer<PetProfileResult>() {
            @Override
            public void onChanged(PetProfileResult petProfileResult) {
                loadDisplayPetProfile(petProfileResult);
            }
        });

    }

    private void loadDisplayPetProfile (PetProfileResult petProfileResult) {

        String heading = petProfileResult.getPetName() + ", " + petProfileResult.getPetAge();
        binding.petHeading.setText(heading);

        binding.breed.setText(petProfileResult.getPetBreed());
        binding.petBio.setText(petProfileResult.getPetBio());

        Glide.with(this)
                .load(petProfileResult.getPetImage())
                .into(binding.profileImage);
    }

    private void initializeViewModel() {
        displayPetProfileViewModel = new DisplayPetProfileViewModel();
    }

}