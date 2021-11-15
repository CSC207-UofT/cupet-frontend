package com.example.cupetfrontend;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import androidx.lifecycle.Observer;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;

import java.util.List;

public class GetMatchesActivity extends AppCompatActivity {

    private GetMatchesViewModel getMatchesViewModel;

    TableLayout matchesTable;

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
            TextView textPetName = new TextView(this);
            textPetName.setText(petName);
            textPetName.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            tr.addView(textPetName); // add text view to row
            // add row to layout
            matchesTable.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    /**
     * Setup views and state on creation of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_matches);
        DependencySelector dependencySelector = ((App) getApplication()).getDependencySelector();
        IPetController petController = dependencySelector.getControllers().getPetController();

        IGetMatchesPresenter getMatchesPresenter = dependencySelector.getPetPresenters().getGetMatchesPresenter();
        getMatchesViewModel = new GetMatchesViewModel(petController);
        getMatchesPresenter.setGetMatchesViewModel(getMatchesViewModel);

        matchesTable = findViewById(R.id.matches_table);

        setUpObserveGetMatchesResult();

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
                if (getMatchesResult == null) {
                    return;
                }

                if (getMatchesResult.isError()){
                    onGetMatchesFailure(getMatchesResult.getErrorMessage());
                }else{
                    onGetMatchesSuccess(getMatchesResult.getMatches());
                }
            }
        });
    }


    /**
     * Display a Registration Success toast message and generate table
     */
    private void onGetMatchesSuccess(List<String> matches) {
        Toast.makeText(getApplicationContext(), "Get Matches Success", Toast.LENGTH_SHORT).show();
        generateTable(matches);
    }

    /**
     * Display a Registration failed toast message.
     * @param errorMessage The error message to display
     */
    private void onGetMatchesFailure (String errorMessage) {
        System.out.println("Registration failed");
        Toast.makeText(getApplicationContext(), "Get Matches failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}