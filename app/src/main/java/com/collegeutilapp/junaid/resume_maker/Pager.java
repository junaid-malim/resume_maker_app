package com.collegeutilapp.junaid.resume_maker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Pager extends FragmentStatePagerAdapter {

    private int tabCount;

    Pager(FragmentManager fm, int tabCount){
        super(fm);

        this.tabCount=tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            case 3:
                return new Tab4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
