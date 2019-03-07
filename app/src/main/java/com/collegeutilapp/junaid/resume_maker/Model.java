package com.collegeutilapp.junaid.resume_maker;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private String name,phoneno,email,res_address,personaldiscr,grade10total,grade10scored,grade12total,grade12scored,gradtotal,gradscored,postgradtotal,postgradscored;
    private ArrayList<String> emp_history_company=new ArrayList();
    private ArrayList<String> emp_history_time=new ArrayList();
    private ArrayList<String> emp_history_role=new ArrayList();

    private List skills_list=new ArrayList<String>();
    private List hobbies_list=new ArrayList<String>();
    private List lang_list=new ArrayList<String>();

    public void set_personal_info(String name,String phoneno,String email,String res_address,String personaldiscr){

        this.name=name;
        this.phoneno="+91"+phoneno;
        this.email=email;
        this.res_address=res_address;
        this.personaldiscr=personaldiscr;

    }

    public void set_grades_info(String grade10scored,String grade10total,String grade12scored,String grade12total,String gradscored,String gradtotal,String postgradscored,String postgradtotal){
        this.grade10scored=grade10scored;
        this.grade10total=grade10total;
        this.grade12scored=grade12scored;
        this.grade12total=grade12total;
        this.gradscored=gradscored;
        this.gradtotal=gradtotal;
        this.postgradscored=postgradscored;
        this.postgradtotal=postgradtotal;
    }

    public void set_emp_history(String emp_history_company_name,String emp_history_time_period,String emp_history_job_role){

        emp_history_company.add(emp_history_company_name);
        emp_history_role.add(emp_history_job_role);
        emp_history_time.add(emp_history_time_period);

    }

    public void set_slh(String skill,String lang,String hobbies){

        skills_list.add(skill);
        lang_list.add(lang);
        hobbies_list.add(hobbies);
    }

    //TODO getter method remains

    public List getLang_list() {
        return lang_list;
    }

    public void setLang_list(List lang_list) {
        this.lang_list = lang_list;
    }

    public List getSkills_list() {
        return skills_list;
    }

    public void setSkills_list(List skills_list) {
        this.skills_list = skills_list;
    }

    public List getHobbies_list() {
        return hobbies_list;
    }

    public void setHobbies_list(List hobbies_list) {
        this.hobbies_list = hobbies_list;
    }

    public List getEmp_history_time() {
        return emp_history_time;
    }

    public void setEmp_history_time(ArrayList emp_history_time) {
        this.emp_history_time = emp_history_time;
    }

    public List getEmp_history_role() {
        return emp_history_role;
    }

    public void setEmp_history_role(ArrayList emp_history_role) {
        this.emp_history_role = emp_history_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRes_address() {
        return res_address;
    }

    public void setRes_address(String res_address) {
        this.res_address = res_address;
    }

    public String getGrade10total() {
        return grade10total;
    }

    public void setGrade10total(String grade10total) {
        this.grade10total = grade10total;
    }

    public String getGrade10scored() {
        return grade10scored;
    }

    public void setGrade10scored(String grade10scored) {
        this.grade10scored = grade10scored;
    }

    public String getGrade12total() {
        return grade12total;
    }

    public void setGrade12total(String grade12total) {
        this.grade12total = grade12total;
    }

    public String getGrade12scored() {
        return grade12scored;
    }

    public void setGrade12scored(String grade12scored) {
        this.grade12scored = grade12scored;
    }

    public String getGradtotal() {
        return gradtotal;
    }

    public void setGradtotal(String gradtotal) {
        this.gradtotal = gradtotal;
    }

    public String getGradscored() {
        return gradscored;
    }

    public void setGradscored(String gradscored) {
        this.gradscored = gradscored;
    }

    public String getPostgradtotal() {
        return postgradtotal;
    }

    public void setPostgradtotal(String postgradtotal) {
        this.postgradtotal = postgradtotal;
    }

    public String getPostgradscored() {
        return postgradscored;
    }

    public void setPostgradscored(String postgradscored) {
        this.postgradscored = postgradscored;
    }

    public String getPersonaldiscr() {
        return personaldiscr;
    }

    public void setPersonaldiscr(String personaldiscr) {
        this.personaldiscr = personaldiscr;
    }

    public List getEmp_history_company() {
        return emp_history_company;
    }

    public void setEmp_history_company(ArrayList emp_history_company) {
        this.emp_history_company = emp_history_company;
    }
}
