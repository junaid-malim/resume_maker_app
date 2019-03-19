package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Tab1 extends Fragment {

    EditText nameet,phet,addresset,mailet;
    String name,phoneno,address,mail;
    View v;
    SharedPreferences sp;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.tab1, container, false);
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        sp= (getContext().getSharedPreferences("infosavepref", Context.MODE_PRIVATE));

        final SharedPreferences.Editor editor=sp.edit();

        nameet=v.findViewById(R.id.nameet);
        phet=v.findViewById(R.id.phet);
        mailet=v.findViewById(R.id.mailet);
        addresset=v.findViewById(R.id.mailet);

        v.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=nameet.getText().toString();
                phoneno="+91"+phet.getText().toString();
                mail=mailet.getText().toString();
                address=addresset.getText().toString();

                if(name.equals("") || phoneno.equals("") || mail.equals("+91") || address.equals("")){
                    Toast.makeText(getContext(),"Please Enter All Details",Toast.LENGTH_LONG).show();
                }

                editor.putString("name",name);
                editor.putString("phoneno",phoneno);
                editor.putString("mail",mail);
                editor.putString("address",address);
                editor.apply();

            }
        });
        //TODO store in shared prefs


        return v;
    }



}
