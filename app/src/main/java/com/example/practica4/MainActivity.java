package com.example.practica4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView screen;
    private ArrayList<String> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        datos = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadComponents();
    }

    private void loadComponents() {
        Button btn1 = this.findViewById(R.id.btnUno);
        btn1.setOnClickListener(this);
        Button btn2 = this.findViewById(R.id.btnDos);
        btn2.setOnClickListener(this);
        Button btn3 = this.findViewById(R.id.btnTres);
        btn3.setOnClickListener(this);
        Button btn4 = this.findViewById(R.id.btnCuatro);
        btn4.setOnClickListener(this);
        Button btn5 = this.findViewById(R.id.btnCinco);
        btn5.setOnClickListener(this);
        Button btn6 = this.findViewById(R.id.btnSeis);
        btn6.setOnClickListener(this);
        Button btn7 = this.findViewById(R.id.btnSiete);
        btn7.setOnClickListener(this);
        Button btn8 = this.findViewById(R.id.btnOcho);
        btn8.setOnClickListener(this);
        Button btn9 = this.findViewById(R.id.btnNueve);
        btn9.setOnClickListener(this);
        Button btn0 = this.findViewById(R.id.btnCero);
        btn0.setOnClickListener(this);
        Button btnDiv = this.findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        Button btnMul = this.findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        Button btnResta = this.findViewById(R.id.btnResta);
        btnResta.setOnClickListener(this);
        Button btnSuma = this.findViewById(R.id.btnSuma);
        btnSuma.setOnClickListener(this);
        Button btnC = this.findViewById(R.id.btnC);
        btnC.setOnClickListener(this);
        Button btnIgual = this.findViewById(R.id.btnIgual);
        btnIgual.setOnClickListener(this);

        screen = this.findViewById(R.id.textViewScreen);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUno:{
                screen.setText(screen.getText() + "1");
                break;
            }
            case R.id.btnDos:{
                screen.setText(screen.getText() + "2");
                break;
            }
            case R.id.btnTres:{
                screen.setText(screen.getText() + "3");
                break;
            }
            case R.id.btnCuatro:{
                screen.setText(screen.getText() + "4");
                break;
            }
            case R.id.btnCinco:{
                screen.setText(screen.getText() + "5");
                break;
            }
            case R.id.btnSeis:{
                screen.setText(screen.getText() + "6");
                break;
            }
            case R.id.btnSiete:{
                screen.setText(screen.getText() + "7");
                break;
            }
            case R.id.btnOcho:{
                screen.setText(screen.getText() + "8");
                break;
            }
            case R.id.btnNueve:{
                screen.setText(screen.getText() + "9");
                break;
            }
            case R.id.btnCero:{
                screen.setText(screen.getText() + "0");
                break;
            }
            case R.id.btnDiv:{
                screen.setText(screen.getText() + "/");
                break;
            }
            case R.id.btnMul:{
                screen.setText(screen.getText() + "*");
                break;
            }
            case R.id.btnResta:{
                screen.setText(screen.getText() + "-");
                break;
            }
            case R.id.btnSuma:{
                screen.setText(screen.getText() + "+");
                break;
            }
            case R.id.btnC:{
                screen.setText("");
                break;
            }
            case R.id.btnIgual:{
                screen.setText(result(screen.getText().toString()));
                break;
            }
        }
    }

    private String result(String cad){
        Pattern pm = Pattern.compile("([\\d]*[.])?\\w+[/]([\\d]*[.])?[\\d]+");
        Pattern pm1 = Pattern.compile("([\\d]*[.])?[\\d]+");
        Matcher m = pm.matcher(cad);
        Matcher m1;
        //division
        while(m.find()) {
            float result = 1;
            int cont = 0;
            m1 = pm1.matcher(m.group().toString());
            while (m1.find()){
                if (cont == 0){
                    result = Float.parseFloat(m1.group());
                    cont++;
                } else{
                    result = result/Float.parseFloat(m1.group());
                }
            }
            cad = cad.replace(m.group(),Float.toString(result));
            m = pm.matcher(cad);
        }
            //Multiplicacion
        pm = Pattern.compile("([\\d]*[.])?\\w+[*]([\\d]*[.])?[\\d]+");
        m = pm.matcher(cad);
        while(m.find()) {
            float result = 1;
            m1 = pm1.matcher(m.group().toString());
            while (m1.find()){
                result = result * Float.parseFloat(m1.group());
            }
            cad = cad.replace(m.group(),Float.toString(result));
            m = pm.matcher(cad);
        }

        //Resta
        pm = Pattern.compile("([\\d]*[.])?\\w+[-]([\\d]*[.])?[\\d]+");
        m = pm.matcher(cad);
        while(m.find()) {
            float result = 0;
            int cont = 0;
            m1 = pm1.matcher(m.group().toString());
            while (m1.find()){
                if (cont == 0){
                    result = Float.parseFloat(m1.group());
                    cont++;
                } else{
                    result = result-Float.parseFloat(m1.group());
                }
            }
            if (result >= 0){
                cad = cad.replace(m.group(),Float.toString(result));
                m = pm.matcher(cad);
            }
            else {
                cad = cad.replace(m.group(),"0");
                if (Float.parseFloat(cad) == 0){
                    cad = cad.replace("0",Float.toString(result));
                }else{
                    cad = cad+Float.toString(result);
                    m = pm.matcher(cad);
                }
            }


        }
            //Suma
        pm = Pattern.compile("([\\d]*[.])?\\w+[+]([\\d]*[.])?[\\d]+");
        m = pm.matcher(cad);
        while(m.find()) {
            float result = 0;
            m1 = pm1.matcher(m.group().toString());
            while (m1.find()){
                result = result + Float.parseFloat(m1.group());
            }
            cad = cad.replace(m.group(),Float.toString(result));
            m = pm.matcher(cad);
        }

        return cad;
    }
}
