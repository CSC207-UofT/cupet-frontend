package com.example.cupetfrontend.ui.view_my_pets;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.databinding.FragmentViewMyPetsBinding;
import com.example.cupetfrontend.presenters.user.GetPetsPresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewMyPetsFragment extends MainActivityFragment {

    private static final String TAG = "GetPetsActivity";

    private FragmentViewMyPetsBinding binding;

    //vars
    private RecyclerView recyclerView;
    private CardRecyclerViewAdapter adapter;
    private ViewMyPetsViewModel viewMyPetsViewModel;
    private List<PetModel> petModelList = new ArrayList<>();
    private ArrayList<PetModel> dataSet = new ArrayList<>(); //testing
    private Button addPetButton;

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

        initializeViews();
        initializeDependencySelector();
        initializeViewModel();

        viewMyPetsViewModel.getPets(dependencySelector.getSessionManager().getToken());

        setUpObserveGetPetsResult();
        initCardRecyclerView();
        setUpAddPetButtonListener();
        setUpEditBtn();

        return root;
    }

    private void initializeViewModel() {
        IUserController userController = dependencySelector.getControllers().getUserController();

        GetPetsPresenter getPetsPresenter = dependencySelector.getUserPresenters().getGetPetsPresenter();
        viewMyPetsViewModel = new ViewMyPetsViewModel(userController);
        getPetsPresenter.setGetPetsViewModel(viewMyPetsViewModel);
    }


    // method for actually setting up our recycler view
    private void initCardRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        adapter = new CardRecyclerViewAdapter(getContext(), petModelList);
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

    private void testPetModels(){ // test
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

    /**
     * Hide the appbar edit button by default.
     */
    private void setUpEditBtn() {
        getMainActivity().hideEditButton();
    }
}