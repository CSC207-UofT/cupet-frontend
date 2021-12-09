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
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.controllers.cached_data_models.CachedUserData;
import com.example.cupetfrontend.presenters.abstracts.IFetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IFetchUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UserProfileContext;
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

import javax.inject.Inject;

/**
 * This is the main activity of the application which is presented to
 * the user once they have signed in and chosen a pet to sign in as.
 */
public class MainActivity extends AppCompatActivity implements Navigator {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfig;
    private int editBtnNavTarget;
    private Menu appBarMenu;

    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IPetSessionManager petSessionManager;
    @Inject
    public IUserController userController;
    @Inject
    public IFetchUserProfilePresenter fetchUserProfilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplicationContext()).getAppComponent().inject(this);

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

        fetchUserProfile();

        setUpSignOutListener();
    }

    private void fetchUserProfile() {
        fetchUserProfilePresenter.setViewModel(new IFetchUserProfileViewModel() {
            @Override
            public void onFetchUserProfileSuccess(UserProfileData userProfileData) {
                sessionManager.setCachedUserData(new CachedUserData(
                        userProfileData.getFirstName(),
                        userProfileData.getLastName(),
                        userProfileData.getEmail(),
                        userProfileData.getProfileImgUrl()));
            }

            @Override
            public void onFetchUserProfileFailure(String message) {
                Toast.makeText(getApplicationContext(),
                        "Fetch user profile failed " + message, Toast.LENGTH_SHORT).show();
            }
        });

        userController.fetchUserProfile(
                sessionManager.getToken(), sessionManager.getUserId());
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
    public void attachUserDataToDrawer() {
        ImageView imgView = findViewById(R.id.drawer_profile_img);
        TextView fullNameView = findViewById(R.id.drawer_full_name);
        TextView emailView = findViewById(R.id.drawer_email);

        CachedUserData cachedUserData = sessionManager.getCachedUserData();
        String fullName = cachedUserData.getFirstName() + " " + cachedUserData.getLastName();

        fullNameView.setText(fullName);
        emailView.setText(cachedUserData.getEmail());

        if (!cachedUserData.getProfileImgUrl().equals("")) {
            Glide.with(this).load(cachedUserData.getProfileImgUrl()).into(imgView);
        }
    }

    private void setUpSignOutListener() {
        Button signOutBtn = binding.signOutBtn;

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

        } else {
            onSupportNavigateUp();
        }

        return true;
    }

    /**
     * Hide the navigation drawer and bottom nav bar
     */
    @Override
    public void hideNavigation() {
        binding.bottomNavView.setVisibility(View.GONE);
        binding.drawerNavView.setVisibility(View.GONE);
        binding.mainAppbar.setVisibility(View.GONE);
    }

    /**
     * Show the navigation drawer and bottom nav bar
     */
    @Override
    public void showNavigation() {
        binding.bottomNavView.setVisibility(View.VISIBLE);
        binding.drawerNavView.setVisibility(View.VISIBLE);
        binding.mainAppbar.setVisibility(View.VISIBLE);
    }

    /**
     * Hide the edit action button.
     */
    public void hideEditButton() {
        if (appBarMenu != null) {
            MenuItem item = appBarMenu.findItem(R.id.main_appbar_edit);
            item.setVisible(false);
        }
    }

    /**
     * Show the edit action button.
     */
    public void showEditButton() {
        if (appBarMenu != null) {
            MenuItem item = appBarMenu.findItem(R.id.main_appbar_edit);
            item.setVisible(true);
        }
    }

    @Override
    public void navigate(int navTarget) {
        NavController navController = Navigation.findNavController(
                this, R.id.main_nav_fragment);

        navController.navigate(navTarget);
    }

    /**
     * Get the current page navigated to.
     * <p>
     * If no such page is found, return -1.
     */
    @Override
    public int getCurrentPage() {
        NavController navController = Navigation.findNavController(
                this, R.id.main_nav_fragment);

        if (navController.getCurrentDestination() != null) {
            return navController.getCurrentDestination().getId();
        } else {
            return -1;
        }
    }


    /**
     * Set the navigation target fragment when the edit button is clicked.
     * <p>
     * Ex. setEditBtnNavTarget(R.id.nav_account_settings);
     */
    public void setEditBtnNavTarget(int navTarget) {
        editBtnNavTarget = navTarget;
    }
}