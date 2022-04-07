package com.cdp.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this, PrincipalActivity.class);
                startActivity(intent);//para que se pase a la otra actividad
                finish();// se termina la actividdad y se pasa a la otra


            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 2000);

    }


}