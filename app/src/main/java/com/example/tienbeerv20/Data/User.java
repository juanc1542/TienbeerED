package com.example.tienbeerv20.Data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String identificacion;
    private String email;
    private String phone;
    //private String password;
    //private String userAdress;

    public void subirFire(DatabaseReference mDatabase){
        Map<String,Object> personalMap = new HashMap<>();
        personalMap.put("Mail", email);
        personalMap.put("Identificacion", identificacion);
        personalMap.put("Phone", phone);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mDatabase= FirebaseDatabase.getInstance().getReference().child("Usuarios").push().setValue(personalMap);

        String id = mDatabase.child("Usuarios").push().getKey();
        mDatabase.child("Usuarios").child(id).setValue(personalMap);

        //mDatabase.child("Usuarios").push().setValue(personalMap);
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;

        public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }
    }*/

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
