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
}
