package com.example.cupetfrontend.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.dependency_selector.DependencySelector;

/**
 * A superclass fragment for pages in MainActivity
 */
public class MainActivityFragment extends Fragment {
    public DependencySelector dependencySelector;

    /**
     * Return the MainActivity instance attached to the fragment.
     */
    public MainActivity getMainActivity() {
        MainActivity mainActivity = (MainActivity) getActivity();

        if (mainActivity == null){
            throw new InvalidMainActivityFragmentException();
        }

        return mainActivity;
    }

    /**
     * Return the Application instance attached to the fragment.
     */
    public App getApplicationContext() {
        return (App) getMainActivity().getApplicationContext();
    }

    /**
     * Initialize the dependency selector provided that the fragment
     * exists under an instance of MainActivity.
     */
    public void initializeDependencySelector () {
        MainActivity mainActivity = getMainActivity();

        dependencySelector = ((App) mainActivity.getApplication()).getDependencySelector();
    }
}
