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
import com.bumptech.glide.request.RequestOptions;
import com.example.cupetfrontend.data.model.PetModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * An adapter for the RecyclerView of the Get Matches page.
 * This class is responsible for providing a binding from the related data set to views that are
 * displayed within the RecyclerView for the Get Matches page.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";


    private List<PetModel> mPetModels = new ArrayList<>();
    private final Context mContext;


    public RecyclerViewAdapter(Context mContext, List<PetModel> mPetModels) {
        this.mContext = mContext;
        this.mPetModels = mPetModels;
    }

    /**
     * Inflates the view. The new ViewHolder is used to display items of the adapter using onBindViewHolder.
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method is responsible for inflating the view
        // Basically recycles the view holders - puts them in position they should be put into
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the RecyclerView.ViewHolder.itemView to reflect the item at the given position.
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // important method - will change based on our layouts and what they should look like
        Log.d(TAG, "onBindViewHolder: called."); // debugging

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                // tells Glide we it as bitmap
                .asBitmap()
                // where we would reference img URLs - resource where img is coming from
                .load(mPetModels.get(holder.getAdapterPosition()).getPetImageUrl())
                // loading image into image view - so reference view holder -> image widget
                .into(holder.petImage);

        holder.petName.setText(mPetModels.get(holder.getAdapterPosition()).getPetName());
        //holder.petType.setText(mPetModels.get(holder.getAdapterPosition()).getPetId());
        holder.petBreed.setText(mPetModels.get(holder.getAdapterPosition()).getPetBreed());
        // Create OnClick listener to observe if delete button for the matched pet is clicked
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: delete" + mPetModels.get(holder.getAdapterPosition()).getPetName());

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
        // set on click listener for each view in the RecyclerView.
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + mPetModels.get(holder.getAdapterPosition()).getPetName());

                Toast.makeText(mContext, mPetModels.get(holder.getAdapterPosition()).getPetName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // tells adapter how many list items are in the list

    /**
     * Return the number of items in the list which corresponds to the number of views to be
     * displayed in the RecyclerView
     * @return the number of items in the list mPetNames
     */
    @Override
    public int getItemCount() {
        return mPetModels.size();
    }

    /**
     * Describes an item view and metadata about its place within the RecyclerView
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView petImage;
        TextView petName;
        //TextView petType;
        TextView petBreed;
        ImageButton deleteButton;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.image);
            petName = itemView.findViewById(R.id.pet_name);
            //petType = itemView.findViewById(R.id.pet_type);
            petBreed = itemView.findViewById(R.id.pet_breed);
            deleteButton = itemView.findViewById(R.id.delete_button);
            parentLayout = itemView.findViewById(R.id.new_get_matches_layout);
        }
    }

}
