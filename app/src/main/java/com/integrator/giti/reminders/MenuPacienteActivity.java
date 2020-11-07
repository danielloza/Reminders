package com.integrator.giti.reminders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MenuPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_paciente);

        //menu paciente

        CircleMenu circleMenu = findViewById(R.id.circleMenu);
        final String arrayName []= {"Medicamento", "Paciente","Recordatorios","Tratamientos","Citas","Información"};

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.centromenu,R.drawable.centromenu)
                .addSubMenu(Color.parseColor("#a6d5e5"),R.drawable.medicamento)
                .addSubMenu(Color.parseColor("#85c3b4"),R.drawable.paciente)
                .addSubMenu(Color.parseColor("#fbed60"),R.drawable.recordatorio)
                .addSubMenu(Color.parseColor("#96bce9"),R.drawable.tratamiento)
                .addSubMenu(Color.parseColor("#ddcfe8"),R.drawable.citas)
                .addSubMenu(Color.parseColor("#96bce9"),R.drawable.informacion)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {
                        if(i == 0){
                            Toast.makeText(MenuPacienteActivity.this,"" + arrayName[i], Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MenuPacienteActivity.this, MedicamentoActivity.class);
                            startActivity(intent);
                        }else if (i == 3){
                            Toast.makeText(MenuPacienteActivity.this,"" + arrayName[i], Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MenuPacienteActivity.this, TratamientoActivity.class);
                            startActivity(intent);
                        }

                    }
                });
    }
}