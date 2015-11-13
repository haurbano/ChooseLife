package com.example.profesional.chooselife.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profesional.chooselife.R;
import com.example.profesional.chooselife.adapters.AdapterPager;
import com.example.profesional.chooselife.fragments.fragmentSecundarios.ConfirmadoFragment;
import com.example.profesional.chooselife.fragments.fragmentSecundarios.SinConfirmarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PedidosFragment extends Fragment {

    View view;
    ViewPager pager;

    ConfirmadoFragment confirmadoFragment;
    SinConfirmarFragment sinConfirmarFragment;

    List<TitleFragment> data;

    public PedidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pedidos, container, false);
        init();
        return view;
    }

    public void init(){
        pager = (ViewPager) view.findViewById(R.id.pager_pedidos);
        confirmadoFragment = new ConfirmadoFragment();
        sinConfirmarFragment = new SinConfirmarFragment();

        data = new ArrayList<>();

        data.add(confirmadoFragment);
        data.add(sinConfirmarFragment);

        AdapterPager adapter = new AdapterPager(getFragmentManager(),data);

        pager.setAdapter(adapter);
    }
}
