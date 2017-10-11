package com.example.diana.calculadora_imc;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class clasificacion extends AppCompatActivity {

    public TextView imc;
    public TextView clasific;
    public ImageView imagen;
    double valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);

        imc = (TextView) findViewById(R.id.txt_imc);
        clasific = (TextView) findViewById(R.id.txt_cl);
        imagen = (ImageView) findViewById(R.id.img);

        Bundle bundle = getIntent().getExtras();

        DecimalFormat formato = new DecimalFormat("#.##");
        valor = Double.valueOf(bundle.getString("imc"));
        String v_imc = formato.format(valor);

        imc.setText(v_imc);

        resultado();
    }

    public void resultado(){
        if (valor < 18.50){
            clasific.setText(getResources().getString(R.string.bpeso));
            imagen.setImageResource(R.drawable.pbajo);
        }
        if (valor > 18.49 && valor <25){
            clasific.setText(getResources().getString(R.string.normal));
            imagen.setImageResource(R.drawable.normal);

        }
        if (valor >= 25 && valor < 30 ){
            clasific.setText(getResources().getString(R.string.sobrepeso));
            imagen.setImageResource(R.drawable.sobrep);

        }
        if (valor >= 30){
            clasific.setText(getResources().getString(R.string.obesidad));
            imagen.setImageResource(R.drawable.obeso);

        }
    }
}
