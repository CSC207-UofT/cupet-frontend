package com.example.cupetfrontend;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.cupetfrontend.ui.main.SectionsPagerAdapter;
import com.example.cupetfrontend.databinding.ActivityUserPetsV2Binding;

public class UserPetsV2 extends AppCompatActivity {
    private Button button;
    private Button slot1_button;
    private ActivityUserPetsV2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserPetsV2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        button = (Button) findViewById(R.id.account_settings_button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSettingsActivity();
            }
                                  }

        );

    }
    public void openSettingsActivity(){
        Intent int1 = new Intent(this, AccountSettingsActivity.class);
        startActivity(int1);
    }

}