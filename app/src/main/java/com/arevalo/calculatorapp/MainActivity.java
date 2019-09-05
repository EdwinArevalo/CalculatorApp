package com.arevalo.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText pct1;
    EditText pct2;
    EditText pclab1;
    EditText pclab2;
    EditText pclab3;
    EditText pclab4;

    TextView promTeoria;
    TextView promLaboratorio;
    TextView promFinal;
    TextView condicion;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pct1 = findViewById(R.id.etext_pt1);
        pct2 = findViewById(R.id.etext_pt2);

        pclab1 = findViewById(R.id.etext_plab1);
        pclab2 = findViewById(R.id.etext_plab2);
        pclab3 = findViewById(R.id.etext_plab3);
        pclab4 = findViewById(R.id.etext_plab4);

        promTeoria = findViewById(R.id.tview_prom_teoria);
        promLaboratorio = findViewById(R.id.tview_prom_lab);

        promFinal = findViewById(R.id.tview_promediofinal);
        condicion = findViewById(R.id.tview_condicion);

        spinner = findViewById(R.id.spinner_sistema);

    }

    public double obtenerPromTeoria(){
        String NotaT1 = pct1.getText().toString();
        String NotaT2 = pct2.getText().toString();

        double getNotaTeo1 = Double.parseDouble(NotaT1);
        double getNotaTeo2 = Double.parseDouble(NotaT2);

        if (getNotaTeo1 > getNotaTeo2){
            return getNotaTeo1;
        }else{
            return getNotaTeo2;
        }
    }

    public double obtenerPromLab(){
        String NotaL1 = pclab1.getText().toString();
        String NotaL2 = pclab2.getText().toString();
        String NotaL3 = pclab3.getText().toString();
        String NotaL4 = pclab4.getText().toString();

        double getNotaLab1 = Double.parseDouble(NotaL1);
        double getNotaLab2 = Double.parseDouble(NotaL2);
        double getNotaLab3 = Double.parseDouble(NotaL3);
        double getNotaLab4 = Double.parseDouble(NotaL4);

        double promLab = (getNotaLab1+getNotaLab2+getNotaLab3+getNotaLab4)/4;

        return promLab;
    }



    public void Calcular(View view) {

        promLaboratorio.setText("Prom: " + obtenerPromLab());
        promTeoria.setText("Prom: " + obtenerPromTeoria());

        double promedioFinal;

        String sistemaEv = spinner.getSelectedItem().toString();

        switch (sistemaEv){
            case "A: 20%T + 80%L":
                promedioFinal = obtenerPromTeoria()*0.2 + obtenerPromLab()*0.8;
                promFinal.setText("Prom: " + promedioFinal);
                if (promedioFinal > 13){
                    condicion.setText("Aprobado");
                }else {
                    condicion.setText("Desaprobado");
                }
                break;

            case "A: 40%T + 60%L":
                promedioFinal = obtenerPromTeoria()*0.4 + obtenerPromLab()*0.6;
                promFinal.setText("Prom: " + promedioFinal);
                if (promedioFinal > 13){
                    condicion.setText("Aprobado");
                }else {
                    condicion.setText("Desaprobado");
                }
                break;

            case "A: 30%T + 70%L":
                promedioFinal = obtenerPromTeoria()*0.3 + obtenerPromLab()*0.7;
                promFinal.setText("Prom: " + promedioFinal);
                if (promedioFinal > 13){
                    condicion.setText("Aprobado");
                }else {
                    condicion.setText("Desaprobado");
                }
                break;
        }



    }
}
