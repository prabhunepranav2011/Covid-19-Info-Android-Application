package com.example.covid_19app;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Assess extends AppCompatActivity {
    EditText name, travel , symptoms;
    Button submit;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess);
        name =  findViewById(R.id.nme);
        travel =  findViewById(R.id.trvl);
        symptoms =  findViewById(R.id.sympt);
        submit = findViewById(R.id.check);
        fstore = FirebaseFirestore.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString().trim();
                String Travel = travel.getText().toString().trim();
                String Symptoms = symptoms.getText().toString().trim();

                if(TextUtils.isEmpty(Name)){
                    name.setError("Name is Required");
                    return;
                }

                if(TextUtils.isEmpty(Travel)){
                    travel.setError("This is Required");
                    return;
                }

                if(TextUtils.isEmpty(Symptoms)){
                    symptoms.setError("This is Required");
                    return;
                }


                DocumentReference dref = fstore.collection("Users").document();
                Map<String,Object> user = new HashMap<>();
                user.put("name",Name);
                user.put("travel",Travel);
                user.put("symptoms",Symptoms);
                dref.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Assess.this,"Submitted", Toast.LENGTH_SHORT).show();
                    }

                });
                Toast.makeText(Assess.this,"Submitted",Toast.LENGTH_SHORT).show();
            }
        });

    }




}
