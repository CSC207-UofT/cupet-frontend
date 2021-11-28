package com.example.cupetfrontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ViewPetsActivity extends AppCompatActivity {

    private static final String TAG = "NewGetMatchesActivity";

    //vars
    private final ArrayList<String> mPetNames = new ArrayList<>();
    private final ArrayList<String> mPetImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps(); // gets the bitmaps
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mPetImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/18/Dog_Breeds.jpg");
        mPetNames.add("Doggo A");

        mPetImageUrls.add("https://cdn.pixabay.com/photo/2020/11/12/15/43/japanese-spitz-5735829_1280.jpg");
        mPetNames.add("Doggo B");

        mPetImageUrls.add("https://assets.jamcity.com/20210419054719/snoopy-pop-illustration-icon-bottom-right.png");
        mPetNames.add("Snoopy");

        mPetImageUrls.add("https://live.staticflickr.com/3373/3600836516_ab924c6729_b.jpg");
        mPetNames.add("Dogster");

//
//        mPetImageUrls.add("https://static.im-a-puzzle.com/gallery/Animals/Cats/Black-cat-watching.jpg");
//        mPetNames.add("Caterson");
//
//        mPetImageUrls.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cute-cat-photos-1593441022.jpg?crop=0.669xw:1.00xh;0.166xw,0&resize=640:*");
//        mPetNames.add("Kitten");
//
//
//        mPetImageUrls.add("https://cms.bbcearth.com/sites/default/files/2021-01/rein1.jpg");
//        mPetNames.add("Reindeer");
//
//        mPetImageUrls.add("https://i.pinimg.com/originals/c9/b4/65/c9b46554f9e672374a93dc81ebd799ab.jpg");
//        mPetNames.add("Albert");
//
//        mPetImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIDYmgpoRu2NgmDdD34Wzl5FP6fbUOsFK0ixcHVIwPRMnez8wIPDphMdxHGCMza4WIB8s&usqp=CAU");
//        mPetNames.add("Scoob");

        initRecyclerView(); // once it has img urls, it initializes the recycler view
    }

    // method for actually setting up our recycler view
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.card_recylcer_view);
        CardRecyclerViewAdapter adapter = new CardRecyclerViewAdapter(this, mPetNames, mPetImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new GridLayoutManager(this, 2)));
    }


}