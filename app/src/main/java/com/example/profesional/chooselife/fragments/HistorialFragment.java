package com.example.profesional.chooselife.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profesional.chooselife.R;
import com.example.profesional.chooselife.adapters.AdapterPager;
import com.example.profesional.chooselife.fragments.fragmentSecundarios.MesDosFragment;
import com.example.profesional.chooselife.fragments.fragmentSecundarios.MesTresFragment;
import com.example.profesional.chooselife.fragments.fragmentSecundarios.MesUnoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorialFragment extends Fragment {

    View view;
    List<TitleFragment> data;
    ViewPager pager;

    //Fragments
    MesUnoFragment mesUnoFragment;
    MesDosFragment mesDosFragment;
    MesTresFragment mesTresFragment;

    public HistorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_historial, container, false);
        init();

        return view;
    }

    private void init(){
        pager = (ViewPager) view.findViewById(R.id.pager_historial);
        data = new ArrayList<>();

        mesUnoFragment = new MesUnoFragment();
        mesDosFragment = new MesDosFragment();
        mesTresFragment = new MesTresFragment();

        data.add(mesUnoFragment);
        data.add(mesDosFragment);
        data.add(mesTresFragment);

        AdapterPager  adapterPager = new AdapterPager(getFragmentManager(),data);
        pager.setAdapter(adapterPager);
    }


}
