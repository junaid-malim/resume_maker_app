package com.collegeutilapp.junaid.resume_maker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Recyclerview_adapter_emphistory extends RecyclerView.Adapter<emphistory_model.MyViewHolder> {

    private List<emphistory_model> emphistorylist;

    @NonNull
    @Override
    public emphistory_model.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.emp_history_item, viewGroup, false);

        return new emphistory_model.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull emphistory_model.MyViewHolder myViewHolder, int i) {

        emphistory_model myemphistory_model=emphistorylist.get(i);

        myViewHolder.company_name.setText(myemphistory_model.company);
        myViewHolder.time_period.setText(myemphistory_model.time);
        myViewHolder.role_in_company.setText(myemphistory_model.role);

    }

    public Recyclerview_adapter_emphistory(List<emphistory_model> emphistorylist) {
        this.emphistorylist = emphistorylist;
    }

    @Override
    public int getItemCount() {
        return emphistorylist.size();
    }
}
