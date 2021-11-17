package com.example.hf7;

        import android.app.Activity;
        import android.content.Context;
        import android.graphics.Color;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.cardview.widget.CardView;
        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;
        import com.google.android.material.transition.platform.MaterialElevationScale;

        import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {
    private Activity mContext;
    private List<Animal> mAnimals;

    public AnimalsAdapter(Activity mContext, List<Animal> mContacts) {
        this.mContext = mContext;
        this.mAnimals = mContacts;
    }

    @NonNull
    @Override
    public AnimalsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_item_layout, parent, false);
        CardView cardView = itemView.findViewById(R.id.animalCardView);
            cardView.setCardBackgroundColor(Color.LTGRAY);
        return new VH(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsAdapter.VH holder, int position) {
        Animal animal = mAnimals.get(position);
        holder.rootView.setTag(animal);

        holder.tvName.setText(animal.getName());
        holder.tvDescription.setText(animal.getDescription());
        holder.tvContent.setText(animal.getContent());
        Glide.with(mContext).load(animal.getThumbnailDrawable()).centerCrop().into(holder.ivPicture);
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        final View rootView;
        final ImageView ivPicture;
        final TextView tvName;
        final TextView tvDescription;
        final TextView tvContent;

        public VH(View itemView, final Context pContext) {
            super(itemView);
            rootView = itemView;
            ivPicture = (ImageView) itemView.findViewById(R.id.animalImageViewID);
            tvName = (TextView) itemView.findViewById(R.id.animalNameViewID);
            tvDescription = (TextView) itemView.findViewById(R.id.animalDescriptionViewID);
            tvContent = (TextView) itemView.findViewById(R.id.animalContentTextViewID);


            itemView.setOnClickListener(v -> {
                final Animal animal = (Animal) v.getTag();
                if (animal != null) {
                    Toast.makeText(pContext.getApplicationContext(), animal.getName(),Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(mContext, DetailsActivity.class);
                    //i.putExtra("EXTRA_CONTACT", contact);
                    //mContext.startActivity(i);
                    // Fire an intent when a contact is selected
                    // Pass contact object in the bundle and populate details activity.
                }
            });
        }
    }
}