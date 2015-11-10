package com.example.profesional.chooselife.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.profesional.chooselife.PedirActivity;
import com.example.profesional.chooselife.R;

import java.util.Calendar;

/**
 * Created by PROFESIONAL on 09/11/2015.
 */
public class DialogFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    PedirActivity pedirActivity;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int año = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), R.style.AppTheme,this,año,mes,dia);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        pedirActivity.setFecha(year,monthOfYear,dayOfMonth);
    }

    public void loadDialog(PedirActivity pedirActivity){
        this.pedirActivity = pedirActivity;
    }
}
