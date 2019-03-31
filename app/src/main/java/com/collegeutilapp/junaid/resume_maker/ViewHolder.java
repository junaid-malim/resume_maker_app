package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView=itemView;
    }

    void setDetails_emphistory(Context context, String companyname, String timeperiod, String roleincompany){

        TextView company_name,time_period,role_in_company;

        company_name=mView.findViewById(R.id.company_name);
        time_period=mView.findViewById(R.id.time_period);
        role_in_company=mView.findViewById(R.id.role_in_company);

        company_name.setText(companyname);
        time_period.setText(timeperiod);
        role_in_company.setText(roleincompany);



    }

    void setDetail_skill(String skill_ip){

        TextView skill;

        skill=mView.findViewById(R.id.cap_op);

        skill.setText(skill_ip);
    }

    void setDetail_hobby(String hobby_ip){

        TextView hobby;

        hobby=mView.findViewById(R.id.cap_op);

        hobby.setText(hobby_ip);
    }

    void setDetail_language(String language_ip){

        TextView language;

        language=mView.findViewById(R.id.cap_op);

        language.setText(language_ip);
    }

}
