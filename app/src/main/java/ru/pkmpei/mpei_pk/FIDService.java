package ru.pkmpei.mpei_pk;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by infrostorm on 12.11.2017.
 */

public class FIDService extends FirebaseInstanceIdService
        {
            private static final String TAG = "MyFirebaseIIDService";

            //Функция вызывается когда получает новый токен
            @Override
            public void onTokenRefresh() {
                //Получаем обновленный токен
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                //Сообщаем об этом в консоль для отладки
                Log.d(TAG, "Refreshed token: " + refreshedToken);
                //Вызываем метод который передает на сервер токен нашего пользователя
                sendRegistrationToServer(refreshedToken);
            }
            private void sendRegistrationToServer(String token) {
                //Должна быть отправка токена на сервер
            }
}
