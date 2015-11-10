package com.example.profesional.chooselife.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.profesional.chooselife.fragments.TitleFragment;

import java.util.List;

/**
 * Created by PROFESIONAL on 08/11/2015.
 */
public class AdapterPager extends FragmentStatePagerAdapter{

    List<TitleFragment> data;

    public AdapterPager(FragmentManager fm, List<TitleFragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getTitle();
    }
}
