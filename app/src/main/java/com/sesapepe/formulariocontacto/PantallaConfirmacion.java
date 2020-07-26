package com.sesapepe.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaConfirmacion extends AppCompatActivity {

    TextView tvDatoNombre;
    TextView tvDatoFechaNac;
    TextView tvDatoTelefono;
    TextView tvDatoEmail;
    TextView tvDatoDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_confirmacion);

        Bundle datos = getIntent().getExtras();
        String nomimp = datos.getString("nombre");
        String fecimp = datos.getString("fecha");
        String telimp = datos.getString("telefono");
        String emaimp = datos.getString("email");
        String desimp = datos.getString("descripcion");
        tvDatoNombre = (TextView)findViewById(R.id.tvDatoNombre);
        tvDatoFechaNac = (TextView)findViewById(R.id.tvDatoFechaNac);
        tvDatoTelefono = (TextView)findViewById(R.id.tvDatoTelefono);
        tvDatoEmail = (TextView)findViewById(R.id.tvDatoEmail);
        tvDatoDescripcion = (TextView)findViewById(R.id.tvDatoDescripcion);

        tvDatoNombre.setText(nomimp);
        tvDatoFechaNac.setText(fecimp);
        tvDatoTelefono.setText(telimp);
        tvDatoEmail.setText(emaimp);
        tvDatoDescripcion.setText(desimp);

        Button btn =(Button) findViewById(R.id.btnMibotonE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }
}