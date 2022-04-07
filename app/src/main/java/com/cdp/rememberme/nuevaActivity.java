package com.cdp.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cdp.rememberme.db.DbContactos;

import java.util.Calendar;

public class nuevaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtTitulo, txtDireccion, txtDescripcion,eFecha,eHora;
    Button btnGuarda,bFecha,bHora;

    private int dia, mes, anio,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);


        bFecha=(Button)findViewById(R.id.bFecha);
        bHora=(Button)findViewById(R.id.bHora);
        eFecha=(EditText) findViewById(R.id.eFecha);
        eHora=(EditText) findViewById(R.id.eHora);
        bFecha.setOnClickListener(this);
        bHora.setOnClickListener(this);

        txtTitulo= findViewById(R.id.txtTitulo);
        txtDescripcion= findViewById(R.id.txtDescripcion);
        txtDireccion = findViewById(R.id.txtDireccion);
        btnGuarda= findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbContactos dbContactos= new DbContactos(nuevaActivity.this);
                long id =dbContactos.insertarContactos(txtTitulo.getText().toString(), txtDireccion.getText().toString(),
                        txtDescripcion.getText().toString());

                if(id>0){
                    Toast.makeText(nuevaActivity.this,"REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(nuevaActivity.this,"Error al guardar el registro", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    private void limpiar(){
        txtTitulo.setText("");
        txtDireccion.setText("");
        txtDescripcion.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v == bFecha){
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            anio=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    eFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            } ,2022,mes,dia);
            datePickerDialog.show();
        }
        if(v == bHora){
            final Calendar c = Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    eHora.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
    }
}