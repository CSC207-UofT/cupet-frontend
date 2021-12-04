package com.example.cupetfrontend.ui.my_pet_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.databinding.FragmentMyPetProfileBinding;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;


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
        petAge = binding.petProfileName;
        petBreed = binding.petProfileAge;
        petBio = binding.petProfileBio;
    }

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

        initializeViews();
        setUpEditBtn();

        return root;
    }

    // TODO: set up pet info to expected field
    private void setUpPetInfo() {}

    /**
     * Set up the edit button of the page:
     *  - ensure that MainActivity displays the button
     *  - link the button to the edit pet page
     */
    private void setUpEditBtn() {
        getMainActivity().showEditButton();
        getMainActivity().setEditBtnNavTarget(R.id.nav_edit_pet);
    }
}
