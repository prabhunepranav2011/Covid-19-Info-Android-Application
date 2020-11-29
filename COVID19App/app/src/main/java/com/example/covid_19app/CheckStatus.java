package com.example.covid_19app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.leo.simplearcloader.SimpleArcLoader;

import java.util.ArrayList;
import java.util.List;

public class CheckStatus extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_status);
    }

    public void goAssess(View view) {
        startActivity(new Intent(getApplicationContext(), Assess.class));
    }

    public void viewInfo(View view) {
        startActivity(new Intent(getApplicationContext(), viewInf.class));
    }
}



