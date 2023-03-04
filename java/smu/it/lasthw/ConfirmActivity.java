package smu.it.lasthw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {
    ImageView check;
    TextView tvYear2, tvMonth2, tvDay2;
    TextView store, id, menu, num, totalPrice, place, tel, time;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm);

        ImageView btnBack = (ImageView) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        check = (ImageView) findViewById(R.id.check);
        Animation anim_infoBox = AnimationUtils.loadAnimation(this, R.anim.logo);
        check.startAnimation(anim_infoBox);

        store = (TextView) findViewById(R.id.tv_store);
        id = (TextView) findViewById(R.id.tv_id);
        tvYear2 = (TextView) findViewById(R.id.tvYear2);
        tvMonth2 = (TextView) findViewById(R.id.tvMonth2);
        tvDay2 = (TextView) findViewById(R.id.tvDay2);
        menu = (TextView) findViewById(R.id.tv_menu);
        num = (TextView) findViewById(R.id.tv_num);
        totalPrice = (TextView) findViewById(R.id.tv_totalPrice);
        place = (TextView) findViewById(R.id.tv_place);
        tel = (TextView) findViewById(R.id.tv_tel);
        time = (TextView) findViewById(R.id.tvHour);

        tvYear2.setText(((TimeActivity)TimeActivity.DayContext).tvYear.getText());
        tvMonth2.setText(((TimeActivity)TimeActivity.DayContext).tvMonth.getText());
        tvDay2.setText(((TimeActivity)TimeActivity.DayContext).tvDay.getText());

        Bundle extras = getIntent().getExtras();

        int howMany = Integer.parseInt(extras.getString("howMany"));
        int price = Integer.parseInt(extras.getString("price"));

        store.setText(extras.getString("store"));
        id.setText(extras.getString("id"));
        menu.setText(extras.getString("menu"));
        num.setText(extras.getString("howMany")+"개");
        totalPrice.setText(howMany*price+"원");
        place.setText(extras.getString("place"));
        tel.setText(extras.getString("tel"));
        time.setText(extras.getString("time"));

        String idStr = extras.getString("id");

        ImageView btnmyPage = (ImageView) findViewById(R.id.myPage);
        btnmyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmActivity.this, MyPageActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", idStr);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmActivity.this, StoreActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", idStr);
                i.putExtras(extras);
                startActivity(i);
            }
        });

    }
}
