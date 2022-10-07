package com.example.igrejaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

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


        btnSignUp.setOnClickListener(new View.OnClickListener() { //Dentro desse evento que serão precessados o cadastro dos dados (colocar as ações aqui).
            @Override
            public void onClick(View view) {

               new Task().execute(); // TODO desafio de colocar essas informações por uma classe estrangeira

            }
        });

    }

    class Task extends AsyncTask<Void, Void, Void>{

    }
}