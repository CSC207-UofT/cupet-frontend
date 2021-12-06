package com.example.cupetfrontend.ui.view_my_pets;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.data.model.PetModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private List<PetModel> mPetModels;
    private final Context mContext;

    public CardRecyclerViewAdapter(Context mContext, List<PetModel> mPetModels) {
        this.mContext = mContext;
        this.mPetModels = mPetModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method is responsible for inflating the view
        // Basically recycles the view holders - puts them in position they should be put into
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_carditem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // important method - will change based on our layouts and what they should look like
        Log.d(TAG, "onBindViewHolder: called."); // debugging

        String petImageUrl = getPetModelFrom(holder).getPetImageUrl();

        if (!petImageUrl.equals("")){
            Glide.with(mContext)
                    // tells Glide we it as bitmap
                    .asBitmap()
                    // where we would reference img URLs - resource where img is coming from
                    .load(petImageUrl)
                    // loading image into image view - so reference view holder -> image widget
                    .into(holder.petImage);
        }

        holder.petName.setText(getPetModelFrom(holder).getPetName());
        setUpHolderClickListener(holder);
    }

    private void setUpHolderClickListener(@NotNull ViewHolder holder) {
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + getPetModelFrom(holder));
                Toast.makeText(mContext, getPetModelFrom(holder).getPetName(), Toast.LENGTH_SHORT).show();

                //TODO: Send to appropriate page for selected pet
            }
        });
    }

    /**
     * Return the pet model associated with a view holder.
     */
    private PetModel getPetModelFrom(@NonNull ViewHolder holder) {
        return mPetModels.get(holder.getAdapterPosition());
    }


    // tells adapter how many list items are in the list
    /**
     * Return the number of items in the list which corresponds to the number of views to be
     * displayed in the RecyclerView
     * @return the number of items in the list mPetModels
     */
    @Override
    public int getItemCount() {
        return mPetModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView petImage;
        TextView petName;

        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.card_pet_image);
            petName = itemView.findViewById(R.id.card_pet_name);

            parentLayout = itemView.findViewById(R.id.view_pets_card_layout);
        }
    }
}
