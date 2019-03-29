package com.collegeutilapp.junaid.resume_maker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Tab4 extends Fragment {

    Button addskill,addlangs,addhobby;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.tab4, container, false);

        addskill=v.findViewById(R.id.addskill);
        addlangs=v.findViewById(R.id.addlangs);
        addhobby=v.findViewById(R.id.addhobby);

        addskill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_dialog(1);
            }
        });

        addlangs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_dialog(2);
            }
        });

        addhobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_dialog(3);
            }
        });

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return v;
    }

    public void open_dialog(int sendcode){
        if (sendcode==1) {
            skill_dialogs skillDialogs = new skill_dialogs();
            if (getFragmentManager() != null) {
                skillDialogs.show(getFragmentManager(), "ADD SKILLS");
            }
        }else if (sendcode==2){
            langs_dialog langsDialog = new langs_dialog();
            if (getFragmentManager() != null) {
                langsDialog.show(getFragmentManager(), "ADD LANGUAGE");
            }
        }else if (sendcode==3){
            hobby_dialog hobbyDialog = new hobby_dialog();
            if (getFragmentManager() != null) {
                hobbyDialog.show(getFragmentManager(), "ADD HOBBIES");
            }
        }
    }

}
