package com.example.cupetfrontend;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;

import java.util.List;


public class GetMatchesViewModel extends ViewModel implements IGetMatchesViewModel {
    private MutableLiveData<GetMatchesResult> getMatchesResult;
    private MutableLiveData<List<PetModel>> mPetModelData;
    private final IPetController petController;
    private TestGetMatchesRepository mRepo;


    public GetMatchesViewModel(IPetController petController) {
        this.petController = petController;
    }

    LiveData<GetMatchesResult> getMatchesResult() {
        return getMatchesResult;
    }


    public void init(){
        if (getMatchesResult != null){
            return;
        }
        mRepo = TestGetMatchesRepository.getInstance();
        mPetModelData = mRepo.getPetModels();
        //getMatchesResult =

    }



    /**
     * Create a new get matches request
     * @param token The token
     * @param myPetId The ID of the pet whose matches are to be displayed
     */
    public void getMatches(String token, String myPetId){
        petController.getMatches(token, myPetId);
    }

    public void fetchPetProfileImage(String token, String petId){
        petController.fetchPetProfileImage(token, petId);
    }

    public LiveData<List<PetModel>> getPetModelData(){
        return mPetModelData;
    }


    @Override
    public void onGetMatchesSuccess(List<PetModel> matches) {
//        for (PetData pet: matches){
//            String token = "abc";
//            fetchPetProfileImage(token, pet.getPetId());
//        }
        GetMatchesResult newGetMatchesResult = new GetMatchesResult(false, matches);
        getMatchesResult.setValue(newGetMatchesResult);
    }

    @Override
    public void onGetMatchesFailure(String message) {
        GetMatchesResult newGetMatchesResult = new GetMatchesResult(true);
        getMatchesResult.setValue(newGetMatchesResult);
    }
}