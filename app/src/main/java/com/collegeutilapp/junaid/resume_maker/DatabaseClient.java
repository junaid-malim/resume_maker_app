package com.collegeutilapp.junaid.resume_maker;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

import java.security.PrivateKey;

public class DatabaseClient {

    private Context context;
    private static DatabaseClient mInstance;

    private AppDatabase appDatabase;

    private DatabaseClient(Context context){

        this.context=context;

        appDatabase= Room.databaseBuilder(context,AppDatabase.class,"empdata").build();

    }

    public static synchronized DatabaseClient getInstance(Context context){

        if(mInstance==null) {

            mInstance=new DatabaseClient(context);
        
        }

        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
