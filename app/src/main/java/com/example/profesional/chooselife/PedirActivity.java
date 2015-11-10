package com.example.profesional.chooselife;


import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.profesional.chooselife.dialogs.DialogHora;

public class PedirActivity extends AppCompatActivity {

    //views
    TextView txtHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir);

        txtHora = (TextView) findViewById(R.id.txt_hora);

    }

    public void showDialogHora(View v){
        DialogHora hora = new DialogHora();
        hora.loadDialog(this);
        hora.show(getSupportFragmentManager(), "Hora");
    }

    public void setHora(int hora, int minuto){
        txtHora.setText("Hora: "+hora+":"+minuto );
    }

}
