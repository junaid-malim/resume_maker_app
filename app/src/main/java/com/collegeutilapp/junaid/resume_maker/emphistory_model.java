package com.collegeutilapp.junaid.resume_maker;

import com.google.gson.Gson;

public class emphistory_model {

    String company,time,role;

    public emphistory_model(String company,String time,String role) {

        this.company=company;
        this.time=time;
        this.role=role;

    }

    public String serialize(){

        Gson gson=new Gson();

        return gson.toJson(this);
    }

    public emphistory_model create(String serialdata){

        Gson gson=new Gson();

        return gson.fromJson(serialdata,emphistory_model.class);

    }

}
