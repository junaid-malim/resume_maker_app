package com.collegeutilapp.junaid.resume_maker;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Retrive_data_from_fbase {

    private String name,email,phono,address,personaldesc;
    private String grade10total,grade10scored,grade12total,grade12scored,gradtotal,gradscored,postgradtotal,postgradscored,percent10,percent12,percentgrad,percentpost;

    private ArrayList<String> emp_history_company=new ArrayList();
    private ArrayList<String> emp_history_time=new ArrayList();
    private ArrayList<String> emp_history_role=new ArrayList();

    private ArrayList<String> skills_list=new ArrayList();
    private ArrayList<String> hobbies_list=new ArrayList();
    private ArrayList<String> lang_list=new ArrayList();

    Retrive_data_from_fbase() {

        DatabaseReference personaldb = FirebaseDatabase.getInstance().getReference("personal_details");
        personaldb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                name=dataSnapshot.child("name").getValue(String.class);
                phono=dataSnapshot.child("phoneno").getValue(String.class);
                email=dataSnapshot.child("email").getValue(String.class);
                address=dataSnapshot.child("address").getValue(String.class);
                personaldesc=dataSnapshot.child("description").getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference education_ref = FirebaseDatabase.getInstance().getReference("education_details");
        education_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                grade10scored=dataSnapshot.child("scored10").getValue(String.class);
                grade12scored=dataSnapshot.child("scored12").getValue(String.class);
                grade10total=dataSnapshot.child("total10").getValue(String.class);
                grade12total=dataSnapshot.child("total12").getValue(String.class);
                gradscored=dataSnapshot.child("scoredgrad").getValue(String.class);
                gradtotal=dataSnapshot.child("totalgrad").getValue(String.class);
                postgradscored=dataSnapshot.child("scoredpost").getValue(String.class);
                postgradtotal=dataSnapshot.child("totalpost").getValue(String.class);
                percent10=dataSnapshot.child("percent10").getValue(String.class);
                percent12=dataSnapshot.child("percent12").getValue(String.class);
                percentgrad=dataSnapshot.child("percentgrad").getValue(String.class);
                percentpost=dataSnapshot.child("percentpost").getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference emphistory_ref = FirebaseDatabase.getInstance().getReference("employment_history");
        emphistory_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){

                  emp_history_company.add(ds.child("company_name").getValue(String.class));
                  emp_history_time.add(ds.child("time_period").getValue(String.class));
                  emp_history_role.add(ds.child("role_in_company").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference skill_ref = FirebaseDatabase.getInstance().getReference("capability").child("skills");
        skill_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    skills_list.add(ds.child("skill").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference hobby_ref = FirebaseDatabase.getInstance().getReference("capability").child("hobbies");
        hobby_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    hobbies_list.add(ds.child("hobby").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference language_ref = FirebaseDatabase.getInstance().getReference("capability").child("languages");
        language_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){

                    lang_list.add(ds.child("language").getValue(String.class));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhono() {
        return phono;
    }

    public String getAddress() {
        return address;
    }

    public String getPersonaldesc() {
        return personaldesc;
    }

    public String getGrade10total() {
        return grade10total;
    }

    public String getGrade10scored() {
        return grade10scored;
    }

    public String getGrade12total() {
        return grade12total;
    }

    public String getGrade12scored() {
        return grade12scored;
    }

    public String getGradtotal() {
        return gradtotal;
    }

    public String getGradscored() {
        return gradscored;
    }

    public String getPostgradtotal() {
        return postgradtotal;
    }

    public String getPostgradscored() {
        return postgradscored;
    }

    public String getPercent10() {
        return percent10;
    }

    public String getPercent12() {
        return percent12;
    }

    public String getPercentgrad() {
        return percentgrad;
    }

    public String getPercentpost() {
        return percentpost;
    }

    public ArrayList<String> getEmp_history_company() {
        return emp_history_company;
    }

    public ArrayList<String> getEmp_history_time() {
        return emp_history_time;
    }

    public ArrayList<String> getEmp_history_role() {
        return emp_history_role;
    }

    public ArrayList<String> getSkills_list() {
        return skills_list;
    }

    public ArrayList<String> getHobbies_list() {
        return hobbies_list;
    }

    public ArrayList<String> getLang_list() {
        return lang_list;
    }
}
