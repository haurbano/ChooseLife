package com.example.profesional.chooselife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class RutaActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_carro,img_fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ruta);

        Log.d("Tag", "OnCreate RutaActivity");

        img_carro = (ImageView) findViewById(R.id.img_carro);
        img_fondo = (ImageView) findViewById(R.id.img_fondo);

        img_fondo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        img_carro.setX(4);
        img_carro.animate().setDuration(20000).x(getWindow().getDecorView().getWidth());

    }
}
