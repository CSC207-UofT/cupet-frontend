package com.example.cupetfrontend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.PetSessionManager;
import com.example.cupetfrontend.controllers.SessionManager;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.cached_data_models.CachedUserData;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.splash_screen.SplashScreenActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cupetfrontend.databinding.ActivityMainBinding;

/**
 * This is the main activity of the application which is presented to
 * the user once they have signed in and chosen a pet to sign in as.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfig;
    private int editBtnNavTarget;
    private Menu appBarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Temporarily create some user dummy data
        //  TODO: Offload to the log in step
        DependencySelector dependencySelector = ((App) this.getApplication()).getDependencySelector();
        dependencySelector.getSessionManager().setCachedUserData(new CachedUserData(
                "dummy first", "dummy last", "dummy email",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Jonathan_G_Meath_portrays_" +
                        "Santa_Claus.jpg/800px-Jonathan_G_Meath_portrays_Santa_Claus.jpg"
        ));
        dependencySelector.getSessionManager().setToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2IiwiZXhwIjoxNjM4NzEzMzMwLCJpYXQiOjE2Mzg2NzczMzB9.cwUIBzeQtQj7LzCOE6q44U6uEJ_-NEgZ4xJch7Jn2U4");
        dependencySelector.getPetSessionManager().setPetId("6");

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

        setUpSignOutListener();
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        appBarMenu = menu;
        getMenuInflater().inflate(R.menu.activity_main_appbar_menu, menu);

        // Hide edit button as default behaviour
        hideEditButton();

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,
                R.id.main_nav_fragment);
        attachUserDataToDrawer();

        return NavigationUI.navigateUp(navController, appBarConfig);
    }

    /**
     * Attach the user's data to the drawer
     */
    public void attachUserDataToDrawer(){
        ImageView imgView = findViewById(R.id.drawer_profile_img);
        TextView fullNameView = findViewById(R.id.drawer_full_name);
        TextView emailView = findViewById(R.id.drawer_email);

        DependencySelector dependencySelector = ((App) this.getApplication()).getDependencySelector();
        CachedUserData cachedUserData = dependencySelector.getSessionManager().getCachedUserData();
        String fullName = cachedUserData.getFirstName() + " " + cachedUserData.getLastName();

        fullNameView.setText(fullName);
        emailView.setText(cachedUserData.getEmail());

        Glide.with(this).load(cachedUserData.getProfileImgUrl()).into(imgView);
    }

    private void setUpSignOutListener() {
        Button signOutBtn = binding.signOutBtn;
        DependencySelector dependencySelector = ((App) this.getApplication()).getDependencySelector();
        ISessionManager sessionManager = dependencySelector.getSessionManager();
        IPetSessionManager petSessionManager = dependencySelector.getPetSessionManager();

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.clear();
                petSessionManager.clear();

                Intent moveToSplashIntent = new Intent(
                        MainActivity.this, SplashScreenActivity.class);
                startActivity(moveToSplashIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_appbar_edit) {
            if (editBtnNavTarget != 0) {
                navigate(editBtnNavTarget);
            }

        }else{
            onSupportNavigateUp();
        }

        return true;
    }

    /**
     * Hide the navigation drawer and bottom nav bar
     */
    public void hideNavigation() {
        binding.bottomNavView.setVisibility(View.GONE);
        binding.drawerNavView.setVisibility(View.GONE);
        binding.mainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    /**
     * Show the navigation drawer and bottom nav bar
     */
    public void showNavigation() {
        binding.bottomNavView.setVisibility(View.VISIBLE);
        binding.drawerNavView.setVisibility(View.VISIBLE);
        binding.mainDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    /**
     * Hide the edit action button.
     */
    public void hideEditButton () {
        if (appBarMenu != null) {
            MenuItem item = appBarMenu.findItem(R.id.main_appbar_edit);
            item.setVisible(false);
        }
    }

    /**
     * Show the edit action button.
     */
    public void showEditButton () {
        if (appBarMenu != null) {
            MenuItem item = appBarMenu.findItem(R.id.main_appbar_edit);
            item.setVisible(true);
        }
    }

    /**
     * Navigate to a page defined in mobile_navigation.xml.
     */
    public void navigate (int navTarget) {
        NavController navController = Navigation.findNavController(
                this, R.id.main_nav_fragment);

        navController.navigate(navTarget);
    }

    /**
     * Set the navigation target fragment when the edit button is clicked.
     *
     * Ex. setEditBtnNavTarget(R.id.nav_account_settings);
     */
    public void setEditBtnNavTarget(int navTarget) {
        editBtnNavTarget = navTarget;
    }
}