package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    TextInputEditText textFecha, textnombre, texttelefono, textdireccion, textcorreo;
    Button sendButton;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textnombre = (TextInputEditText) findViewById(R.id.textUsuario);
        texttelefono = (TextInputEditText) findViewById(R.id.textTelefono);
        textdireccion = (TextInputEditText) findViewById(R.id.textDireccion);
        textcorreo = (TextInputEditText) findViewById(R.id.textEmail);
        textFecha = (TextInputEditText) findViewById(R.id.textFechaNac);
        textFecha.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                       textFecha.setText(i2+"/"+i1+"/"+i);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    sendButton = (Button) findViewById(R.id.ButtonSend);
    sendButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if((!textnombre.getText().toString().isEmpty()) && (!texttelefono.getText().toString().isEmpty())) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.paramNombre), textnombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.paramTelefono), texttelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.paramCorreo), textcorreo.getText().toString());
                intent.putExtra(getResources().getString(R.string.paramDireccion), textdireccion.getText().toString());
                intent.putExtra(getResources().getString(R.string.paramFecha), textFecha.getText().toString());
                startActivity(intent);
                //finish();
            }else{
                Snackbar.make(view, R.string.text_label, Snackbar.LENGTH_SHORT).show();
            }


        }
    });

    }

}