package com.collegeutilapp.junaid.resume_maker;

public class emphistory_model {

    private String company_name,time_period,role_in_company;

    public emphistory_model(String company_name,String time_period,String role_in_company) {

        this.company_name=company_name;
        this.time_period=time_period;
        this.role_in_company=role_in_company;

    }

    public emphistory_model() {
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

