package com.collegeutilapp.junaid.resume_maker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class emphistory_dialog extends AppCompatDialogFragment {

    EditText company_name_input,time_period_input_yr,time_period_input_mnt,role_in_company_input;
    String company_name,time_period_yr,time_period_mnt,role_in_company;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.emphistory_input,null);


        builder.setTitle("Add previous job Details").setView(view).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(!company_name_input.getText().toString().isEmpty()||!time_period_input_yr.getText().toString().isEmpty()||!time_period_input_mnt.getText().toString().isEmpty()||!role_in_company_input.getText().toString().isEmpty()) {
                    company_name = company_name_input.getText().toString();
                    time_period_yr = time_period_input_yr.getText().toString();
                    time_period_mnt=time_period_input_mnt.getText().toString();
                    role_in_company = role_in_company_input.getText().toString();

                    add_data_to_fbase fbase = new add_data_to_fbase();
                    fbase.setemphistory(getContext(), company_name, time_period_yr+" YEARS and "+time_period_mnt+"MONTHS", role_in_company);
                }else {
                    Toast.makeText(getContext(),"ENTER ALL DETAILS",Toast.LENGTH_LONG).show();
                }

            }
        });

        company_name_input = view.findViewById(R.id.company_name_input);
        time_period_input_yr = view.findViewById(R.id.time_period_input_yr);
        time_period_input_mnt=view.findViewById(R.id.time_period_input_mnt);
        role_in_company_input = view.findViewById(R.id.role_in_company_input);

        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
