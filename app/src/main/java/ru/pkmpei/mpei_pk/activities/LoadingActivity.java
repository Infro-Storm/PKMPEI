package ru.pkmpei.mpei_pk.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ru.pkmpei.mpei_pk.R;
import ru.pkmpei.mpei_pk.dataTypes.SessionData;

/**
 * Created by infrostorm on 26.02.2018.
 */

public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //вызываем функцию родителя
        super.onCreate(savedInstanceState);
        //заполняем запускаемый activity из layout activity_main
        setContentView(R.layout.loading_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSession();
    }

    private void getSession()
    {
        try
        {
            SessionData sessionData = new SessionData(getApplicationContext());
        }catch (Exception e){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            super.finish();
        }

    }
}
