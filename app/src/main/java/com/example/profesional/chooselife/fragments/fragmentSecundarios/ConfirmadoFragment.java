package com.example.profesional.chooselife.fragments.fragmentSecundarios;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.profesional.chooselife.R;
import com.example.profesional.chooselife.RutaActivity;
import com.example.profesional.chooselife.fragments.TitleFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmadoFragment extends TitleFragment implements View.OnClickListener {

    public static final String TITLE = "Confirmados";
    Button btn_ver_ruta, btn_toast1, btn_toast2;
    View v;

    public ConfirmadoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_confirmado, container, false);

        btn_ver_ruta = (Button) v.findViewById(R.id.btn_ver_posicion2);
        btn_toast1 = (Button) v.findViewById(R.id.btn_ver_posicion);
        btn_toast2 = (Button) v.findViewById(R.id.btn_ver_posicion3);

        btn_ver_ruta.setOnClickListener(this);
        btn_toast2.setOnClickListener(this);
        btn_toast1.setOnClickListener(this);

        return v;
    }


    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_ver_posicion2:
                Log.d("Tag","Case ver posicion2 antes de intent");
                Intent intent = new Intent(getActivity(), RutaActivity.class);
                startActivity(intent);
                Log.d("Tag","Case ver posicion2");
                break;
            case R.id.btn_ver_posicion:
                mostrarToast();
                break;
            case R.id.btn_ver_posicion3:
                mostrarToast();
                break;
        }

    }

    private void mostrarToast() {
        Toast.makeText(v.getContext(),"Función no disponible, inténtalo nuevamente el día del pedido",Toast.LENGTH_LONG).show();
    }
}
