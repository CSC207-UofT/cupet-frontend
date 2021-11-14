package com.example.cupetfrontend;

import android.view.ViewGroup;
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
import com.example.cupetfrontend.use_cases.response_models.PetData;

import java.util.List;

public class GetMatchesActivity extends AppCompatActivity {
    final TableLayout matchesTable = findViewById(R.id.matches_table);


    private void generateTable(List<PetData> matches){
        for (PetData match : matches) {
            // create new row
            final TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            // create TextView to display pet name
            TextView et1 = new TextView(this);
            String petName = match.getName();
            et1.setText(petName);
            et1.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            tr.addView(et1); // add tet view to row
            // create new button
            Button contactInfoButton = new Button(this);
            contactInfoButton.setText(R.string.contact_info);
            contactInfoButton.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            contactInfoButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //TODO: Direct to Contact info page for specified pet's owner
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
    }
}