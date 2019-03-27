package com.collegeutilapp.junaid.resume_maker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

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

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView company_name,time_period,role_in_company;

        public MyViewHolder(View view){
            super(view);

            company_name=view.findViewById(R.id.company_name);
            time_period=view.findViewById(R.id.time_period);
            role_in_company=view.findViewById(R.id.role_in_company);

        }

    }
}
