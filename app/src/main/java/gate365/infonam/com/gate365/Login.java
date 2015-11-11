package gate365.infonam.com.gate365;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends TimeToolbar {

    private Button mbtn_login;
    private EditText met_username, met_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mbtn_login = (Button) findViewById(R.id.button_login);
        met_username = (EditText) findViewById(R.id.edit_username);
        met_password = (EditText) findViewById(R.id.edit_password);
    }

    @Override
    protected void setEvents() {
        mbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (met_username.getText().toString().equals("admin") && met_password.getText().toString().equals("admin")) {
                    Intent i = new Intent(Login.this, Gate365Activity.class);
                    startActivity(i);
                } else Toast.makeText(getApplication(), "error login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
