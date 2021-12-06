package com.example.cupetfrontend.ui.public_pet_profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.databinding.FragmentPublicPetProfileBinding;
import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.ui.MainActivityFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PublicPetProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PublicPetProfileFragment extends MainActivityFragment {

    private PublicPetProfileViewModel publicPetProfileViewModel;
    private FragmentPublicPetProfileBinding binding;


//    public PublicPetProfileFragment() {
//        // Required empty public constructor
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentPublicPetProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initializeDependencySelector();

        IPetController petController = dependencySelector.getControllers().getPetController();
        IUserController userController = dependencySelector.getControllers().getUserController();
        IFetchPetProfilePresenter fetchPetProfilePresenter = dependencySelector.getPetPresenters().getFetchPetProfilePresenter();
        //IFetchUserProfilePresenter fetchUserProfilePresenter = dependencySelector.getUserPresenters().getFetchUserProfilePresenter();

        publicPetProfileViewModel = new PublicPetProfileViewModel(petController, userController);
        fetchPetProfilePresenter.setPetProfileViewModel(publicPetProfileViewModel);
        // fetchUserProfilePresenter.setUserProfileViewModel(publicPetProfileViewModel);

        ISessionManager sessionManager = dependencySelector.getSessionManager();
        String token = sessionManager.getToken();

        return root;

    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PublicPetProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PublicPetProfileFragment newInstance(String param1, String param2) {
        PublicPetProfileFragment fragment = new PublicPetProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


}