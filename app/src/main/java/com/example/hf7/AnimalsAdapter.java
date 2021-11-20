package com.example.hf7;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.ArrayList;


public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {
    private Activity mContext;
    private ArrayList<Animal> mAnimals;

    public AnimalsAdapter(Activity pContext, ArrayList<Animal> pAnimals) {
        this.mContext = pContext;
        this.mAnimals = pAnimals;
    }

    @NonNull
    @Override
    public AnimalsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_item_layout, parent, false);
        return new VH(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsAdapter.VH holder, int position) {
        Animal animal = mAnimals.get(position);
        holder.rootView.setTag(animal);
        System.out.println(animal.getName()+"\tbound\n");
        holder.tvName.setText(animal.getName());
        holder.tvDescription.setText(animal.getDescription());
        holder.tvContent.setText(animal.getContent());
        holder.ivPicture.setImageResource(animal.getImageID());
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Animal animal = (Animal) v.getTag();
                    System.out.println("listiemclick event fired");
                    if (animal != null) {
                        Log.d("listitemclick", "event fired, animal is not null");
                        System.out.println("event fired, animal is not null");
                        Toast.makeText(v.getContext().getApplicationContext(), animal.getName(), Toast.LENGTH_SHORT).show();

                        Intent launchDetailedActivity = new Intent(mContext, DisplayAnimalExtraActivity.class);
                        launchDetailedActivity.putExtra("CURRENTANIMAL", animal);
                        mContext.startActivity(launchDetailedActivity);

                    } else {
                        Log.d("listitemclick", "event fired, animal is  null");
                        System.out.println("event fired, animal is  null");
                    }
                }

            });
        }
    }
}