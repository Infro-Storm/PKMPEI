package ru.pkmpei.mpei_pk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ru.pkmpei.mpei_pk.R;

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
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        super.finish();
    }
}
