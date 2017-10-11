package com.example.diana.calculadora_imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class inicio extends AppCompatActivity {

    public EditText altura;
    public EditText peso;
    public double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        altura = (EditText) findViewById(R.id.txt_altura);
        peso = (EditText) findViewById(R.id.txt_peso);
    }

    public void calcular (View view){
        String v1 = altura.getText().toString();
        String v2 = peso.getText().toString();

        if (!v1.equals("") || !v2.equals("")){
            float v_altura = Float.valueOf(altura.getText().toString());
            v_altura = v_altura / 100;
            float v_peso = Float.valueOf(peso.getText().toString());
            this.imc = (v_peso / (Math.pow(v_altura, 2)));

            Intent i = new Intent(this, clasificacion.class);
            i.putExtra("imc", String.valueOf(this.imc));
            startActivity(i);
        }
        else {
            Toast msg = Toast.makeText(getApplicationContext(),getResources().getString(R.string.msg1), Toast.LENGTH_SHORT);
            msg.show();
        }
    }


    public void about(View view){
        Intent i = new Intent(this, about.class );
        startActivity(i);
    }
}
