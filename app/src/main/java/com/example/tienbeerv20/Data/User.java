package com.example.tienbeerv20.Data;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int identificacion;
    private String email;
    private int phone;
    //private String password;
    //private String userAdress;

    public void subirFire(DatabaseReference mDatabase){
        Map<String,Object> personalMap = new HashMap<>();
        personalMap.put("Mail", email);
        personalMap.put("Identificacion", identificacion);
        personalMap.put("Phone", phone);
        mDatabase.child("Usuarios").push().setValue(personalMap);
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


}
