package com.example.cupetfrontend;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;


import java.util.List;

public class GetMatchesActivity extends AppCompatActivity {

    private GetMatchesViewModel getMatchesViewModel;

    final TableLayout matchesTable = findViewById(R.id.matches_table);

    /**
     * Generate a table containing a list of pet names that have been successfully matched
     * @param matches a list of the names of all matched pets
     */

    private void generateTable(List<String> matches){
        for (String petName : matches) {
            // create new row
            final TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            // create TextView to display pet name
            TextView et1 = new TextView(this);
            et1.setText(petName);
            et1.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            tr.addView(et1); // add tet view to row
            // create new button
            Button contactInfoButton = new Button(this);
            contactInfoButton.setText(R.string.contact_info);
            contactInfoButton.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            contactInfoButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //TODO: Obtain and direct to Contact info page for specified pet's owner
                }
            });
            // add button to row
            tr.addView(contactInfoButton);
            // add row to layout
            matchesTable.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_matches);
        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IPetController petController = dependencySelector.getControllers().getPetController();

        IGetMatchesPresenter getMatchesPresenter = dependencySelector.getPetPresenters().getGetMatchesPresenter();
        getMatchesViewModel = new GetMatchesViewModel(petController);
        getMatchesPresenter.setGetMatchesViewModel(getMatchesViewModel);
        //TODO: generate table if get matches is successful




//        getMatchesViewModel.onGetMatchesSuccess();
//        generateTable(matches);

    }


    //TODO: Observe if result of get matches is successful
//    /**
//     * Set up this activity as an observer that observes the result of getting matches.
//     *
//     * Update the displayed views when the  has changed.
//     */
//    private void setUpObserveGetPetsResult() {
//        getMatchesViewModel.getMatchesResult().observe(this, new Observer<>() {
//            @Override
//            public void onChanged(@Nullable ) {
//                if (result == null) {
//                    return;
//                }
//
//                if (result.isError()){
//                    onGetMatchesFailure(result.getErrorMessage());
//                }else{
//                    onGetMatchesSuccess();
//                }
//
//            }
//        });
//    }




}