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

public class emphistory_dialog extends AppCompatDialogFragment {

    EditText company_name_input;
    EditText time_period_input;
    EditText role_in_company_input;
    String company_name;
    String time_period;
    String role_in_company;
    DialogListener listener;

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


                company_name = company_name_input.getText().toString();
                time_period = time_period_input.getText().toString();
                role_in_company = role_in_company_input.getText().toString();

                listener.getinputdata(company_name,time_period,role_in_company);

            }
        });

        company_name_input = view.findViewById(R.id.company_name_input);
        time_period_input = view.findViewById(R.id.time_period_input);
        role_in_company_input = view.findViewById(R.id.role_in_company_input);

        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener=(DialogListener) context;
    }

    public interface DialogListener {
        void getinputdata(String company_name, String time_period,String role_in_company);
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getTime_period() {
        return time_period;
    }

    public String getRole_in_company() {
        return role_in_company;
    }
}
