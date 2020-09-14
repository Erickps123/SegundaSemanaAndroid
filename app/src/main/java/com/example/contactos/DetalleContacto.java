package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class DetalleContacto extends AppCompatActivity {

    TextView textFecha, textnombre, texttelefono, textdireccion, textcorreo;
    Button EditarDatosBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        textnombre = (TextView) findViewById(R.id.viewNombre);
        texttelefono = (TextView) findViewById(R.id.viewTelefono);
        textFecha = (TextView) findViewById(R.id.viewFecha);
        textdireccion = (TextView) findViewById(R.id.viewDireccion);
        textcorreo = (TextView) findViewById(R.id.viewCorreo);

        Bundle params = getIntent().getExtras();

        String nombre= params.getString(getResources().getString(R.string.paramNombre));
        String telefono= params.getString(getResources().getString(R.string.paramTelefono));
        String fecha= params.getString(getResources().getString(R.string.paramFecha));
        String direccion= params.getString(getResources().getString(R.string.paramDireccion));
        String correo= params.getString(getResources().getString(R.string.paramCorreo));


        textnombre.setText(nombre);
        texttelefono.setText("Telefono: " +telefono);
        textFecha.setText("Fecha de Nacimiento: " +fecha);
        textdireccion.setText(": " + direccion);
        textcorreo.setText("Correo: " +correo);


        EditarDatosBtn = (Button) findViewById(R.id.EditButton);
        EditarDatosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParamsBack();
            }
        });
    }
    private void ParamsBack(){
       finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            ParamsBack();
        }
        return super.onKeyDown(keyCode, event);
    }
}