package com.alissoncorreachervinski.astrocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity {

    private EditText editPorcentagem;
    private EditText editDistanciaFocal;
    private TextView textResultado;


    RadioGroup radioGroup;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editDistanciaFocal = findViewById(R.id.distanciaFocal);
        editPorcentagem = findViewById(R.id.porcentagem);
        textResultado = findViewById(R.id.textResultado);
        radioGroup = findViewById(R.id.radioGroup);



        Button buttonApply = findViewById(R.id.button_calc);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                DecimalFormat myDF = new DecimalFormat("0.#");
                DecimalFormat myFOV = new DecimalFormat("0.00");

                if (TextUtils.isEmpty(editDistanciaFocal.getText().toString())) {
                    textResultado.setText("Preencha os campos");

                }else if(TextUtils.isEmpty(editPorcentagem.getText().toString())){
                    textResultado.setText("Preencha os campos");
                }else{
                    Double distanciaFocal = Double.parseDouble(editDistanciaFocal.getText().toString());
                    Double porcentagem = Double.parseDouble(editPorcentagem.getText().toString());
                    textResultado.setText(radioButton.getText().toString());
                    if (radioGroup.getCheckedRadioButtonId() == 2131231071) {
                        int sensor = 24;
                        double por = (porcentagem*0.01);
                        double tr = (2*Math.atan(sensor/(2*distanciaFocal)));
                        double fov = tr * (180/Math.PI);
                        double rotacao = (por*(fov/0.25));
                        double min = Math.floor(rotacao);
                        double sec = Math.floor(((rotacao % 1)*60));
                        double regra = (500/distanciaFocal);

                        //textResultado.setText("texto ");
                        textResultado.setText("FOV: "+ myFOV.format(fov) + "º"+"\n\nTempo para reenquadrar: "+myDF.format(min)+" minutos e "+ myDF.format(sec)+ " segundos"+"\n\nTempo de exposição sem rastro: "+myDF.format(regra)+" segundos");



                    }else {
                        int sensor = 15;
                        double por = (porcentagem*0.01);
                        double tr = (2*Math.atan(sensor/(2*distanciaFocal)));
                        double fov = tr * (180/Math.PI);
                        double rotacao = (por*(fov/0.25));
                        double min = Math.floor(rotacao);
                        double sec = Math.floor(((rotacao % 1)*60));
                        double regra = (300/distanciaFocal);
                        textResultado.setText("tex1to "+ radioId);

                       // textResultado.setText("Tempo: "+myDF.format(min)+" minutos e "+ myDF.format(sec)+" segundos");
                       textResultado.setText("FOV: "+ myFOV.format(fov) + "º"+"\n\nTempo para reenquadrar: "+myDF.format(min)+" minutos e "+ myDF.format(sec)+ " segundos"+"\n\nTempo de exposição sem rastro: "+myDF.format(regra)+" segundos");

                    }

                }







            }


        });
        }



    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

    }



}