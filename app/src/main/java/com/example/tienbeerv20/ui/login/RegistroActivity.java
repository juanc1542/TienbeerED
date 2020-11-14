package com.example.tienbeerv20.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tienbeerv20.Data.User;
import com.example.tienbeerv20.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;

public class RegistroActivity extends AppCompatActivity {

    private EditText TextMail, TextPassword, TextIdent, TextPhone;
    //private Button Registro;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ProgressDialog progressDialog;
    private User users= new User();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        TextMail=(EditText) findViewById(R.id.txtEmail2);
        TextPassword=(EditText) findViewById(R.id.txtPassReg);
        TextIdent=(EditText) findViewById(R.id.txtIdentReg);
        TextPhone=(EditText) findViewById(R.id.txtTelReg);

    }

    public void onClick(View v) {
        registrarUsuario();
    }

    private void registrarUsuario(){

        //Recopilar info de la caja de texto
        final String email= TextMail.getText().toString().trim();
        final String password= TextPassword.getText().toString().trim();
        final String identif= TextIdent.getText().toString().trim();
        final int identificacion = Integer.parseInt(identif);
        final String phone= TextPhone.getText().toString().trim();


        progressDialog = new ProgressDialog(this);

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //creating a new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(RegistroActivity.this,"Se ha registrado el usuario con el email: "+ TextMail.getText(),Toast.LENGTH_LONG).show();
                            users.setEmail(email);
                            users.setIdentificacion(identificacion);
                            users.subirFire(mDatabase);
                            Intent inicio = new Intent(getApplicationContext(),Logueo.class);
                            startActivity(inicio);

                        }else{
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(RegistroActivity.this, "El usuario registrado ya existe ", Toast.LENGTH_LONG).show();
                            } else{
                                Toast.makeText(RegistroActivity.this, "Inserte datos validos ", Toast.LENGTH_LONG).show();

                            }
                        }
                        progressDialog.dismiss();
                    }
                });

    }

}