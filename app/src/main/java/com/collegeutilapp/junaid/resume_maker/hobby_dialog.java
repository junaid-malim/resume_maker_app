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

import com.valdesekamdem.library.mdtoast.MDToast;

public class hobby_dialog extends AppCompatDialogFragment {

    EditText item_input;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.capability_input,null);

        item_input=view.findViewById(R.id.item_input);
        item_input.setHint("ADD A HOBBY HERE...");

        builder.setTitle("ADD HOBBIES").setView(view).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            if(!item_input.getText().toString().isEmpty()) {
                add_data_to_fbase fbase = new add_data_to_fbase();
                fbase.sethobbies(getContext(), item_input.getText().toString());
            }else {
                MDToast.makeText(getActivity(),"YOU LEFT IT BLANK",MDToast.LENGTH_LONG,MDToast.TYPE_ERROR).show();
            }
            }
        });



        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
