package com.example.profesional.chooselife.fragments.fragmentSecundarios;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.profesional.chooselife.PedirActivity;
import com.example.profesional.chooselife.R;
import com.example.profesional.chooselife.adapters.AdapterSinConfirmar;
import com.example.profesional.chooselife.db.Pedido;
import com.example.profesional.chooselife.fragments.TitleFragment;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SinConfirmarFragment extends TitleFragment implements View.OnClickListener {

    public static final String TITLE = "Sin Confirmar";
    List<Pedido> data;
    Pedido pedido;
    ListView list;
    TextView noHay;
    AdapterSinConfirmar adapter;
    FloatingActionButton fab;

    public SinConfirmarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sin_confirmar, container, false);
        list = (ListView) v.findViewById(R.id.list_sinconfirmas);
        data = new ArrayList<>();
        SugarContext.init(getContext());
        noHay = (TextView) v.findViewById(R.id.txt_no_pedidos);
        fab = (FloatingActionButton) v.findViewById(R.id.fab_add_pedido);

        fab.setOnClickListener(this);

        cargarPedidos();


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarPedidos();
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    public void cargarPedidos()
    {

        data = pedido.listAll(Pedido.class);
        adapter = new AdapterSinConfirmar(data,getContext());
        adapter.notifyDataSetChanged();
        adapter.init(this);

        if(data == null)
        {
            noHay.setText("No hay pedidos sin confirmar");
        }
        else
        {
            list.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), PedirActivity.class);
        startActivity(intent);
    }
}
