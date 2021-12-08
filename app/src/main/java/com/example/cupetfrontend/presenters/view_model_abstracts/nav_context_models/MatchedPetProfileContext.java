package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

import com.example.cupetfrontend.data.model.PetModel;

public class MatchedPetProfileContext {
    private final PetModel selectedMatchedPet;

    public MatchedPetProfileContext(PetModel selectedMatchedPet){
        this.selectedMatchedPet = selectedMatchedPet;
    }

    public PetModel getSelectedMatchedPet(){
        return selectedMatchedPet;
    }
}
