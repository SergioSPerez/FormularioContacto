package com.sesapepe.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText eldia;
    Calendar myCalendario = Calendar.getInstance();
    TextInputEditText tietNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eldia = findViewById(R.id.tietFechaNac);
        eldia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, myCalendario.get(Calendar.YEAR), myCalendario.get(Calendar.MONTH), myCalendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final EditText nom;
        nom = (EditText)findViewById(R.id.tietNombre);
        final EditText fec;
        fec = (EditText)findViewById(R.id.tietFechaNac);
        final EditText tel;
        tel = (EditText)findViewById(R.id.tietTelefono);
        final EditText ema;
        ema = (EditText)findViewById(R.id.tietEmail);
        final EditText des;
        des = (EditText)findViewById(R.id.tietDesContacto);

        Button mibtn =(Button) findViewById(R.id.btnMiboton);
        mibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),PantallaConfirmacion.class);
                intent.putExtra("nombre",nom.getText().toString());
                intent.putExtra("fecha",fec.getText().toString());
                intent.putExtra("telefono",tel.getText().toString());
                intent.putExtra("email",ema.getText().toString());
                intent.putExtra("descripcion",des.getText().toString());
                startActivityForResult(intent,0);

            }
        });
    }


    DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ann, int mes, int dia) {
            myCalendario.set(Calendar.YEAR, ann);
            myCalendario.set(Calendar.MONTH, mes);
            myCalendario.set(Calendar.DAY_OF_MONTH, dia);
            actualizarInput();
        }
    };

    private void actualizarInput(){
        String formatoDeFecha = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.ENGLISH);
        eldia.setText(sdf.format(myCalendario.getTime()));
    }

}