package com.example.tienbeerv20.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tienbeerv20.Data.Tests;
import com.example.tienbeerv20.MainActivity;
import com.example.tienbeerv20.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Logueo extends AppCompatActivity implements View.OnClickListener{

    public static String User;
    private TextView btnRegistro,butOlvido;
    private EditText TextLoginMail, TextLoginPassword;
    Button btnLog;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();


        btnLog= (Button) findViewById(R.id.butLogeo);
        btnRegistro= (TextView) findViewById(R.id.butRegistro);
        butOlvido= (TextView) findViewById(R.id.butOlvido);

        setContentView(R.layout.activity_logueo);
    }




    public void onClick(View v) {
        //Pasar al activity del main, al home

            loguearUsuario();
            //Pasar al activity de registro
        /*else if(v.getId()==btnRegistro.getId()){
            Intent next = new Intent(this, RegistroActivity.class);
            startActivity(next);
        }else if(v.getId()==butOlvido.getId()){
            Toast.makeText(Logueo.this, "Estamos en ello, ten paciencia", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void onClickRegistro(View v) {
        Intent next = new Intent(this, RegistroActivity.class);
        startActivity(next);
    }





    private void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        mAuth =FirebaseAuth.getInstance();
        TextLoginPassword=(EditText) this.findViewById(R.id.txtPass);
        TextLoginMail=(EditText) this.findViewById(R.id.txtEmail);
        progressDialog = new ProgressDialog(this);



        final String email = TextLoginMail.getText().toString().trim();
        String password = TextLoginPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();



        //loguear usuario
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //checking if success
                if (task.isSuccessful()) {
                    int pos = email.indexOf("@");
                    String user = email.substring(0, pos);
                    Toast.makeText(Logueo.this, "Bienvenido: " + TextLoginMail.getText(), Toast.LENGTH_SHORT).show();
                    User = email;

                    //private String email;

                    Intent siguienteLogin = new Intent (getApplicationContext(), MainActivity.class);

                    startActivity(siguienteLogin);

                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                        Toast.makeText(Logueo.this, "Ese usuario ya existe ",Toast.LENGTH_SHORT ).show();
                    } else {
                        Toast.makeText(Logueo.this, "Compruebe su usuario y contraseña ", Toast.LENGTH_SHORT).show();
                    }
                }
                progressDialog.dismiss();
            }
        });


    }



}