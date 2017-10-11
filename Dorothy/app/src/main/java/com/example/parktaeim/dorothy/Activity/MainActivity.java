package com.example.parktaeim.dorothy.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.parktaeim.dorothy.R;
import com.skp.Tmap.TMapView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private double latitude;
    private double longitude;
    private EditText destEditText;
    private ImageView searchIcon;
    private String destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.map_view);
        TMapView tMapView = new TMapView(this);

        tMapView.setSKPMapApiKey("f6d6e268-7e09-331c-9753-e1a48087d569");

        tMapView.setCompassMode(true);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(15);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(true);
        tMapView.setSightVisible(true);
        relativeLayout.addView(tMapView);

        setSearch();
    }


    private void setSearch(){
        destEditText = (EditText) findViewById(R.id.destEditText);
        searchIcon = (ImageView) findViewById(R.id.searchIcon);

//        검색버튼 클릭시
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destination = destEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this,SearchDestActivity.class);
                intent.putExtra("destination",destination); //edittext에 입력된 값 넘기기
                startActivity(intent);
            }
        });

    }

}



