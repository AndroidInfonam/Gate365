package gate365.infonam.com.gate365;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends TimeToolbar {

    private Button mBtn_login;
    private EditText mEdit_username, mEdit_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        getWidgets();
        setEvents();
    }

    @Override
    protected void setTime() {
        super.setTime();
    }

    @Override
    protected void getWidgets() {
        createToolbar();
        mBtn_login = (Button) findViewById(R.id.button_login);
        mEdit_username = (EditText) findViewById(R.id.edit_username);
        mEdit_password = (EditText) findViewById(R.id.edit_password);
    }

    @Override
    protected void setEvents() {
        mBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEdit_username.getText().toString().equals("admin") && mEdit_password.getText().toString().equals("admin")) {
                    Intent i = new Intent(Login.this, Gate365Activity.class);
                    startActivity(i);
                } else Toast.makeText(getApplication(), "error login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
