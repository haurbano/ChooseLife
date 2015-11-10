package com.example.profesional.chooselife;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.profesional.chooselife.fragments.HistorialFragment;
import com.example.profesional.chooselife.fragments.InicioFragment;
import com.example.profesional.chooselife.fragments.PedidosFragment;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;


public class PrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener{

    //Views
    NavigationView navigationView;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;

    //Fragments
    InicioFragment inicioFragment;
    HistorialFragment historialFragment;
    PedidosFragment pedidosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initViews();


    }

    //region Init
    private void initViews(){
        //Obtener Views
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        //toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //drawer y togggle
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.setDrawerListener(this);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.toggle_open,R.string.toggle_close);


        //inicializar fragment
        inicioFragment = new InicioFragment();
        historialFragment = new HistorialFragment();
        pedidosFragment = new PedidosFragment();
        replaceFragment(inicioFragment);

        //Colocar imagen a user
        //Transformation transformation = new RoundedTransformationBuilder()
          //      .oval(true)
            //    .build();
        //Picasso.with(this)
          //      .load(R.drawable.selena)
            //    .transform(transformation)
              //  .into(imgUser);
    }
    //endregion

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.opcion_home_drawer:
                replaceFragment(inicioFragment);
                break;
            case R.id.opcino_historial_drawer:
                replaceFragment(historialFragment);
                break;
            case R.id.opcion_pedido_drawer:
                replaceFragment(pedidosFragment);
                break;
            case R.id.opcion_cerrar_sesion_drawer:
                replaceFragment(pedidosFragment);
                break;
        }
        drawer.closeDrawers();
        return false;
    }

    //region metodo para cambiar fragment principal
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_drawer,fragment);
        fragmentTransaction.commit();
    }
    //endregion

    // region Evento del drawer listener
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView,slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }
    //endregion

    //region eventos para toggle colocaos a mano

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    //endregion

    }
