package com.example.cupetfrontend.ui.potential_matches;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.pet.PresentedPetData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPotentialMatchesViewModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * A ViewModel class for the potential matches page
 */
public class PotentialMatchesViewModel implements IPotentialMatchesViewModel {
    MutableLiveData<GetPotentialMatchesResult> getPotentialMatchesResult = new MutableLiveData<>();
    private final IPetController petController;

    /**
     * The current index of the pet being viewed.
     */
    private int currentIndex;

    public PotentialMatchesViewModel(IPetController petController) {
        this.petController = petController;
    }

    public void getPotentialMatches(String token, String petId) {
        petController.getPotentialMatches(token, petId);
    }

    public void rejectCurrentPet(String token, String petId) {
        String targetPetId = getMatchAt(currentIndex - 1).getPetId();

        petController.rejectMatch(token, petId, targetPetId);
    }

    public void intendToMatchCurrentPet(String token, String petId) {
        String targetPetId = getMatchAt(currentIndex - 1).getPetId();

        petController.intendToMatch(token, petId, targetPetId);
    }

    /**
     * Return whether there is a next potential match to view.
     */
    public boolean hasNextMatch() {
        GetPotentialMatchesResult result = getPotentialMatchesResult.getValue();

        if (result == null) {
            throw new MatchesNotLoadedException();
        } else {
            List<PresentedPetData> potentialMatches = result.getPotentialMatches();

            int numMatches = potentialMatches.size();

            return currentIndex != numMatches;
        }
    }

    /**
     * Return the next pet to be viewed.
     * <p>
     * If there are no more pets to be viewed,
     */
    public PresentedPetData getNextMatch() {
        GetPotentialMatchesResult result = getPotentialMatchesResult.getValue();

        if (result == null) {
            throw new MatchesNotLoadedException();
        } else {
            List<PresentedPetData> potentialMatches = result.getPotentialMatches();

            PresentedPetData res = potentialMatches.get(currentIndex);

            currentIndex += 1;

            return res;
        }
    }

    /**
     * Return a potential match at the given index.
     */
    private PresentedPetData getMatchAt(int index) {
        GetPotentialMatchesResult result = getPotentialMatchesResult.getValue();

        if (result == null) {
            throw new MatchesNotLoadedException();
        } else {
            List<PresentedPetData> potentialMatches = result.getPotentialMatches();

            return potentialMatches.get(index);
        }
    }

    public LiveData<GetPotentialMatchesResult> getGetPotentialMatchesResult() {
        return getPotentialMatchesResult;
    }

    @Override
    public void onGetPotentialMatchesSuccess(List<PresentedPetData> potentialMatches) {
        getPotentialMatchesResult.setValue(new GetPotentialMatchesResult(potentialMatches));
    }

    @Override
    public void onGetPotentialMatchesFailure(String message) {
        getPotentialMatchesResult.setValue(new GetPotentialMatchesResult(
                true, message));
    }
}
