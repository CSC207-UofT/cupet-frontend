package com.example.cupetfrontend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private final ArrayList<String> mPetNames;
    private final ArrayList<String> mPetImages;
    private final Context mContext;

    public CardRecyclerViewAdapter(Context mContext, ArrayList<String> mPetNames, ArrayList<String> mPetImages) {
        this.mContext = mContext;
        this.mPetNames = mPetNames;
        this.mPetImages = mPetImages;
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

        Glide.with(mContext)
                // tells Glide we it as bitmap
                .asBitmap()
                // where we would reference img URLs - resource where img is coming from
                .load(mPetImages.get(holder.getAdapterPosition()))
                // loading image into image view - so reference view holder -> image widget
                .into(holder.petImage);
        holder.petName.setText(mPetNames.get(holder.getAdapterPosition()));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + mPetNames.get(holder.getAdapterPosition()));

                Toast.makeText(mContext, mPetNames.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // tells adapter how many list items are in the list
    @Override
    public int getItemCount() {
        return mPetNames.size();
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
