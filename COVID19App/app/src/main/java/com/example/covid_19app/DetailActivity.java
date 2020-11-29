package com.example.covid_19app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int positionCOuntry;
    TextView tvCountry, tvCases, tvActive, tvRecovered, tvCritical, tvDeaths, tvTodayDeaths, tvTodayCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        positionCOuntry = intent.getIntExtra("position",0);

        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvActive = findViewById(R.id.tvActive);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvTodayCases = findViewById(R.id.tvTodayCases);

        tvCountry.setText(AffectedCountries.countryModelList.get(positionCOuntry).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(positionCOuntry).getCases());
        tvActive.setText(AffectedCountries.countryModelList.get(positionCOuntry).getActive());
        tvRecovered.setText(AffectedCountries.countryModelList.get(positionCOuntry).getRecovered());
        tvCritical.setText(AffectedCountries.countryModelList.get(positionCOuntry).getCritical());
        tvDeaths.setText(AffectedCountries.countryModelList.get(positionCOuntry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelList.get(positionCOuntry).getTodayDeaths());
        tvTodayCases.setText(AffectedCountries.countryModelList.get(positionCOuntry).getTodayCases());








    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
