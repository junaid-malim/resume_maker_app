package com.collegeutilapp.junaid.resume_maker;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface Employ_dao {

    @Query("SELECT * FROM Employexp")
    List<Employexp> getAll();


    @Insert
    void insert(Employexp employ_exp);

    @Delete
    void delete(Employexp employ_exp);

    @Update
    void update(Employexp employ_exp);

}