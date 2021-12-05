package com.example.cupetfrontend.ui.potential_matches;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.databinding.FragmentMyPetProfileBinding;
import com.example.cupetfrontend.databinding.FragmentPotentialMatchesBinding;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.pet.PresentedPetData;
import com.example.cupetfrontend.ui.MainActivityFragment;
import com.example.cupetfrontend.ui.register.RegisterResult;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment for the potential matches page
 */
public class PotentialMatchesFragment extends MainActivityFragment {
    PotentialMatchesViewModel viewModel;
    FragmentPotentialMatchesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentPotentialMatchesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initializeDependencySelector();
        IPetController petController = dependencySelector.getControllers().getPetController();
        viewModel = new PotentialMatchesViewModel(petController);

        dependencySelector.getPetPresenters().getGetPotentialMatchesPresenter().
                setPotentialMatchesViewModel(viewModel);

        setUpExpandListeners();
        setUpRejectBtnListener();
        setUpMatchBtnListener();
        setUpObserveGetPotentialMatchesResult();

        hideMatchView();
        showNoMatchesView();
        setUpEditBtn();

        // TODO: Uncomment once API is updated
//        viewModel.getPotentialMatches(dependencySelector.getSessionManager().getToken(),
//                dependencySelector.getPetSessionManager().getPetId());

        List<PresentedPetData> dummyData = new ArrayList<>();
        dummyData.add(new PresentedPetData("Dog", "4", "Dog Breed",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://i.insider.com/5484d9d1eab8ea3017b17e29?width=600&format=jpeg&auto=webp", "3"));
        dummyData.add(new PresentedPetData("Cat", "3", "Cat Breed",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*",
                "4"));

        viewModel.onGetPotentialMatchesSuccess(dummyData);


        return root;
    }

    private void setUpRejectBtnListener() {
        binding.swipeLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ISessionManager sessionManager = dependencySelector.getSessionManager();
                IPetSessionManager petSessionManager = dependencySelector.getPetSessionManager();

                viewModel.rejectCurrentPet(
                        sessionManager.getToken(), petSessionManager.getPetId());

                moveToNextMatch();
            }
        });
    }

    private void setUpMatchBtnListener() {
        binding.swipeRightBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ISessionManager sessionManager = dependencySelector.getSessionManager();
                IPetSessionManager petSessionManager = dependencySelector.getPetSessionManager();

                viewModel.intendToMatchCurrentPet(
                        sessionManager.getToken(), petSessionManager.getPetId());

                moveToNextMatch();
            }
        });
    }

    /**
     * Set up listeners for expanding the pet preview view
     */
    private void setUpExpandListeners(){
        binding.potentialProfileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandMatchView();
            }
        });
    }

    /**
     * Set up this activity as an observer that observes the result of the get potential
     * matches request.
     */
    private void setUpObserveGetPotentialMatchesResult() {
        viewModel.getGetPotentialMatchesResult().observe(this, new Observer<GetPotentialMatchesResult>() {
            @Override
            public void onChanged(GetPotentialMatchesResult getPotentialMatchesResult) {
                if (getPotentialMatchesResult == null) {
                    return;
                }

                if (getPotentialMatchesResult.isError()){
                    onGetPotentialMatchesFailure(getPotentialMatchesResult.getErrorMessage());
                }else{
                    moveToNextMatch();
                }
            }
        });
    }

    /**
     * Hide the match view
     */
    private void hideMatchView() {
        binding.matchContainer.setVisibility(View.GONE);
    }

    /**
     * Show the match view
     */
    private void showMatchView() {
        binding.matchContainer.setVisibility(View.VISIBLE);
    }

    /**
     * Hide the no matches view
     */
    private void hideNoMatchesView() {
        binding.potentialNoMatchesView.setVisibility(View.GONE);
    }

    /**
     * Show the no matches view
     */
    private void showNoMatchesView() {
        binding.potentialNoMatchesView.setVisibility(View.VISIBLE);
    }

    /**
     * Expand the match view.
     */
    private void expandMatchView() {
        binding.potentialHeadingPreview.setVisibility(View.GONE);
        binding.potentialGradientPreview.setVisibility(View.GONE);
        binding.potentialSubheadingPreview.setVisibility(View.GONE);
        binding.potentialDots.setVisibility(View.GONE);


        binding.potentialExpandedTextContainer.setVisibility(View.VISIBLE);
    }

    /**
     * Contract the match view.
     */
    private void contractMatchView() {
        binding.potentialHeadingPreview.setVisibility(View.VISIBLE);
        binding.potentialGradientPreview.setVisibility(View.VISIBLE);
        binding.potentialSubheadingPreview.setVisibility(View.VISIBLE);
        binding.potentialDots.setVisibility(View.VISIBLE);

        binding.potentialExpandedTextContainer.setVisibility(View.GONE);
    }

    /**
     * Update the views to display pet data
     *
     * @param petData The pet data to display
     */
    private void displayMatch(PresentedPetData petData) {
        String heading = petData.getName() + ", " + petData.getAge();

        binding.potentialHeading.setText(heading);
        binding.potentialSubheading.setText(petData.getBreed());
        binding.potentialBiography.setText(petData.getBiography());

        binding.potentialHeadingPreview.setText(heading);
        binding.potentialSubheadingPreview.setText(petData.getBreed());


        Glide.with(this).asBitmap().load(petData.getProfileImgUrl()).dontAnimate().into(
                binding.potentialProfileImg);

        contractMatchView();
        showMatchView();
        hideNoMatchesView();
    }

    /**
     * Display no matches screen
     */
    private void displayNoMatches(){
        showNoMatchesView();
        hideMatchView();
    }


    /**
     * Move to the next match. If no more matches exist, display that there
     * are no more matches to scroll through.
     */
    private void moveToNextMatch() {
        if (viewModel.hasNextMatch()){
            displayMatch(viewModel.getNextMatch());
        }else{
            displayNoMatches();
        }
    }

    /**
     * Display a failure message on an unsuccessful get potential
     * matches request.
     * @param errorMessage The error message
     */
    private void onGetPotentialMatchesFailure(String errorMessage){
        Toast.makeText(getApplicationContext(),
                "Request failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * Hide the appbar edit button
     */
    private void setUpEditBtn () {
        getMainActivity().hideEditButton();
    }
}