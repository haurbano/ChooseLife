package com.example.profesional.chooselife.fragments.fragmentSecundarios;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profesional.chooselife.R;
import com.example.profesional.chooselife.fragments.TitleFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmadoFragment extends TitleFragment {

    public static final String TITLE = "Confirmados";

    public ConfirmadoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmado, container, false);
    }


    @Override
    public String getTitle() {
        return TITLE;
    }
}
