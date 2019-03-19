package com.collegeutilapp.junaid.resume_maker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Tab3 extends Fragment implements emphistory_dialog.DialogListener {

    View v;
    Button add_emp;
    ListView emphistory;
    ArrayList<ArrayList<String>> emphistory_list=new ArrayList<>(3);


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.tab3, container, false);

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
        emphistoryDialog.show(getFragmentManager(),"Add employment details");

    }

    @Override
    public void getinputdata(String compay_name, String time_period,String role_in_company){



    }

}
