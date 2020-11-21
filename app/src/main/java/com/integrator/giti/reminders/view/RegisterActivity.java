package com.integrator.giti.reminders.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.integrator.giti.reminders.MenuPacienteActivity;
import com.integrator.giti.reminders.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findView();
    }

    private void findView(){

        btnRegist = findViewById(R.id.btnRegistrer);

        btnRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){
            case R.id.btnRegistrer:
                Intent intentR = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentR);
                break;

        }
    }
}