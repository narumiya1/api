package com.news.eijun.api;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;


import com.news.eijun.api.activities.BussinesActivity;
import com.news.eijun.api.activities.EntertainmentActivity;
import com.news.eijun.api.activities.HeadlineActivity;
import com.news.eijun.api.activities.HealthActivity;
import com.news.eijun.api.activities.SportszActivity;
import com.news.eijun.api.activities.TechnoActivity;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cvHead, cvSports, cvTechno, cvBussines, cvHealth, cvEntertainment ;
    TextView tvToday;
    String hrIni;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvHead = findViewById(R.id.cardHeadline);
        cvSports = findViewById(R.id.cardSportsz);
        cvTechno = findViewById(R.id.cardTechno);
        cvBussines = findViewById(R.id.cardBusiness);
        cvHealth = findViewById(R.id.cardHealth);
        cvEntertainment = findViewById(R.id.cardEnter);

        cvHead.setOnClickListener(this);
        cvSports.setOnClickListener(this);
        cvTechno.setOnClickListener(this);
        cvBussines.setOnClickListener(this);
        cvHealth.setOnClickListener(this);
        cvEntertainment.setOnClickListener(this);

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        hrIni = (String) DateFormat.format("EEEE", dateNow);

        if (hrIni.equalsIgnoreCase("sunday")) {
            hrIni = "Minggu" ;
        }else if (hrIni.equalsIgnoreCase("monday")){
            hrIni = "Senin" ;
        }else if (hrIni.equalsIgnoreCase("tuesday")){
            hrIni = "Selasa" ;
        }else if (hrIni.equalsIgnoreCase("wednesday")){
            hrIni = "Rabu" ;
        }else if (hrIni.equalsIgnoreCase("thursday")){
            hrIni = "Kamis" ;
        }else if (hrIni.equalsIgnoreCase("friday")){
            hrIni = "Jumat" ;
        }else if (hrIni.equalsIgnoreCase("saturday")){
            hrIni = "Sabtu" ;
        }
        
        getToday();

    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d",date);
        String monthNumbers = (String) DateFormat.format("M", date);
        String year = (String) DateFormat.format("yyyy", date);

        int month = Integer.parseInt(monthNumbers);
        String bulan = null ;

        if (month==1){
            bulan = "Januari";
        }else if(month == 2){
            bulan= "Februari";
        }else if(month == 3){
            bulan= "Maret";
        }else if(month == 4){
            bulan= "April";
        }else if(month == 5){
            bulan= "Mei";
        }else if(month == 6){
            bulan= "Juni";
        }else if(month == 7){
            bulan= "Juli";
        }else if(month == 8){
            bulan= "Agustus";
        }else if(month == 9){
            bulan= "September";
        }else if(month == 10){
            bulan= "Oktober";
        }else if(month == 11){
            bulan= "November";
        }else if(month == 12){
            bulan= "Desember";
        }

        String formatFrixed = hrIni + ", " +tanggal+ ", "+bulan+", "+year;
        tvToday.setText(formatFrixed);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cardHeadline){
            Intent intent = new Intent(MainActivity.this, HeadlineActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.cardSportsz){
            Intent intent = new Intent(MainActivity.this, SportszActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.cardTechno){
            Intent intent = new Intent(MainActivity.this, TechnoActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.cardBusiness){
            Intent intent = new Intent(MainActivity.this, BussinesActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.cardHealth){
            Intent intent = new Intent(MainActivity.this, HealthActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.cardEnter){
            Intent intent = new Intent(MainActivity.this, EntertainmentActivity.class);
            startActivity(intent);
        }
    }
}
