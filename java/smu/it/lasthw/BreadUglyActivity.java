package smu.it.lasthw;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class BreadUglyActivity extends AppCompatActivity {
    int i;
    //dialog 변수
    EditText dlgEdtNum; //dialg박스에 입력 받는 부분
    View dialogView; //dialog1.xml 인플레이트할 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bread);

        ImageView btnBack = (ImageView) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        TextView storeTitle = (TextView) findViewById(R.id.storeTitle);
        storeTitle.setText(extras.getString("store"));

        String idStr = extras.getString("id");
        String telStr = extras.getString("tel");
        String placeStr = extras.getString("place");

        ImageView btnmyPage = (ImageView) findViewById(R.id.myPage);
        btnmyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BreadUglyActivity.this, MyPageActivity.class);
                Bundle extras = new Bundle();
                extras.putString("id", idStr);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ugly1),
                "Yuzu Cream Cheese Ciabatta", "4200");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ugly2),
                "Inverter", "3000");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ugly3),
                "Egg Tart", "1800");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ugly4),
                "Double pain au chocolat", "3800");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ugly5),
                "Choco Stollen", "2000");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Drawable iconDrawable = item.getIcon() ;

                //dialog1.xml 파일 인플레이트
                dialogView = (View) View.inflate(BreadUglyActivity.this,R.layout.dialog1,null);

                //alertDialog.Builder 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(BreadUglyActivity.this);
                dlg.setTitle("런던베이글 뮤지엄");
                dlg.setIcon(iconDrawable);
                dlg.setView(dialogView); //인플레이트한 것을 대화상자로 사용

                //setPositiveButton
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dlgEdtNum =(EditText)dialogView.findViewById(R.id.dlgEdt2);

                                Toast.makeText(getApplicationContext(),storeTitle.getText().toString()+"의 "+titleStr+": "+dlgEdtNum.getText().toString()+"개",
                                        Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(BreadUglyActivity.this, TimeActivity.class);

                                Bundle extras = new Bundle();
                                extras.putString("menu", titleStr);
                                extras.putString("price", descStr);
                                extras.putString("howmany",dlgEdtNum.getText().toString());
                                extras.putString("store", storeTitle.getText().toString());
                                extras.putString("id", idStr);
                                extras.putString("tel", telStr);
                                extras.putString("place", placeStr);

                                i.putExtras(extras);

                                startActivity(i);
                            }
                        });

                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"취소했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        }) ;
    }
}
