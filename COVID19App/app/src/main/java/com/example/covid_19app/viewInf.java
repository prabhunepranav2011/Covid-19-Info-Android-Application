package com.example.covid_19app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class viewInf extends AppCompatActivity {
    TextView count, level;

    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_inf);
        level = findViewById(R.id.Level);
        count = findViewById(R.id.Count);
        final int[] c = {0};

        fstore = FirebaseFirestore.getInstance();

       CollectionReference cref = fstore.collection("users");
       cref.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
           @Override
           public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

               for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges())
               {

                   if(documentChange.getDocument().getData().get("symptoms").toString().equals("Yes")){
                       c[0] +=1 ;
                   }

               }
               count.setText(new String(String.valueOf(11)));
               if(c[0]>2){
                   count.setText("Count of suspected cases"+ new String(String.valueOf(11)));
               }
               level.setText("Your area is in mild danger");
           }
       });


    }
}





