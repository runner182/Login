package com.example.bulle.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserScreen extends AppCompatActivity {

    TextView tv_nombre,tv_email,tv_telefono;
    Button btn_cerrarSesion;
    Context context= this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        tv_nombre=(TextView)findViewById(R.id.tv_nombre);
        tv_email=(TextView)findViewById(R.id.tv_email);
        tv_telefono=(TextView)findViewById(R.id.tv_telefono);

        SharedPreferences preferences=getSharedPreferences("sesion", Context.MODE_PRIVATE);
        tv_nombre.setText(preferences.getString("nombre",""));
        tv_telefono.setText(preferences.getString("telefono",""));
        tv_email.setText(preferences.getString("email",""));

        btn_cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=getSharedPreferences("sesion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("logged","false");
                editor.commit();

                Intent intent= new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
