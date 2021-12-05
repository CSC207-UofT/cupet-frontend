package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;


import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetProfileImageSuccessResponseModel;

import java.util.ArrayList;
import java.util.List;

public class GetMatchesPresenter implements GetMatchesOutputBoundary {
    IGetMatchesViewModel getMatchesViewModel;
    private ArrayList<PetModel> dataSet = new ArrayList<>();  // for testing

    public void setGetMatchesViewModel(IGetMatchesViewModel getMatchesViewModel) {
        this.getMatchesViewModel = getMatchesViewModel;
    }

    /**
     * On the successful get pet matches, handover the presented
     * data to the view model.
     *
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onGetMatchesSuccess(GetMatchesSuccessResponseModel response) {
        // create list of names of all matched pets

        ArrayList<PetModel> mPetModels = new ArrayList<>();

        for (PetData pet: response.getMatches()) {
            mPetModels.add(new PetModel(pet.getPetId(), pet.getName(), pet.getAge(), pet.getBreed(), pet.getProfileImgUrl()));

        }
        mPetModels = testPetModels(); // for testing


        getMatchesViewModel.onGetMatchesSuccess(mPetModels);
    }

    /**
     * On the failed get pet matches, handover the presented
     * data to the view model.
     *
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onGetMatchesFailure(DefaultFailureResponseModel response) {
        getMatchesViewModel.onGetMatchesFailure(response.getErrorMessage());

    }


    private ArrayList<PetModel> testPetModels(){
        String id = "id";
        String url1 = "https://upload.wikimedia.org/wikipedia/commons/1/18/Dog_Breeds.jpg";
        String name1 = "Doggo A";
        String age = "age";
        String breed = "Breed";
        dataSet.add(new PetModel(id, name1, age, breed, url1));

        String url2 = "https://cdn.pixabay.com/photo/2020/11/12/15/43/japanese-spitz-5735829_1280.jpg";
        String name2 = "Doggo B";
        dataSet.add(new PetModel(id, name2, age, breed, url2));


        String url3 = "https://assets.jamcity.com/20210419054719/snoopy-pop-illustration-icon-bottom-right.png";
        String name3 = "Snoopy";
        dataSet.add(new PetModel(id, name3, age, breed, url3));

        String url4 = "https://live.staticflickr.com/3373/3600836516_ab924c6729_b.jpg";
        String name4 = "Dogster";
        dataSet.add(new PetModel(id, name4, age, breed, url4));

        String url5 = "https://static.im-a-puzzle.com/gallery/Animals/Cats/Black-cat-watching.jpg";
        String name5 = "Caterson";
        dataSet.add(new PetModel(id, name5, age, breed, url5));

        String url6 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cute-cat-photos-1593441022.jpg?crop=0.669xw:1.00xh;0.166xw,0&resize=640:*";
        String name6 = "Kitten";
        dataSet.add(new PetModel(id, name6, age, breed, url6));

        String url7 = "https://cms.bbcearth.com/sites/default/files/2021-01/rein1.jpg";
        String name7 = "Reindeer";
        dataSet.add(new PetModel(id, name7, age, breed, url7));

        String url8 = "https://i.pinimg.com/originals/c9/b4/65/c9b46554f9e672374a93dc81ebd799ab.jpg";
        String name8 = "Albert";
        dataSet.add(new PetModel(id, name8, age, breed, url8));

        String url9 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIDYmgpoRu2NgmDdD34Wzl5FP6fbUOsFK0ixcHVIwPRMnez8wIPDphMdxHGCMza4WIB8s&usqp=CAU";
        String name9 = "Scoob";

        dataSet.add(new PetModel(id, name9, age, breed, url9));

        return dataSet;
    }

}
