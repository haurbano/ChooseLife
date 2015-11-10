package com.example.profesional.chooselife.dialogs;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TimePicker;

import com.example.profesional.chooselife.PedirActivity;
import com.example.profesional.chooselife.R;

import java.util.Calendar;

/**
 * Created by PROFESIONAL on 09/11/2015.
 */
public class DialogHora extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    PedirActivity pedirActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c =  Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), R.style.AppTheme,this,hora,min,true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        pedirActivity.setHora(hourOfDay,minute);
    }

    public void loadDialog(PedirActivity pedirActivity){
        this.pedirActivity = pedirActivity;
    }
}
