package com.example.cupetfrontend;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.dependency_selector.DependencySelector;

import com.example.cupetfrontend.presenters.pet.GetMatchesPresenter;
import com.example.cupetfrontend.use_cases.data_models.PetData;

import java.util.List;

/**
 * The activity for the Get Matches page.
 */
public class NewGetMatchesActivity extends AppCompatActivity{



    private static final String TAG = "NewGetMatchesActivity";

    //vars
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private GetMatchesViewModel getMatchesViewModel;

    /**
     * Setup views and state on creation of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_matches_new);
        Log.d(TAG, "onCreate: started.");

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IPetController petController = dependencySelector.getControllers().getPetController();
        recyclerView = findViewById(R.id.recylcer_view);

        GetMatchesPresenter getMatchesPresenter = dependencySelector.getPetPresenters().getGetMatchesPresenter();
        getMatchesViewModel = new GetMatchesViewModel(petController);
        getMatchesPresenter.setGetMatchesViewModel(getMatchesViewModel);

        getMatchesViewModel.init();

        //setUpObservePetModel(); //for testing
        setUpObserveGetMatchesResult();

        initRecyclerView();

    }


    // method for actually setting up our recycler view
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        //adapter = new RecyclerViewAdapter(this, getMatchesViewModel.getPetModelData().getValue());
        adapter = new RecyclerViewAdapter(this, getMatchesViewModel.getMatchesResult().getValue().getMatches());
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

    private void setUpObservePetModel(){ // for testing
        Log.d(TAG, "setUpObservePetModel: setting up observe pet model");
        getMatchesViewModel.getPetModelData().observe(this, new Observer<List<PetModel>>() {
            @Override
            public void onChanged(@Nullable List<PetModel> petModels) {
                adapter.notifyDataSetChanged();
            }
        });

    }


    /**
     * Get Matches Success toast message
     */
    private void onGetMatchesSuccess(List<PetModel> matches) {
        Log.d(TAG, "onGetMatchesSuccess: success - matches:" + matches);
        Toast.makeText(getApplicationContext(), "Get Matches Success", Toast.LENGTH_SHORT).show();

        adapter.notifyDataSetChanged();
    }

    /**
     * Display a Get Matches failed toast message.
     * @param errorMessage The error message to display
     */
    private void onGetMatchesFailure (String errorMessage) {
        Log.e(TAG, "onGetMatchesFailure: Get Matches Failure");
        System.out.println("Get Matches failed");
        Toast.makeText(getApplicationContext(), "Get Matches failed: " + errorMessage, Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }




}
