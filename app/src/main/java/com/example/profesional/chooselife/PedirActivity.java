package com.example.profesional.chooselife;


import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.profesional.chooselife.db.Pedido;
import com.example.profesional.chooselife.dialogs.DialogFecha;
import com.example.profesional.chooselife.dialogs.DialogHora;
import com.orm.SugarContext;

public class PedirActivity extends AppCompatActivity {

    //views
    TextView txtHora,txtFecha;
    TextInputLayout editDdireccion, editTelefono, editMarca, editModelo, editPlaca;
    int año,mes,dia,hora,minutos;
    Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir);

        txtHora = (TextView) findViewById(R.id.txt_hora);
        txtFecha = (TextView) findViewById(R.id.txt_fecha);
        editDdireccion= (TextInputLayout) findViewById(R.id.input_pedir_direccion);
        editTelefono= (TextInputLayout) findViewById(R.id.input_pedir_telefono);
        editMarca = (TextInputLayout) findViewById(R.id.input_pedir_marca);
        editPlaca = (TextInputLayout) findViewById(R.id.input_pedir_placa);
        editModelo = (TextInputLayout) findViewById(R.id.input_pedir_modelo);
    }

    public void showDialogHora(View v){
        DialogHora hora = new DialogHora();
        hora.loadDialog(this);
        hora.show(getSupportFragmentManager(), "Hora");
    }

    public void showDialogFecha(View v){
        DialogFecha fecha = new DialogFecha();
        fecha.loadDialog(this);
        fecha.show(getSupportFragmentManager(),"fecha");

    }

    public void setHora(int hora, int minuto){
        this.hora = hora;
        this.minutos = minuto;
        txtHora.setText(" " + hora + ":" + minuto);
    }

    public void setFecha(int año,int mes, int dia){
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        txtFecha.setText(año+"/"+mes+"/"+dia);
    }
    public void pedirConductor(View v){
        pedido = new Pedido();
        pedido.setAnho(año);
        pedido.setMes(mes);
        pedido.setDia(dia);
        pedido.setHora(hora);
        pedido.setMinuto(minutos);
        pedido.setDireccion(editDdireccion.getEditText().getText().toString());
        pedido.setMarca(editMarca.getEditText().getText().toString());
        pedido.setPlaca(editPlaca.getEditText().getText().toString());
        pedido.setTelefono(editTelefono.getEditText().getText().toString());
        pedido.setModelo(editModelo.getEditText().getText().toString());

        SugarContext.init(this);
        pedido.save();

        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }

}
