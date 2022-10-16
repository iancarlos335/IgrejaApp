package com.example.igrejaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData; //eu acabo precisando do conteúdo git dele, o que pode ser um problema futuro

public class SignUp extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button btnSignUp;
    TextView txtLogin;  // TODO fazer um texto que redirecione o usuário para a página de login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.btnSignUp);


        //Dentro desse evento que serão precessados o cadastro dos dados (colocar as ações aqui).
        btnSignUp.setOnClickListener(view -> {

            //Start ProgressBar first (Set visibility VISIBLE)
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                //Starting Write and Read data with URL
                //Creating array for parameters
                String[] field = new String[2];
                field[0] = "param-1";
                field[1] = "param-2";
                //Creating array for data
                String[] data = new String[2];
                data[0] = "data-1";
                data[1] = "data-2";             //Fill that only with your own IPV4. Using CMD to consult
                PutData putData = new PutData("http://192.168.0.196/ConnectionPhp/signup.php", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        //End ProgressBar (Set visibility to GONE)
                    }
                }
                //End Write and Read data with URL
            });

        });

    }


}