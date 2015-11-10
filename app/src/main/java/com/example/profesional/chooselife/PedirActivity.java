package com.example.profesional.chooselife;


import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.profesional.chooselife.dialogs.DialogFecha;
import com.example.profesional.chooselife.dialogs.DialogHora;

public class PedirActivity extends AppCompatActivity {

    //views
    TextView txtHora,txtFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir);

        txtHora = (TextView) findViewById(R.id.txt_hora);
        txtFecha = (TextView) findViewById(R.id.txt_fecha);

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
        txtHora.setText(" " + hora + ":" + minuto);
    }

    public void setFecha(int año,int mes, int dia){
        txtFecha.setText(año+"/"+mes+"/"+dia);
    }
    public void pedirConductor(View v){
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivity(intent);
    }

}
