package ru.pkmpei.mpei_pk.activities;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.w3c.dom.Text;

import ru.pkmpei.mpei_pk.NetworkModel;
import ru.pkmpei.mpei_pk.ProtocolMPEI;
import ru.pkmpei.mpei_pk.R;
import ru.pkmpei.mpei_pk.ViewPort;

/**
 * Created by infrostorm on 26.02.2018.
 */

public class LoginActivity extends AppCompatActivity implements ViewPort {
    private ProtocolMPEI protocolMPEI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        FirebaseInstanceId.getInstance().getToken();
        //initProg();
        protocolMPEI = new ProtocolMPEI(this);
        Button logBtn = findViewById(R.id.loginBtn);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: call login script
                EditText loginTXT = findViewById(R.id.loginTXT);
                String login = loginTXT.getText().toString();
                EditText passTXT = findViewById(R.id.passwordTXT);
                String password = passTXT.getText().toString();
                if (login.isEmpty() || password.isEmpty()) {
                    Toast.makeText( getApplicationContext(),  "Введите логин и пароль!", Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(getApplicationContext(),"GToken: " + FirebaseInstanceId.getInstance().getToken(), Toast.LENGTH_LONG).show();
                    protocolMPEI.getSharedPublicKey(login, password);
                }
            }
        });

        TextView gotoReg = findViewById(R.id.gotoRegPageTextView);
        gotoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                LoginActivity.super.finish();
            }
        });

        TextView restorePass = findViewById(R.id.restorePassTextView);
        restorePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: restore password
            }
        });

    }

    @Override
    public void sendToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
}
