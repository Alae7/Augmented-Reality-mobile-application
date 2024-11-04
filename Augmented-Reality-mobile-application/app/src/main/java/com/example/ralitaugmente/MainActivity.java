package com.example.ralitaugmente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Cube(View view){
        Intent intent = new Intent(MainActivity.this, CubeActivity2.class);
        startActivity(intent);
    }
    public void Sphere(View view){

        Intent intent = new Intent(MainActivity.this, SphereActivity4.class);
        startActivity(intent);
    }

    public void Cylinder(View view){

        Intent intent = new Intent(MainActivity.this, CylinderActivity3.class);
        startActivity(intent);
    }
    public  void Cone(View view){

        Intent intent = new Intent(MainActivity.this, ConeActivity5.class);
        startActivity(intent);

    }
    public void  CustomShape(View view){

        Intent intent = new Intent(MainActivity.this, CustomShapeActivity6.class);
        startActivity(intent);

    }
    public void Exit(View view){
        finish();
    }
}