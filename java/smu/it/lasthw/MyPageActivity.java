package smu.it.lasthw;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MyPageActivity extends AppCompatActivity {
    ImageView img1, img2, img3, img4, img5, img6;
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    ToggleButton tb1, tb2, tb3, tb4, tb5, tb6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        ImageView btnBack = (ImageView) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Bundle extras = getIntent().getExtras();
        String idStr = extras.getString("id");

        TextView myPage_id = (TextView) findViewById(R.id.myPage_id);
        myPage_id.setText(extras.getString("id") + "님이 즐겨찾는 빵집");

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        tb1 = (ToggleButton) findViewById(R.id.tb1);
        tb2 = (ToggleButton) findViewById(R.id.tb2);
        tb3 = (ToggleButton) findViewById(R.id.tb3);
        tb4 = (ToggleButton) findViewById(R.id.tb4);
        tb5 = (ToggleButton) findViewById(R.id.tb5);
        tb6 = (ToggleButton) findViewById(R.id.tb6);

        tb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tb1.isChecked()) {
                    img1.setVisibility(View.INVISIBLE);
                    tv1.setVisibility(View.INVISIBLE);
                } else {
                    img1.setVisibility(View.VISIBLE);
                    tv1.setVisibility(View.VISIBLE);
                }
            }
        });
        tb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tb2.isChecked()) {
                    img2.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                } else {
                    img2.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                }
            }
        });
        tb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tb3.isChecked()) {
                    img3.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                } else {
                    img3.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                }
            }
        });
        tb4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tb4.isChecked()) {
                    img4.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                } else {
                    img4.setVisibility(View.VISIBLE);
                    tv4.setVisibility(View.VISIBLE);
                }
            }
        });
        tb5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tb5.isChecked()) {
                    img5.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                } else {
                    img5.setVisibility(View.VISIBLE);
                    tv5.setVisibility(View.VISIBLE);
                }
            }
        });
        tb6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tb6.isChecked()) {
                    img6.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                } else {
                    img6.setVisibility(View.VISIBLE);
                    tv6.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
