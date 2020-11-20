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
import android.widget.Toast;

import com.integrator.giti.reminders.model.response.MedicamentoResponse;
import com.integrator.giti.reminders.network.RemindersInterface;
import com.integrator.giti.reminders.network.RemindersService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//loza cruz - gutierrez santana

public class MedicamentoActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etNombre;
    private EditText etTipoMed;
    private Button btnGuardar;
    private ImageView imageMed;

    RemindersService remindersService;
    RemindersInterface remindersInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);

        findView();
        retrofitInit();

    }

    private void findView(){
        //nombre medicamento
        etNombre = findViewById(R.id.etNombre);
        //tipo de medicamento
        etTipoMed = findViewById(R.id.etTipoMed);
        //boton para guardar el medicamento
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
        //imagen medicamento
        imageMed = findViewById(R.id.imageMed);
    }

    //Obtenemos la instancia del retrofit
    private void retrofitInit() {
        remindersService = RemindersService.getInstance();
        remindersInterface = remindersService.getAuthApiService();
    }

    @Override
    public void onClick(View view) {
        //imagen medicamento
       // cargarImagen();

        int id = view.getId();
        switch (id){
            case R.id.btnGuardar:
                getMedicamentos();
                break;
        }
    }

    //obtener los medicamentos
    private void getMedicamentos(){
        Call<List<MedicamentoResponse>> getAllMedicamentos = remindersInterface.getListMedicamentos(2);
        getAllMedicamentos.enqueue(new Callback<List<MedicamentoResponse>>() {
            @Override
            public void onResponse(Call<List<MedicamentoResponse>> call, Response<List<MedicamentoResponse>> response) {
                if (response.isSuccessful()){
                    response.body();
                    Toast.makeText(MedicamentoActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    response.errorBody();
                    Toast.makeText(MedicamentoActivity.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MedicamentoResponse>> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());
                Toast.makeText(MedicamentoActivity.this, t.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
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