package com.collegeutilapp.junaid.resume_maker;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {Employexp.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract Employ_dao employ_dao();

}
