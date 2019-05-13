package com.example.amustvote;

import android.widget.EditText;

public class users {
    public String name;
    public String phone;
    public String email;
    public String id;
    public String program;

    public users() {

    }

    public users(String name , String phone , String email , String id , String program) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id = id;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}

