package com.example.cupetfrontend.ui.upload_image_fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.databinding.FragmentUploadImageBinding;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUploadImageViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.DataTypeOrigin;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UploadImageContext;
import com.example.cupetfrontend.ui.MainActivityFragment;

import java.io.IOException;

import javax.inject.Inject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

public class UploadImageFragment extends MainActivityFragment {
    @Inject
    public IUploadImageViewModel viewModel;
    private FragmentUploadImageBinding binding;
    private ActivityResultLauncher<Intent> galleryResultLauncher;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpHandleGalleryResponse();
    }

    public void setUpHandleGalleryResponse() {
        galleryResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes

                            if (result.getData().getData() == null) {
                                return;
                            }

                            Uri uri = result.getData().getData();
                            try {
                                Bitmap bitmap = ImgLoader.bitMapFromUri(
                                        getApplicationContext().getContentResolver(), uri);

                                String b64 = ImgLoader.b64FromBitmap(bitmap);

                                viewModel.setImgB64(b64);
                                Glide.with(getMainActivity()).
                                        load(bitmap).into(binding.uploadImgView);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentUploadImageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        getApplicationContext().getAppComponent().inject(this);

        setUpClickedListener();
        setUpPrefillImageObserver();

        return root;
    }

    public void setUpClickedListener() {
        binding.uploadImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

                galleryResultLauncher.launch(intent);
            }
        });
    }

    public void setUpPrefillImageObserver() {
        viewModel.getContext().observe(getViewLifecycleOwner(), new Observer<UploadImageContext>() {
            @Override
            public void onChanged(UploadImageContext uploadImageContext) {
                prefillImage(uploadImageContext.getDataTypeOrigin(),
                        uploadImageContext.getPrefillImgUrl());
            }
        });
    }

    public void prefillImage(DataTypeOrigin origin, String prefillImgUrl) {
        if (prefillImgUrl.equals("")) {
            switch (origin) {
                case USER:
                    binding.uploadImgView.setImageResource(R.drawable.default_profile_img);
                    break;
                case PET:
                    binding.uploadImgView.setImageResource(R.drawable.default_pet_profile_img);
            }
        } else {
            Glide.with(getMainActivity()).
                    load(prefillImgUrl).into(binding.uploadImgView);
        }

    }
}
