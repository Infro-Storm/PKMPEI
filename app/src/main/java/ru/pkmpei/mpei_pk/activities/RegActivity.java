package ru.pkmpei.mpei_pk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import ru.pkmpei.mpei_pk.R;

/**
 * Created by infrostorm on 26.02.2018.
 */

public class RegActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);

        String[] data = getResources().getStringArray(R.array.questions);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        DatePicker dt = (DatePicker) findViewById(R.id.simpleDatePicker);
        dt.setMaxDate(new Date().getTime());
        dt.updateDate(2000, 0 ,1);

        Button regBtn = (Button) findViewById(R.id.reg_btn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: call reg script
                Toast.makeText( getApplicationContext(),  "Увы, регистрация пока не работает :(", Toast.LENGTH_LONG).show(); ;
            }
        });

        TextView tv = (TextView) findViewById(R.id.gotoLoginPageTextView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegActivity.this, LoginActivity.class);
                startActivity(intent);
                RegActivity.super.finish();
            }
        });
    }
}
