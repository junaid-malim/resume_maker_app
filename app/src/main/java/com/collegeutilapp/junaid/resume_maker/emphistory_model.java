package com.collegeutilapp.junaid.resume_maker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class emphistory_model {

    String company,time,role;

    public emphistory_model(String company,String time,String role) {

        this.company=company;
        this.time=time;
        this.role=role;

    }

    public emphistory_model() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

