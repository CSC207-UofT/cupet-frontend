package com.example.cupetfrontend.ui.view_my_pets;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.databinding.FragmentViewMyPetsBinding;
import com.example.cupetfrontend.presenters.abstracts.IGetPetsPresenter;
import com.example.cupetfrontend.presenters.user.GetPetsPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.ICreatePetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IViewMyPetsViewModel;
import com.example.cupetfrontend.ui.MainActivityFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ViewMyPetsFragment extends MainActivityFragment {

    private static final String TAG = "GetPetsActivity";
    private FragmentViewMyPetsBinding binding;

    private RecyclerView recyclerView;
    private CardRecyclerViewAdapter adapter;
    private List<PetModel> petModelList;
    private Button addPetButton;

    @Inject
    public IUserController userController;
    @Inject
    public IGetPetsPresenter getPetsPresenter;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IPetSessionManager petSessionManager;
    @Inject
    public ICreatePetViewModel createPetViewModel;
    @Inject
    public IViewMyPetsViewModel viewMyPetsViewModel;

    public void initializeViews() {
        recyclerView = binding.cardRecyclerView;
        addPetButton = binding.addPetButton;
    }

    /**
     * Setup views and state on creation of the activity.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentViewMyPetsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ((App) getApplicationContext()).getAppComponent().inject(this);

        petModelList = new ArrayList<>();
        initializeViews();

        getPetsPresenter.setGetPetsViewModel(viewMyPetsViewModel);
        viewMyPetsViewModel.getPets(sessionManager.getToken());

        setUpObserveGetPetsResult();
        initCardRecyclerView();
        setUpAddPetButtonListener();
        setUpEditBtn();
        attachToActivityCreate();

        return root;
    }

    private void attachToActivityCreate() {
        getMainActivity().getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public void onCreate() {
                if (viewMyPetsViewModel.getContext() != null &&
                        viewMyPetsViewModel.getContext().isFromLoginPage()){
                    getMainActivity().hideNavigation();
                }

                getMainActivity().getLifecycle().removeObserver(this);
            }
        });
    }

    private void initCardRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        adapter = new CardRecyclerViewAdapter(getContext(), petSessionManager,
                getMainActivity(),createPetViewModel, viewMyPetsViewModel);
        adapter.setPetModels(petModelList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new GridLayoutManager(getContext(), 2)));
    }

    private void setUpAddPetButtonListener(){
        addPetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Add Pet", Toast.LENGTH_SHORT).show();
                getMainActivity().navigate(R.id.nav_create_pet);
            }
        });
    }

    /**
     * Set up this activity as an observer that observes the result of getting pets.
     *
     * Update the displayed views when the get pets result has changed.
     */
    private void setUpObserveGetPetsResult() {
        viewMyPetsViewModel.getPetsResult().observe(getViewLifecycleOwner(), new Observer<GetPetsResult>() {
            @Override
            public void onChanged(@Nullable GetPetsResult getPetsResult) {
                Log.d(TAG, "onChanged: setUpObserveGetPetsResult");
                if (getPetsResult == null) {
                    return;
                }
                if (getPetsResult.isError()){
                    Log.e(TAG, "onChanged: get pets result Error ");
                    onGetPetsFailure(getPetsResult.getErrorMessage());
                }else{
                    Log.d(TAG, "onChanged: get pets result success");
                    onGetPetsSuccess(getPetsResult.getPets());
                }
            }
        });
    }

    /**
     * Get Pets Success toast message
     * Notify adapter for RecyclerView
     */
    private void onGetPetsSuccess(List<PetModel> userPets) {
        Log.d(TAG, "onGetPetsSuccess: success - pets:" + userPets);
        Toast.makeText(getApplicationContext(), "Get Pets Success", Toast.LENGTH_SHORT).show();

        petModelList.clear();
        petModelList.addAll(userPets);
        adapter.notifyDataSetChanged();
    }

    /**
     * Display a Get Pets failed toast message.
     * Notify adapter for RecyclerView.
     * @param errorMessage The error message to display
     */
    private void onGetPetsFailure (String errorMessage) {
        Log.e(TAG, "onGetPetsFailure: Get pets Failure");
        System.out.println("GetPets failed");
        Toast.makeText(getApplicationContext(), "Get pets failed: " + errorMessage, Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }

    /**
     * Hide the appbar edit button by default.
     */
    private void setUpEditBtn() {
        getMainActivity().hideEditButton();
    }
}