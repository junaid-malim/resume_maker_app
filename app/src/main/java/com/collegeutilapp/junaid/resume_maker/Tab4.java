package com.collegeutilapp.junaid.resume_maker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tab4 extends Fragment {

    Button addskill,addlangs,addhobby;
    RecyclerView skills,hobbies,languages;
    FirebaseRecyclerAdapter<capability_model,ViewHolder> firebaseRecyclerAdapter_skill,firebaseRecyclerAdapter_hobby,firebaseRecyclerAdapter_language;
    DatabaseReference ref_skill=FirebaseDatabase.getInstance().getReference("capability").child("skills");
    DatabaseReference ref_hobby=FirebaseDatabase.getInstance().getReference("capability").child("hobbies");
    DatabaseReference ref_language=FirebaseDatabase.getInstance().getReference("capability").child("languages");
    FloatingActionButton startgenratingpdf;

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

        skills=v.findViewById(R.id.skills);
        skills.setHasFixedSize(true);
        skills.setLayoutManager(new LinearLayoutManager(getContext()));
        skills.setDrawingCacheEnabled(true);
        skills.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        skills.setItemViewCacheSize(20);

        languages=v.findViewById(R.id.langs);
        languages.setHasFixedSize(true);
        languages.setLayoutManager(new LinearLayoutManager(getContext()));
        languages.setDrawingCacheEnabled(true);
        languages.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        languages.setItemViewCacheSize(20);

        hobbies=v.findViewById(R.id.hobbies);
        hobbies.setHasFixedSize(true);
        hobbies.setLayoutManager(new LinearLayoutManager(getContext()));
        hobbies.setDrawingCacheEnabled(true);
        hobbies.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        hobbies.setItemViewCacheSize(20);

        startgenratingpdf=v.findViewById(R.id.startgenratingpdf);
        startgenratingpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),final_screen.class);
                startActivity(intent);
            }
        });

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        firebaseRecyclerAdapter_skill=new FirebaseRecyclerAdapter<capability_model, ViewHolder>(capability_model.class,R.layout.capability_item,ViewHolder.class,ref_skill) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, capability_model model, int position) {

                viewHolder.setDetail_skill(model.skill);

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return super.onCreateViewHolder(parent, viewType);
            }
        };

        firebaseRecyclerAdapter_hobby=new FirebaseRecyclerAdapter<capability_model, ViewHolder>(capability_model.class,R.layout.capability_item,ViewHolder.class,ref_hobby) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, capability_model model, int position) {

                viewHolder.setDetail_hobby(model.hobby);

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return super.onCreateViewHolder(parent, viewType);
            }
        };

        firebaseRecyclerAdapter_language=new FirebaseRecyclerAdapter<capability_model, ViewHolder>(capability_model.class,R.layout.capability_item,ViewHolder.class,ref_language) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, capability_model model, int position) {

                viewHolder.setDetail_language(model.language);

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return super.onCreateViewHolder(parent, viewType);
            }
        };

        skills.setAdapter(firebaseRecyclerAdapter_skill);
        hobbies.setAdapter(firebaseRecyclerAdapter_hobby);
        languages.setAdapter(firebaseRecyclerAdapter_language);

        ref_skill.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_skill.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_skill.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                firebaseRecyclerAdapter_skill.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_skill.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                firebaseRecyclerAdapter_skill.notifyDataSetChanged();
            }
        });

        ref_hobby.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_hobby.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_hobby.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                firebaseRecyclerAdapter_hobby.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_hobby.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                firebaseRecyclerAdapter_hobby.notifyDataSetChanged();
            }
        })  ;

        ref_language.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_language.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_language.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                firebaseRecyclerAdapter_language.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter_language.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                firebaseRecyclerAdapter_language.notifyDataSetChanged();
            }
        });

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
