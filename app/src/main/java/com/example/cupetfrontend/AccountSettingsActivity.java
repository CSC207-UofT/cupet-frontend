package com.example.cupetfrontend;

import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.Text;
import android.widget.Toast;

public class AccountSettingsActivity extends AppCompatActivity {
    private TextView distance_text;
    private SeekBar distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        distance_text = (TextView) findViewById(R.id.Distance_textview);
        distance = (SeekBar) findViewById(R.id.Distance_seekBar);

        distance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                distance_text.setText("" + String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        String dist = distance_text.getText().toString();

        AccountSettingsData accountSettingsData = new AccountSettingsData(dist);
        String jsonData = accountSettingsData.toJSON();
        Toast.makeText(getApplicationContext(), jsonData, Toast.LENGTH_SHORT).show();
    }



}