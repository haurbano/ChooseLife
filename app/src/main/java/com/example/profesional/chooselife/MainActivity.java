package com.example.profesional.chooselife;

import android.content.Intent;
import android.location.LocationManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String USUARIO = "anita";
    private static final String CLAVE = "1234";

    TextInputLayout user,pass;
    Button btnEntrar;
    Button btnFacebook,btnGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (TextInputLayout) findViewById(R.id.input_user);
        pass = (TextInputLayout) findViewById(R.id.input_pass);
        btnEntrar = (Button) findViewById(R.id.btn_entrar);
        btnFacebook = (Button) findViewById(R.id.btn_facebook);
        btnGoogle = (Button) findViewById(R.id.btn_google_plus);
        btnEntrar.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,PrincipalActivity.class);
        switch (v.getId()){
            case R.id.btn_entrar:
                login();
                break;
            case R.id.btn_facebook:
                startActivity(intent);
                break;
            case R.id.btn_google_plus:
                startActivity(intent);
                break;
        }
    }

    public void login()
    {
        String usr = user.getEditText().getText().toString();
        String passw = pass.getEditText().getText().toString();

        if (usr.equals(USUARIO) && passw.equals(CLAVE)){
            Intent intent = new Intent(this,PrincipalActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Usuario o contraseña incorrectas",Toast.LENGTH_SHORT).show();
        }

    }
}
