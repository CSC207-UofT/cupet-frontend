package com.example.cupetfrontend.ui.get_matches;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.databinding.FragmentGetMatchesBinding;

import com.example.cupetfrontend.presenters.pet.GetMatchesPresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;


import java.util.ArrayList;
import java.util.List;

/**
 * The activity for the Get Matches page.
 */
public class GetMatchesFragment extends MainActivityFragment {
    private static final String TAG = "NewGetMatchesActivity";

    private FragmentGetMatchesBinding binding;

    //vars
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private GetMatchesViewModel getMatchesViewModel;
    private List<PetModel> petModelList = new ArrayList<>();
    private ArrayList<PetModel> dataSet = new ArrayList<>();  // for testing

    private void initializeViews() {
        recyclerView = binding.recyclerView;
    }

    /**
     * Setup views and state on creation of the fragment.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentGetMatchesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Log.d(TAG, "onCreate: started.");
        initializeDependencySelector();
        initializeViews();

        initViewModel();

        getMatchesViewModel.getMatches(dependencySelector.getSessionManager().getToken(),
                dependencySelector.getPetSessionManager().getPetId());

        setUpObserveGetMatchesResult();
        initRecyclerView();
        setUpBtn();

        return root;

    }

    private void initViewModel() {
        IPetController petController = dependencySelector.getControllers().getPetController();
        GetMatchesPresenter getMatchesPresenter = dependencySelector.getPetPresenters().getGetMatchesPresenter();
        getMatchesViewModel = new GetMatchesViewModel(petController);
        getMatchesPresenter.setGetMatchesViewModel(getMatchesViewModel);
    }


    // method for actually setting up our recycler view
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        adapter = new RecyclerViewAdapter(getContext(), petModelList);
        Log.d(TAG, "initRecyclerView: got adapter");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /**
     * Set up this activity as an observer that observes the result of getting matches.
     *
     * Update the displayed views when the get matches result has changed.
     */
    private void setUpObserveGetMatchesResult() {
        getMatchesViewModel.getMatchesResult().observe(getViewLifecycleOwner(),
                new Observer<GetMatchesResult>() {
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

    /**
     * Hide the appbar edit button
     */
    public void setUpBtn () {
        getMainActivity().hideEditButton();
    }
}
