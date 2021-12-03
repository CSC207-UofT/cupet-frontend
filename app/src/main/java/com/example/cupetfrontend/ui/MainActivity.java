package com.example.cupetfrontend.ui;

import android.os.Bundle;

import com.example.cupetfrontend.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cupetfrontend.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appBarConfig = new AppBarConfiguration.Builder(
                R.id.nav_potential_matches, R.id.nav_matches,
                R.id.nav_my_pet_profile, R.id.nav_account_settings,
                R.id.nav_my_user_profile
                )
                .setOpenableLayout(binding.mainDrawerLayout)
                .build();

        setSupportActionBar(binding.mainToolbar);

        NavController navController = Navigation.findNavController(
                this, R.id.main_nav_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController,
                appBarConfig);

        NavigationUI.setupWithNavController(binding.drawerNavView, navController);
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,
                R.id.main_nav_fragment);

        return NavigationUI.navigateUp(navController, appBarConfig);
    }

}