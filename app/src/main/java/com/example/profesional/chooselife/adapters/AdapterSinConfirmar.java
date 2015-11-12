package com.example.profesional.chooselife.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.profesional.chooselife.R;
import com.example.profesional.chooselife.db.Pedido;
import com.example.profesional.chooselife.fragments.fragmentSecundarios.SinConfirmarFragment;
import com.orm.SugarContext;

import java.util.List;

/**
 * Created by Diana M on 11/11/2015.
 */
public class AdapterSinConfirmar extends BaseAdapter implements View.OnClickListener {

    List<Pedido> data;
    Context context;
    Integer pos;
    SinConfirmarFragment sinConfirmarFragment;
    View v;

    public AdapterSinConfirmar(List<Pedido> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        pos = position;

        if ( convertView == null)
            v= View.inflate(context, R.layout.template_pedido_sin_confirmar,null);
        else
            v= convertView;

        TextView dir,hora,fecha,carro;
        Button edit, cancel;

        dir = (TextView) v.findViewById(R.id.txt_localizacion);
        hora = (TextView) v.findViewById(R.id.txt_hora);
        fecha = (TextView) v.findViewById(R.id.txt_dia);
        carro = (TextView) v.findViewById(R.id.txt_carro);
        edit = (Button) v.findViewById(R.id.btn_editar_pedido);
        cancel = (Button) v.findViewById(R.id.btn_cancelar_pedido);

        dir.setText(data.get(position).getDireccion());
        String hr = data.get(position).getHora()+":"+data.get(position).getMinuto();
        hora.setText(hr);
        String fc= data.get(position).getDia()+"-"+data.get(position).getMes()+"-"+data.get(position).getAnho();
        fecha.setText(fc);
        String dc = data.get(position).getMarca()+" "+data.get(position).getModelo()+" - "+data.get(position).getPlaca();
        carro.setText(dc);

        edit.setOnClickListener(this);
        cancel.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_cancelar_pedido:
                eliminarPedido();
                break;
            case R.id.btn_editar_pedido:
                editarPedido();
                break;
        }
    }

    private void editarPedido() {

    }

    private void eliminarPedido() {
        SugarContext.init(context);
        Pedido pedido = data.get(pos);
        pedido.delete();
        notifyDataSetChanged();
        //sinConfirmarFragment.cargarPedidos();

    }

    public void init(SinConfirmarFragment sinConfirmarFragment)
    {
        this.sinConfirmarFragment = sinConfirmarFragment;
    }
}
