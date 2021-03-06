package com.collegeutilapp.junaid.resume_maker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.valdesekamdem.library.mdtoast.MDToast;

public class Tab1 extends Fragment {

    EditText nameet,phet,addresset,mailet,prodi;
    String name,phoneno,address,mail,proditxt;
    View v;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.tab1, container, false);
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        nameet=v.findViewById(R.id.nameet);
        phet=v.findViewById(R.id.phet);
        mailet=v.findViewById(R.id.mailet);
        addresset=v.findViewById(R.id.mailet);
        prodi=v.findViewById(R.id.prodi);



        v.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=nameet.getText().toString();
                phoneno="+91 "+phet.getText().toString();
                mail=mailet.getText().toString();
                address=addresset.getText().toString();
                proditxt=prodi.getText().toString();

                if(name.equals("") || phoneno.equals("+91 ") || address.equals("")||proditxt.isEmpty()){
                    if (!mail.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                        MDToast.makeText(getActivity(),"please enter valid email",MDToast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
                    }
                    MDToast.makeText(getActivity(),"Please Enter All Details",MDToast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
                }else {
                    add_data_to_fbase fbase = new add_data_to_fbase();
                    fbase.setpersonal_details(getContext(), name, phoneno, mail, address, proditxt);
                }


            }
        });



        return v;
    }



}
