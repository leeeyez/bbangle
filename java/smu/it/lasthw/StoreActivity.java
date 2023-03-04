package smu.it.lasthw;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StoreActivity extends AppCompatActivity {
    ImageButton london, jungsuk, ugly, owal, tartine, pol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        ImageView btnBack = (ImageView) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView tv = (TextView) findViewById(R.id.choose);
        Bundle extras = getIntent().getExtras();
        tv.setText(extras.getString("id")+"님, 빵글에 오신 것을 환영합니다 !");

        String idStr = extras.getString("id");

        Bundle newextras = new Bundle();
        newextras.putString("id",idStr);

        ImageView btnmyPage = (ImageView) findViewById(R.id.myPage);
        btnmyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreActivity.this, MyPageActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", idStr);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        london = (ImageButton) findViewById(R.id.btnLondon);
        london.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreActivity.this, LondonActivity.class);
                i.putExtras(newextras);
                startActivity(i);
            }
        });

        jungsuk = (ImageButton) findViewById(R.id.btnJungsuk);
        jungsuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreActivity.this, JungsukActivity.class);
                i.putExtras(newextras);
                startActivity(i);
            }
        });

        ugly = (ImageButton) findViewById(R.id.btnUgly);
        ugly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreActivity.this, UglyActivity.class);
                i.putExtras(newextras);
                startActivity(i);
            }
        });

        owal = (ImageButton) findViewById(R.id.btnOwal);
        owal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreActivity.this, OwalActivity.class);
                i.putExtras(newextras);
                startActivity(i);
            }
        });

        tartine = (ImageButton) findViewById(R.id.btnTartine);
        tartine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreActivity.this, TartineActivity.class);
                i.putExtras(newextras);
                startActivity(i);
            }
        });

        pol = (ImageButton) findViewById(R.id.btnPol);
        pol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreActivity.this, PolActivity.class);
                i.putExtras(newextras);
                startActivity(i);
            }
        });

    }
}
