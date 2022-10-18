package com.example.igrejaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData; //eu acabo precisando do conteúdo git dele, o que pode ser um problema futuro

public class SignUp extends AppCompatActivity {

    TextInputEditText textInputEditTextFullname, textInputEditTextEmail,textInputEditTextUsername, textInputEditTextPassword ;
    Button btnSignUp;
    TextView textViewLogin;  // TODO fazer um texto que redirecione o usuário para a página de login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputEditTextFullname = findViewById(R.id.fullname);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.btnSignUp);
        textViewLogin = findViewById(R.id.loginText);


        //Dentro desse evento que serão precessados o cadastro dos dados (colocar as ações aqui).
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname, email, username, password;
                fullname = String.valueOf(textInputEditTextFullname.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());


                if (!fullname.equals("") && !email.equals("") && !username.equals("") && !password.equals("")) { // only if the fields are , the code will be executed
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "email";
                            field[2] = "username";
                            field[3] = "password";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = fullname;
                            data[1] = email;
                            data[2] = username;
                            data[3] = password;
                            PutData putData = new PutData("http://192.168.0.196/ConnectionPhp/signup.php", "POST", field, data); //Using the IP of machine where database is hosted, enable others devices to consult him only by being connected at same wifi
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Cadastro deu certo")){
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT ).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL

                        }
                    });

                }
                else {
                    Toast.makeText(getApplicationContext(), "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show(); // Footer system message
                }

            }
        });

    }


}