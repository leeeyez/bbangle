package smu.it.lasthw;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class UglyActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_ugly);

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");

        ImageView btnmyPage = (ImageView) findViewById(R.id.myPage);
        btnmyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UglyActivity.this, MyPageActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", id);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        ImageView btnBack = (ImageView) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btn_web = (Button) findViewById(R.id.web);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/uglybakery"));
                startActivity(i);
            }
        });

        Button btn_reserve = (Button) findViewById(R.id.btn_reserve);
        btn_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView storeName = (TextView) findViewById(R.id.storeName);
                TextView storeTel = (TextView) findViewById(R.id.tv_tel);
                TextView storePlace = (TextView) findViewById(R.id.tv_place);
                Intent i = new Intent(UglyActivity.this, BreadUglyActivity.class);
                Bundle extras = new Bundle();
                extras.putString("store", storeName.getText().toString());
                extras.putString("tel", storeTel.getText().toString());
                extras.putString("place", storePlace.getText().toString());
                extras.putString("id",id);
                i.putExtras(extras);
                startActivity(i);
            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng SEOUL = new LatLng(37.554995, 126.905042);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("어글리 베이커리");
        markerOptions.snippet("망원점");
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 50));

    }

}
