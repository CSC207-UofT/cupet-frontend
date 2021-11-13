package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.pet.*;

public class PetPresenterDependencies {
    private CreatePetPresenter createPetPresenter;
    private EditPetPresenter editPetPresenter;
    private FetchPetProfilePresenter fetchPetProfilePresenter;
    private GetMatchesPresenter getMatchesPresenter;
    private GetPotentialMatchesPresenter getPotentialMatchesPresenter;
    private IntendToMatchPresenter intendToMatchPresenter;
    private RejectMatchPresenter rejectMatchPresenter;

    public PetPresenterDependencies() {
        selectCreatePetPresenter();
        selectGetPotentialMatchesPresenter();
        selectEditPetPresenter();
        selectFetchPetProfilePresenter();
        selectGetMatchesPresenter();
        selectIntendToMatchPresenter();
        selectRejectMatchPresenter();
    }

    private void selectCreatePetPresenter(){
        createPetPresenter = new CreatePetPresenter();
    }

    private void selectEditPetPresenter(){
        editPetPresenter = new EditPetPresenter();
    }

    private void selectFetchPetProfilePresenter(){
        fetchPetProfilePresenter = new FetchPetProfilePresenter();
    }

    private void selectGetMatchesPresenter(){
        getMatchesPresenter = new GetMatchesPresenter();
    }

    private void selectGetPotentialMatchesPresenter(){
        getPotentialMatchesPresenter = new GetPotentialMatchesPresenter();
    }

    private void selectIntendToMatchPresenter(){
        intendToMatchPresenter = new IntendToMatchPresenter();
    }

    private void selectRejectMatchPresenter(){
        rejectMatchPresenter = new RejectMatchPresenter();
    }

    public CreatePetPresenter getCreatePetPresenter() {
        return createPetPresenter;
    }

    public EditPetPresenter getEditPetPresenter() {
        return editPetPresenter;
    }

    public FetchPetProfilePresenter getFetchPetProfilePresenter() {
        return fetchPetProfilePresenter;
    }

    public GetMatchesPresenter getGetMatchesPresenter() {
        return getMatchesPresenter;
    }

    public GetPotentialMatchesPresenter getGetPotentialMatchesPresenter() {
        return getPotentialMatchesPresenter;
    }

    public IntendToMatchPresenter getIntendToMatchPresenter() {
        return intendToMatchPresenter;
    }

    public RejectMatchPresenter getRejectMatchPresenter() {
        return rejectMatchPresenter;
    }
}
