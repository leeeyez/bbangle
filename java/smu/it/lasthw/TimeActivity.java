package smu.it.lasthw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimeActivity extends AppCompatActivity {
    LinearLayout layout;
    TextView selectInfo, storeTitle, idInfo, priceInfo, manyInfo;
    //Context로 다음 액티비티에서 정보 사용
    public static Context DayContext;
    DatePicker dPicker;
    TextView tvYear, tvMonth, tvDay;
    Button btnReserve, btnDayOk;
    //시간 관련 변수
    TextView selectedTime;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_reservation);

        ImageView btnBack = (ImageView) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        layout = (LinearLayout) findViewById(R.id.infoBox);
        Animation anim_infoBox = AnimationUtils.loadAnimation(this, R.anim.logo);
        layout.startAnimation(anim_infoBox);

        Bundle extras = getIntent().getExtras();

        int howmany = Integer.parseInt(extras.getString("howmany"));
        int price = Integer.parseInt(extras.getString("price"));

        String id = extras.getString("id");
        String store = extras.getString("store");
        String menu = extras.getString("menu");
        String howMany = extras.getString("howmany");
        String tel = extras.getString("tel");
        String place = extras.getString("place");
        String priceStr = extras.getString("price");

        ImageView btnmyPage = (ImageView) findViewById(R.id.myPage);
        btnmyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TimeActivity.this, MyPageActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", id);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        // 빵집 이름 세팅
        storeTitle = (TextView) findViewById(R.id.store_Title);
        storeTitle.setText(extras.getString("store"));

        idInfo = (TextView) findViewById(R.id.idInfo);
        idInfo.setText(extras.getString("id"));

        // 앞서 선택한 메뉴와 개수 세팅 + 총 가격 계산
        selectInfo = (TextView) findViewById(R.id.menuInfo);
        selectInfo.setText(extras.getString("menu"));

        manyInfo = (TextView) findViewById(R.id.manyInfo);
        manyInfo.setText(extras.getString("howmany")+"개");

        priceInfo = (TextView) findViewById(R.id.priceInfo);
        priceInfo.setText(howmany*price+"원");

        // 날짜 예약 정보
        DayContext = this;
        dPicker = (DatePicker) findViewById(R.id.datePicker1);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        selectedTime = (TextView) findViewById(R.id.tvHour);
        radioGroup = (RadioGroup) findViewById(R.id.radio);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1:
                        selectedTime.setText("8");
                        break;
                    case R.id.radioButton2:
                        selectedTime.setText("10");
                        break;
                    case R.id.radioButton3:
                        selectedTime.setText("12");
                        break;
                    case R.id.radioButton4:
                        selectedTime.setText("14");
                        break;
                    case R.id.radioButton5:
                        selectedTime.setText("16");
                        break;
                    case R.id.radioButton6:
                        selectedTime.setText("18");
                        break;
                }
            }
        });

        btnDayOk = (Button)findViewById(R.id.BtnDayOk);
        btnDayOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1 + dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));
            }
        });


        btnReserve =  (Button)findViewById(R.id.btnReserve);
        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeActivity.this, ConfirmActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", id);
                extras.putString("store", store);
                extras.putString("menu", menu);
                extras.putString("howMany", howMany);
                extras.putString("tel", tel);
                extras.putString("place", place);
                extras.putString("price", priceStr);
                extras.putString("time", selectedTime.getText().toString());

                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
