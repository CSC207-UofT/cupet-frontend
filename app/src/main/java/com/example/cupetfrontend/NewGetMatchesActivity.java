package com.example.cupetfrontend;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NewGetMatchesActivity extends AppCompatActivity{

    private GetMatchesViewModel getMatchesViewModel;

    private static final String TAG = "NewGetMatchesActivity";

    //vars
    private final ArrayList<String> mPetNames = new ArrayList<>();
    private final ArrayList<String> mPetImageUrls = new ArrayList<>();
    private final ArrayList<String> mPetTypes = new ArrayList<>();
    private final ArrayList<String> mPetBreeds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_matches_new);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps(); // gets the bitmaps


    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mPetImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/18/Dog_Breeds.jpg");
        mPetNames.add("Doggo A");
        mPetTypes.add("Dog");
        mPetBreeds.add("Breed");

        mPetImageUrls.add("https://cdn.pixabay.com/photo/2020/11/12/15/43/japanese-spitz-5735829_1280.jpg");
        mPetNames.add("Doggo B");
        mPetTypes.add("Dog");
        mPetBreeds.add("Breed");

        mPetImageUrls.add("https://assets.jamcity.com/20210419054719/snoopy-pop-illustration-icon-bottom-right.png");
        mPetNames.add("Snoopy");
        mPetTypes.add("Dog");
        mPetBreeds.add("Breed");

        mPetImageUrls.add("https://live.staticflickr.com/3373/3600836516_ab924c6729_b.jpg");
        mPetNames.add("Dogster");
        mPetTypes.add("Dog");
        mPetBreeds.add("Breed");


        mPetImageUrls.add("https://static.im-a-puzzle.com/gallery/Animals/Cats/Black-cat-watching.jpg");
        mPetNames.add("Caterson");
        mPetTypes.add("Cat");
        mPetBreeds.add("Breed");

        mPetImageUrls.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cute-cat-photos-1593441022.jpg?crop=0.669xw:1.00xh;0.166xw,0&resize=640:*");
        mPetNames.add("Kitten");
        mPetTypes.add("Cat");
        mPetBreeds.add("Breed");


        mPetImageUrls.add("https://cms.bbcearth.com/sites/default/files/2021-01/rein1.jpg");
        mPetNames.add("Reindeer");
        mPetTypes.add("Reindeer");
        mPetBreeds.add("Breed");

        mPetImageUrls.add("https://i.pinimg.com/originals/c9/b4/65/c9b46554f9e672374a93dc81ebd799ab.jpg");
        mPetNames.add("Albert");
        mPetTypes.add("Cat");
        mPetBreeds.add("Breed");

        mPetImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIDYmgpoRu2NgmDdD34Wzl5FP6fbUOsFK0ixcHVIwPRMnez8wIPDphMdxHGCMza4WIB8s&usqp=CAU");
        mPetNames.add("Scoob");
        mPetTypes.add("Doge");
        mPetBreeds.add("Breed");

        initRecyclerView(); // once it has img urls, it initializes the recycler view

    }

    // method for actually setting up our recycler view
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recylcer_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mPetNames, mPetImageUrls, mPetTypes, mPetBreeds);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
