package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import java.util.ArrayList;

public class Tab3 extends Fragment {

    View v;
    Button add_emp;
    RecyclerView emphistory;
    ArrayList<ArrayList<String>> emphistory_list=new ArrayList<>(3);
    DatabaseReference refrence= FirebaseDatabase.getInstance().getReference("employment_history");
    FirebaseRecyclerAdapter<emphistory_model,ViewHolder> firebaseRecyclerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.tab3, container, false);

        add_emp=v.findViewById(R.id.add_emp);
        add_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                open_dialog();

            }
        });
        emphistory = v.findViewById(R.id.emphistory);
        emphistory.setHasFixedSize(true);
        emphistory.setLayoutManager(new LinearLayoutManager(getContext()));
        emphistory.setDrawingCacheEnabled(true);
        emphistory.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        emphistory.setItemViewCacheSize(20);

        return v;
    }

    public void open_dialog(){

        emphistory_dialog emphistoryDialog=new emphistory_dialog();
        if (getFragmentManager() != null) {
            emphistoryDialog.show(getFragmentManager(),"Add employment details");
        }

    }
    //TODO refresh recyclerview


    @Override
    public void onStart() {
        super.onStart();


        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<emphistory_model, ViewHolder>(emphistory_model.class,R.layout.emp_history_item,ViewHolder.class,refrence) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, emphistory_model model, int position) {

                viewHolder.setDetails_emphistory(getContext(),model.getCompany(),model.getTime(),model.getRole());

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                return super.onCreateViewHolder(parent, viewType);
            }
        };

        emphistory.setAdapter(firebaseRecyclerAdapter);


        refrence.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                firebaseRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                firebaseRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        }



    }