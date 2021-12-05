package com.example.cupetfrontend.ui.get_matches;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.dependency_selector.DependencySelector;

import com.example.cupetfrontend.presenters.pet.GetMatchesPresenter;


import java.util.ArrayList;
import java.util.List;

/**
 * The activity for the Get Matches page.
 */
public class GetMatchesActivity extends AppCompatActivity{



    private static final String TAG = "NewGetMatchesActivity";

    //vars
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private GetMatchesViewModel getMatchesViewModel;
    private IPetSessionManager petSessionManager;
    private ISessionManager sessionManager;
    private List<PetModel> petModelList = new ArrayList<>();
    private ArrayList<PetModel> dataSet = new ArrayList<>();  // for testing

    /**
     * Setup views and state on creation of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_matches);
        Log.d(TAG, "onCreate: started.");

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IPetController petController = dependencySelector.getControllers().getPetController();
        recyclerView = findViewById(R.id.recylcer_view);

        GetMatchesPresenter getMatchesPresenter = dependencySelector.getPetPresenters().getGetMatchesPresenter();
        getMatchesViewModel = new GetMatchesViewModel(petController);
        getMatchesPresenter.setGetMatchesViewModel(getMatchesViewModel);
        sessionManager = dependencySelector.getSessionManager();
        petSessionManager = dependencySelector.getPetSessionManager();

        getMatchesViewModel.getMatches(sessionManager.getToken(), petSessionManager.getPetId());

        setUpObserveGetMatchesResult();
        initRecyclerView();

        // dummy data
        //testPetModels();
        //getMatchesViewModel.onGetMatchesSuccess(dataSet);

    }


    // method for actually setting up our recycler view
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        adapter = new RecyclerViewAdapter(this, petModelList);
        Log.d(TAG, "initRecyclerView: got adapter");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Set up this activity as an observer that observes the result of getting matches.
     *
     * Update the displayed views when the get matches result has changed.
     */
    private void setUpObserveGetMatchesResult() {
        getMatchesViewModel.getMatchesResult().observe(this, new Observer<GetMatchesResult>() {
            @Override
            public void onChanged(@Nullable GetMatchesResult getMatchesResult) {
                Log.d(TAG, "onChanged: setUpObserveGetMatchesResult");
                if (getMatchesResult == null) {
                    return;
                }
                if (getMatchesResult.isError()){
                    Log.e(TAG, "onChanged: get matches result Error ");
                    onGetMatchesFailure(getMatchesResult.getErrorMessage());
                }else{
                    Log.d(TAG, "onChanged: get matches result success");
                    onGetMatchesSuccess(getMatchesResult.getMatches());
                }
            }
        });
    }

    /**
     * Get Matches Success toast message
     * Notify adapter for RecyclerView
     */
    private void onGetMatchesSuccess(List<PetModel> matches) {
        Log.d(TAG, "onGetMatchesSuccess: success - matches:" + matches);
        Toast.makeText(getApplicationContext(), "Get Matches Success", Toast.LENGTH_SHORT).show();
        petModelList.addAll(getMatchesViewModel.getMatchesResult().getValue().getMatches());
        adapter.notifyDataSetChanged();
    }

    /**
     * Display a Get Matches failed toast message.
     * Notify adapter for RecyclerView.
     * @param errorMessage The error message to display
     */
    private void onGetMatchesFailure (String errorMessage) {
        Log.e(TAG, "onGetMatchesFailure: Get Matches Failure");
        System.out.println("Get Matches failed");
        Toast.makeText(getApplicationContext(), "Get Matches failed: " + errorMessage, Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }

    private void testPetModels(){
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

    }
}
