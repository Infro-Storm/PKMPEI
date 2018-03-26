package ru.pkmpei.mpei_pk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import ru.pkmpei.mpei_pk.NetworkModel;
import ru.pkmpei.mpei_pk.R;

/**
 * Created by infrostorm on 26.02.2018.
 */

public class LoginActivity extends AppCompatActivity {
    private NetworkModel networkModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        //initProg();
        Button logBtn = (Button) findViewById(R.id.loginBtn);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: call login script
                EditText loginTXT = (EditText)findViewById(R.id.loginTXT);
                String login = loginTXT.getText().toString();
                EditText passTXT = (EditText)findViewById(R.id.passwordTXT);
                String password = passTXT.getText().toString();
                if (login.isEmpty() || password.isEmpty()) {
                    Toast.makeText( getApplicationContext(),  "Введите логин и пароль!", Toast.LENGTH_LONG).show(); ;
                }
                else {
                    networkModel = new NetworkModel(getApplicationContext());
                    networkModel.GetSessionData(login, password);
                }
            }
        });

        TextView gotoReg = (TextView) findViewById(R.id.gotoRegPageTextView);
        gotoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                LoginActivity.super.finish();
            }
        });

        TextView restorePass = (TextView) findViewById(R.id.restorePassTextView);
        restorePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: restore password
            }
        });

    }
}
