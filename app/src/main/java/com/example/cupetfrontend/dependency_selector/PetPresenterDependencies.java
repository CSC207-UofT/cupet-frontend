package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.pet.*;

public class PetPresenterDependencies {
    // TODO: Replace all with abstract presenter types
    private CreatePetPresenter createPetPresenter;
    private EditPetPresenter editPetPresenter;
    private FetchPetProfilePresenter fetchPetProfilePresenter;
    private GetMatchesPresenter getMatchesPresenter;
    private GetPotentialMatchesPresenter getPotentialMatchesPresenter;
    private IntendToMatchPresenter intendToMatchPresenter;
    private RejectMatchPresenter rejectMatchPresenter;
    private UnMatchPresenter unMatchPresenter;
    private SetPetProfileImagePresenter setPetProfileImagePresenter;
    private AddToPetImageGalleryPresenter addToPetImageGalleryPresenter;
    private RemoveFromPetImageGalleryPresenter removeFromPetImageGalleryPresenter;
    private FetchPetProfileImagePresenter fetchPetProfileImagePresenter;

    public PetPresenterDependencies() {
        selectCreatePetPresenter();
        selectGetPotentialMatchesPresenter();
        selectEditPetPresenter();
        selectFetchPetProfilePresenter();
        selectGetMatchesPresenter();
        selectIntendToMatchPresenter();
        selectRejectMatchPresenter();
        selectSetPetProfileImagePresenter();
        selectAddToPetImageGalleryPresenter();
        selectRemoveFromPetImageGalleryPresenter();
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

    private void selectUnMatchPresenter() {
        unMatchPresenter = new UnMatchPresenter();
    }

    private void selectSetPetProfileImagePresenter() {
        unMatchPresenter = new UnMatchPresenter();
    }

    private void selectAddToPetImageGalleryPresenter() {
        addToPetImageGalleryPresenter = new AddToPetImageGalleryPresenter();
    }

    private void selectRemoveFromPetImageGalleryPresenter() {
        removeFromPetImageGalleryPresenter = new RemoveFromPetImageGalleryPresenter();
    }

    private void selectFetchPetProfileImagePresenter () {
        fetchPetProfileImagePresenter = new FetchPetProfileImagePresenter();
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

    public UnMatchPresenter getUnMatchPresenter() {
        return unMatchPresenter;
    }

    public SetPetProfileImagePresenter getSetPetProfileImagePresenter() {
        return setPetProfileImagePresenter;
    }

    public AddToPetImageGalleryPresenter getAddToPetImageGalleryPresenter() {
        return addToPetImageGalleryPresenter;
    }

    public RemoveFromPetImageGalleryPresenter getRemoveFromPetImageGalleryPresenter() {
        return removeFromPetImageGalleryPresenter;
    }

    public FetchPetProfileImagePresenter getFetchPetProfileImagePresenter() {
        return fetchPetProfileImagePresenter;
    }
}
