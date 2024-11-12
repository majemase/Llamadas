package com.example.llamadas;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView btncontacto0, btncontacto1, btncontacto2, btncontacto3, btncontacto4, btncontacto5;
    private static final int REQUEST_CALL_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btncontacto0.setOnClickListener(v -> iniciarLlamada("722405176"));
        btncontacto1.setOnClickListener(v -> iniciarLlamada("653242461"));
        btncontacto2.setOnClickListener(v -> iniciarLlamada("653242462"));
        btncontacto3.setOnClickListener(v -> iniciarLlamada("722405176"));
        btncontacto4.setOnClickListener(v -> iniciarLlamada("722405176"));
        btncontacto5.setOnClickListener(v -> iniciarLlamada("722405176"));
    }

    public void init(){
        btncontacto0 = findViewById(R.id.btncontacto0);
        btncontacto1 = findViewById(R.id.btncontacto1);
        btncontacto2 = findViewById(R.id.btncontacto2);
        btncontacto3 = findViewById(R.id.btncontacto3);
        btncontacto4 = findViewById(R.id.btncontacto4);
        btncontacto5 = findViewById(R.id.btncontacto5);
    }

    public void iniciarLlamada(String numero){
        if(permisos()){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+numero));
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        }
    }

    public boolean permisos(){
        boolean permisos = false;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        }else{
            permisos = true;
        }
        return permisos;
    }

}