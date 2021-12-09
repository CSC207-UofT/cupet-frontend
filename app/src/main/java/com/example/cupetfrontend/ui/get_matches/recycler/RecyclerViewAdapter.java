package com.example.cupetfrontend.ui.get_matches.recycler;

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
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.abstracts.IUnMatchPresenter;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.MatchedPetProfileContext;
import com.example.cupetfrontend.presenters.abstracts.IUnMatchPresenter;
import com.example.cupetfrontend.ui.Navigator;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * An adapter for the RecyclerView of the Get Matches page.
 * This class is responsible for providing a binding from the related data set to views that are
 * displayed within the RecyclerView for the Get Matches page.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private List<PetModel> mPetModels;
    private Context context;
    private GetMatchesRecyclerViewModel viewModel;
    private final IMatchedPetProfileViewModel matchedPetProfileViewModel;
    private final IPetSessionManager petSessionManager;
    private final ISessionManager sessionManager;
    private final IUnMatchPresenter unMatchPresenter;
    private final IPetController petController;
    private Navigator navigator;

    @Inject
    public RecyclerViewAdapter(IMatchedPetProfileViewModel matchedPetProfileViewModel,
                               IPetSessionManager petSessionManager,
                               ISessionManager sessionManager,
                               IUnMatchPresenter unMatchPresenter,
                               IPetController petController) {
        this.matchedPetProfileViewModel = matchedPetProfileViewModel;
        this.petSessionManager = petSessionManager;
        this.sessionManager = sessionManager;
        this.unMatchPresenter = unMatchPresenter;
        this.petController = petController;

        initializeViewModel();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setPetModels(List<PetModel> mPetModels) {
        this.mPetModels = mPetModels;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    private void initializeViewModel() {
        viewModel = new GetMatchesRecyclerViewModel(petController);
        unMatchPresenter.setUnMatchViewModel(viewModel);
    }

    /**
     * Inflates the view. The new ViewHolder is used to display items of the adapter using onBindViewHolder.
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method is responsible for inflating the view
        // Basically recycles the view holders - puts them in position they should be put into
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the RecyclerView.ViewHolder.itemView to reflect the item at the given position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // important method - will change based on our layouts and what they should look like
        Log.d(TAG, "onBindViewHolder: called."); // debugging

        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        loadDataIntoViews(holder);
        setUpDeleteButtonClicked(holder);
        setUpClickedEntry(holder);
    }

    private void loadDataIntoViews(@NotNull ViewHolder holder) {
        String petImgUrl = getPetModelFor(holder).getPetImageUrl();

        if (!petImgUrl.equals("")) {
            Glide.with(context)
                    // tells Glide we it as bitmap
                    .asBitmap()
                    // where we would reference img URLs - resource where img is coming from
                    .load(petImgUrl)
                    // loading image into image view - so reference view holder -> image widget
                    .into(holder.petImage);
        }

        holder.petName.setText(getPetModelFor(holder).getPetName());
        holder.petBreed.setText(getPetModelFor(holder).getPetBreed());
    }

    private void setUpClickedEntry(@NotNull ViewHolder holder) {
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + getPetModelFor(holder)
                        .getPetName());

                Toast.makeText(context, mPetModels.get(
                        holder.getAdapterPosition()).getPetName(), Toast.LENGTH_SHORT).show();

                matchedPetProfileViewModel.setContext(
                        new MatchedPetProfileContext(getPetModelFor(holder)));

                navigator.navigate(R.id.nav_matched_pet_profile);
            }
        });
    }

    private void setUpDeleteButtonClicked(@NotNull ViewHolder holder) {
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: delete" + mPetModels.get(holder.getAdapterPosition()).getPetName());

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.delete_button);
                builder.setMessage("Are you sure you want to delete this pet?");
                builder.setIcon(R.drawable.delete_button);

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "onClick: confirm delete");

                        String otherPetId = getPetModelFor(holder).getPetId();
                        String token = sessionManager.getToken();
                        String myPetId = petSessionManager.getPetId();

                        viewModel.unMatch(token, myPetId, otherPetId);
                        removeAt(holder.getAdapterPosition());

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
    }

    /**
     * Return the instance of PetModel corresponding
     * to a holder
     */
    private PetModel getPetModelFor(ViewHolder holder) {
        return mPetModels.get(holder.getAdapterPosition());
    }

    /**
     * Return the number of items in the list which corresponds to the number of views to be
     * displayed in the RecyclerView
     *
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
        TextView petBreed;
        ImageButton deleteButton;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            petImage = itemView.findViewById(R.id.image);
            petName = itemView.findViewById(R.id.pet_name);
            petBreed = itemView.findViewById(R.id.pet_breed);
            deleteButton = itemView.findViewById(R.id.delete_button);
            parentLayout = itemView.findViewById(R.id.new_get_matches_layout);
        }
    }

    /**
     * Remove an item in the recycler view at position.
     *
     * @param position The position of the item to remove
     */
    public void removeAt(int position) {
        mPetModels.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mPetModels.size());
    }
}
