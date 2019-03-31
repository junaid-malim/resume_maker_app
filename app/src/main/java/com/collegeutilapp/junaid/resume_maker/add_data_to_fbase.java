package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class add_data_to_fbase {

    public add_data_to_fbase() {

    }

    public void setpersonal_details(final Context context, String name, String Phoneno, String email, String address, String description){

        DatabaseReference databaseReferencelcl=FirebaseDatabase.getInstance().getReference("personal_details");

        databaseReferencelcl.child("name").setValue(name);
        databaseReferencelcl.child("phoneno").setValue(Phoneno);
        databaseReferencelcl.child("email").setValue(email);
        databaseReferencelcl.child("address").setValue(address);
        databaseReferencelcl.child("description").setValue(description).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context,"DATA INSERTED SUCCESSFULY",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void seteducation_details(final Context context, String grade10scored, String grade10total, String grade12scored, String grade12total, String gradscored, String gradtotal, String postgradscored, String postgradtotal, String percent10, String percent12, String percentgrad, String percentpost){

        DatabaseReference databaseReferencelcl=FirebaseDatabase.getInstance().getReference("education_details");

        databaseReferencelcl.child("scored10").setValue(grade10scored);
        databaseReferencelcl.child("total10").setValue(grade10total);
        databaseReferencelcl.child("scored12").setValue(grade12scored);
        databaseReferencelcl.child("total12").setValue(grade12total);
        databaseReferencelcl.child("scoredgrad").setValue(gradscored);
        databaseReferencelcl.child("totalgrad").setValue(gradtotal);
        databaseReferencelcl.child("scoredpost").setValue(postgradscored);
        databaseReferencelcl.child("totalpost").setValue(postgradtotal);
        databaseReferencelcl.child("percent10").setValue(percent10+"%");
        databaseReferencelcl.child("percent12").setValue(percent12+"%");
        databaseReferencelcl.child("percentgrad").setValue(percentgrad+"%");
        databaseReferencelcl.child("percentpost").setValue(percentpost+"%").addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context,"DATA INSERTED SUCCESSFULY",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void setemphistory(final Context context, String companyname, String timeperiod, String roleincompany){

        DatabaseReference databaseReferencelcl=FirebaseDatabase.getInstance().getReference("employment_history");
        String sltstr=getSaltString();
        databaseReferencelcl.child("job"+sltstr).child("company_name").setValue(companyname);
        databaseReferencelcl.child("job"+sltstr).child("time_period").setValue(timeperiod);
        databaseReferencelcl.child("job"+sltstr).child("role_in_company").setValue(roleincompany).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context,"DATA INSERTED SUCCESSFULY",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void setskills(final Context context, String skill){

        DatabaseReference databaseReferencelcl=FirebaseDatabase.getInstance().getReference("capability").child("skills");

        databaseReferencelcl.child("skill"+getSaltString()).child("skill").setValue(skill).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context,"DATA INSERTED SUCCESSFULY",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void sethobbies(final Context context, String hobby){

        DatabaseReference databaseReferencelcl=FirebaseDatabase.getInstance().getReference("capability").child("hobbies");

        databaseReferencelcl.child("hobby"+getSaltString()).child("hobby").setValue(hobby).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context,"DATA INSERTED SUCCESSFULY",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void setlanguage(final Context context, String lang){

        DatabaseReference databaseReferencelcl=FirebaseDatabase.getInstance().getReference("capability").child("languages");

        databaseReferencelcl.child("language"+getSaltString()).child("language").setValue(lang).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(context,"DATA INSERTED SUCCESSFULY",Toast.LENGTH_LONG).show();
            }
        });

    }
    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 12) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }

    public void startnew(){

        DatabaseReference databaseReferencelcl=FirebaseDatabase.getInstance().getReference().getRoot();
        databaseReferencelcl.removeValue();

    }

}
