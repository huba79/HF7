package com.example.hf7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayAnimalExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_animal_extra);
        Animal animal = (Animal) getIntent().getSerializableExtra("CURRENTANIMAL");

        ImageView image = findViewById(R.id.animalExtraImageViewID);
        TextView name =  findViewById(R.id.animalExtraNameViewID);
        TextView description =  findViewById(R.id.animalExtraDescriptionViewID);
        TextView content = findViewById(R.id.animalExtraContentViewID);

        image.setImageResource(animal.getImageID());
        name.setText(animal.getName());
        description.setText(animal.getDescription());
        content.setText(animal.getContent());
    }
}