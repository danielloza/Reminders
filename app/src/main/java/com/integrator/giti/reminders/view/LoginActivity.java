package com.integrator.giti.reminders.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.integrator.giti.reminders.MenuPacienteActivity;
import com.integrator.giti.reminders.R;
import com.integrator.giti.reminders.TratamientoActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin, btnRegist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findView();
    }


    private void findView(){

        btnLogin = findViewById(R.id.btnSignIn);
        btnRegist = findViewById(R.id.btnRegistrer);

        btnLogin.setOnClickListener(this);
        btnRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){
            case R.id.btnSignIn:
                Intent intent = new Intent(LoginActivity.this, MenuPacienteActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRegistrer:
                Intent intentR = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentR);
                break;

        }
    }

}