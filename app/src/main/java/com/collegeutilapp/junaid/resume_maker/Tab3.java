package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Tab3 extends Fragment {

    View v;
    Button add_emp;
    RecyclerView emphistory;
    ArrayList<ArrayList<String>> emphistory_list=new ArrayList<>(3);
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.tab3, container, false);

        sp= this.getActivity().getSharedPreferences("infosavepref", Context.MODE_PRIVATE);

        editor = sp.edit();


        add_emp=v.findViewById(R.id.add_emp);
        add_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                open_dialog();

            }
        });

        return v;
    }

    public void open_dialog(){

        emphistory_dialog emphistoryDialog=new emphistory_dialog();
        if (getFragmentManager() != null) {
            emphistoryDialog.show(getFragmentManager(),"Add employment details");
        }

    }
    //TODO refresh recyclerview
/*
    @Override
    public void getinputdata(String company_name, String time_period, String role_in_company) {

        editor.putString("lol0","lol"+company_name+time_period+role_in_company);

    }
*/
}
