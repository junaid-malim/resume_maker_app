package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class Tab2 extends Fragment {

    EditText grade10total,grade10scored,grade12total,grade12scored,gradtotal,gradscored,postgradtotal,postgradscored;
    View v;
    float score10,total10,score12,total12,scoregrad,totalgrad,scorepost,totalpost;
    String percent10,percent12,percentgrad,percentpostgrad;
    Button savebutton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.tab2, container, false);
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        savebutton=v.findViewById(R.id.savebutton);

        grade10scored=v.findViewById(R.id.grade10scored);
        grade12scored=v.findViewById(R.id.grade12scored);
        grade10total=v.findViewById(R.id.grade10total);
        grade12total=v.findViewById(R.id.grade12total);
        gradscored=v.findViewById(R.id.gradscored);
        gradtotal=v.findViewById(R.id.gradtotal);
        postgradscored=v.findViewById(R.id.postgradscored);
        postgradtotal=v.findViewById(R.id.postgradtotal);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                editor.putString("grade10scored",grade10scored.getText().toString());
                editor.putString("grade10total",grade10total.getText().toString());
                editor.putString("grade12scored",grade12scored.getText().toString());
                editor.putString("grade12total",grade12total.getText().toString());
                editor.putString("gradscored",gradscored.getText().toString());
                editor.putString("gradtotal",gradtotal.getText().toString());
                editor.putString("postgradscored",postgradscored.getText().toString());
                editor.putString("postgradtotal",postgradtotal.getText().toString());
                */

                score10=Float.parseFloat(grade10scored.getText().toString());
                score12=Float.parseFloat(grade12scored.getText().toString());
                total10=Float.parseFloat(grade10total.getText().toString());
                total12=Float.parseFloat(grade12total.getText().toString());
                scoregrad=Float.parseFloat(gradscored.getText().toString());
                totalgrad=Float.parseFloat(gradtotal.getText().toString());
                scorepost=Float.parseFloat(postgradscored.getText().toString());
                totalpost=Float.parseFloat(postgradtotal.getText().toString());

                percent10=String.valueOf(getpercent(score10,total10));
                percent12=String.valueOf(getpercent(score12,total12));
                percentgrad=String.valueOf(getpercent(scoregrad,totalgrad));
                percentpostgrad=String.valueOf(getpercent(scorepost,totalpost));

                /*
                editor.putString("percent10",percent10);
                editor.putString("percent12",percent12);
                editor.putString("percentgrad",percentgrad);
                editor.putString("percentpostgrad",percentgrad);
                */

                add_data_to_fbase fbase=new add_data_to_fbase();
                fbase.seteducation_details(
                        getContext(),
                        String.valueOf(score10),
                        String.valueOf(total10),
                        String.valueOf(score12),
                        String.valueOf(total12),
                        String.valueOf(scoregrad),
                        String.valueOf(totalgrad),
                        String.valueOf(scorepost),
                        String.valueOf(totalpost),
                        percent10,
                        percent12,
                        percentgrad,
                        percentpostgrad);

            }
        });

        return v;
    }

    public float getpercent(float scored,float total){

        return ( scored * 100f )/ total;

    }

}
