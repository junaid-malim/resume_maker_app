package com.collegeutilapp.junaid.resume_maker;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Employexp {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "company_name")
    private String company_name;

    @ColumnInfo(name = "time_period")
    private String time_period;

    @ColumnInfo(name = "role_in_company")
    private String role_in_company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTime_period() {
        return time_period;
    }

    public void setTime_period(String time_period) {
        this.time_period = time_period;
    }

    public String getRole_in_company() {
        return role_in_company;
    }

    public void setRole_in_company(String role_in_company) {
        this.role_in_company = role_in_company;
    }
}
