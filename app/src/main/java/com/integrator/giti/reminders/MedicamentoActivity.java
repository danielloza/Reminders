package com.integrator.giti.reminders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

//loza cruz - gutierrez santana

public class MedicamentoActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etNombre;
    private EditText etTipoMed;
    private Button btnGuardar;
    private ImageView imageMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);
        //nombre medicamento
        etNombre = (EditText) findViewById(R.id.etNombre);
        //tipo de medicamento
        etTipoMed = (EditText) findViewById(R.id.etTipoMed);
        //boton para guardar el medicamento
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
        //imagen medicamento
        imageMed = (ImageView) findViewById(R.id.imageMed);
    }

    @Override
    public void onClick(View view) {
        //imagen medicamento
        cargarImagen();
    }

    //imagen medicamento
    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),10);
    }

    //imagen medicamento
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri path = data.getData();
            imageMed.setImageURI(path);
        }
    }

    public void onClickMed(View view){
        //guardar medicamento

    }



}