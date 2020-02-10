package com.example.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalActivity extends AppCompatActivity {


    Animal animal;
    TextView Name_Animal;
    ImageView imageAnimal;
    TextView AnneeNaissance;
    TextView PeriodeGestation;
    TextView PoidsNaissance;
    TextView PoidsAdulte;
    EditText StatutConservation;
    Button Sauvegarde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);


        //textView_Animal_name.setText(intent.getSerializableExtra("name").toString());
        //TextView textView_Name2 = findViewById(R.id.textView_Name2 );
        //textView_Name2.setText(intent.getSerializableExtra("name1").toString());

        //Intent intent = getIntent();
        //TextView textView_Animal_name = findViewById(R.id.textView_Animal_name);

        String name = getIntent().getStringExtra("name");
        animal = AnimalList.getAnimal(name);

        Name_Animal = findViewById(R.id.textView_Animal_name);
        Name_Animal.setText(name);

        imageAnimal = findViewById(R.id.imageView_Animal);
        int id = getResources().getIdentifier(animal.getImgFile(), "drawable", getPackageName());
        imageAnimal.setImageResource(id);

        AnneeNaissance = findViewById(R.id.textView_Name2);
        AnneeNaissance.setText(animal.getStrHightestLifespan());

        PeriodeGestation = findViewById(R.id.textView_Name4);
        PeriodeGestation.setText(animal.getStrGestationPeriod());

        PoidsNaissance = findViewById(R.id.textView_Name6);
        PoidsNaissance.setText(animal.getStrBirthWeight());

        PoidsAdulte = findViewById(R.id.textView_Name8);
        PoidsAdulte.setText(animal.getStrAdultWeight());

        StatutConservation = findViewById(R.id.editText_Name10);
        StatutConservation.setText(animal.getConservationStatus());

        Sauvegarde= findViewById(R.id.button);
        Sauvegarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal.setConservationStatus(StatutConservation.getText().toString());

            }
        });






    }
}
