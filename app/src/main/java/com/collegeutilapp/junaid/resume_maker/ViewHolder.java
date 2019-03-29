package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView=itemView;
    }

    public void setDetails_emphistory(Context context,String companyname,String timeperiod,String roleincompany){

        TextView company_name,time_period,role_in_company;

        company_name=mView.findViewById(R.id.company_name);
        time_period=mView.findViewById(R.id.time_period);
        role_in_company=mView.findViewById(R.id.role_in_company);

        company_name.setText(companyname);
        time_period.setText(timeperiod);
        role_in_company.setText(roleincompany);



    }

}
