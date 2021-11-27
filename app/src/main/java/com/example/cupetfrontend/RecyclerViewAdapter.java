package com.example.cupetfrontend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private final ArrayList<String> mPetNames;
    private final ArrayList<String> mPetImages;
    private final ArrayList<String> mPetTypes;
    private final ArrayList<String> mPetBreeds;
    private final Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mPetNames, ArrayList<String> mPetImages, ArrayList<String> mPetTypes, ArrayList<String> mPetBreeds) {
        this.mContext = mContext;
        this.mPetNames = mPetNames;
        this.mPetImages = mPetImages;
        this.mPetTypes = mPetTypes;
        this.mPetBreeds = mPetBreeds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method is responsible for inflating the view
        // Basically recycles the view holders - puts them in position they should be put into
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
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
        holder.petType.setText(mPetTypes.get(holder.getAdapterPosition()));
        holder.petBreed.setText(mPetBreeds.get(holder.getAdapterPosition()));
        // Create OnClick listener to observe if delete button for the matched pet is clicked
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: delete" + mPetNames.get(holder.getAdapterPosition()));

                Toast.makeText(mContext, "delete pet", Toast.LENGTH_SHORT).show();

                // Create Alert Dialog to prompt user to confirm action to delete the matched pet
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle(R.string.delete_button);
                builder.setMessage("Are you sure you want to delete this pet?");
                builder.setIcon(R.drawable.ic_launcher_foreground); //change icon
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: confirm delete");
                        // TODO: Delete from the list
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: cancel delete");
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

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

        CircleImageView petImage;
        TextView petName;
        TextView petType;
        TextView petBreed;
        ImageButton deleteButton;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.image);
            petName = itemView.findViewById(R.id.pet_name);
            petType = itemView.findViewById(R.id.pet_type);
            petBreed = itemView.findViewById(R.id.pet_breed);
            deleteButton = itemView.findViewById(R.id.delete_button);
            parentLayout = itemView.findViewById(R.id.new_get_matches_layout);
        }
    }
}
