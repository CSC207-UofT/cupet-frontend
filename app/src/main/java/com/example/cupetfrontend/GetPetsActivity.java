package com.example.cupetfrontend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.user.GetPetsPresenter;

import java.util.ArrayList;
import java.util.List;

public class GetPetsActivity extends AppCompatActivity {

    private static final String TAG = "GetPetsActivity";

    //vars
    private final ArrayList<String> mPetNames = new ArrayList<>();
    private final ArrayList<String> mPetImageUrls = new ArrayList<>();
    private RecyclerView recyclerView;
    private CardRecyclerViewAdapter adapter;
    private GetPetsViewModel getPetsViewModel;
    private ISessionManager sessionManager;
    private List<PetModel> petModelList = new ArrayList<>();
    private ArrayList<PetModel> dataSet = new ArrayList<>(); //testing


    private Button nAddPetButton;

    /**
     * Setup views and state on creation of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);
        Log.d(TAG, "onCreate: started.");

        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IUserController userController = dependencySelector.getControllers().getUserController();
        recyclerView = findViewById(R.id.card_recylcer_view);

        GetPetsPresenter getPetsPresenter = dependencySelector.getUserPresenters().getGetPetsPresenter();
        getPetsViewModel = new GetPetsViewModel(userController);
        getPetsPresenter.setGetPetsViewModel(getPetsViewModel);
        sessionManager = dependencySelector.getSessionManager();

        getPetsViewModel.getPets(sessionManager.getToken());

        setUpObserveGetPetsResult();
        initCardRecyclerView();


        nAddPetButton = findViewById(R.id.add_pet_button);
        setUpAddPetButtonListener();


    }


    // method for actually setting up our recycler view
    private void initCardRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        adapter = new CardRecyclerViewAdapter(this, petModelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new GridLayoutManager(this, 2)));
    }

    private void setUpAddPetButtonListener(){
        nAddPetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Add Pet", Toast.LENGTH_SHORT).show();
                //TODO: Link to Add New Pet Activity
            }
        });
    }

    /**
     * Set up this activity as an observer that observes the result of getting pets.
     *
     * Update the displayed views when the get pets result has changed.
     */
    private void setUpObserveGetPetsResult() {
        getPetsViewModel.getPetsResult().observe(this, new Observer<GetPetsResult>() {
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
        petModelList.addAll(getPetsViewModel.getPetsResult().getValue().getPets());
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