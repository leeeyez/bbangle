package smu.it.lasthw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edit_id, edit_pw;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edit_id = (EditText) findViewById(R.id.et_id);
        edit_pw = (EditText) findViewById(R.id.et_pw);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idText, pwText;

                idText = edit_id.getText().toString();
                pwText = edit_pw.getText().toString();

                Intent intent = new Intent(LoginActivity.this, StoreActivity.class);

                Bundle extras = new Bundle();
                extras.putString("id", idText);
                extras.putString("pw", pwText);

                intent.putExtras(extras);

                startActivity(intent);
            }
        });
    }
}
