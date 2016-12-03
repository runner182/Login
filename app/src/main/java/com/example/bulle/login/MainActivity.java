package com.example.bulle.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_user,et_password;
    Button btn_iniciar;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences=getSharedPreferences("sesion", Context.MODE_PRIVATE);
        if(preferences.getString("logged", "").equals("true")){
            Intent intent=new Intent(context,UserScreen.class);
            startActivity(intent);
        }

        et_user=(EditText)findViewById(R.id.et_user);
        et_password=(EditText)findViewById(R.id.et_password);
        btn_iniciar=(Button)findViewById(R.id.btn_iniciar);

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
