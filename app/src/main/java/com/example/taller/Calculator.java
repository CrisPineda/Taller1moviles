package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private int number1;

    private int number2;

    private int operacion;

    private TextView mensajeResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        number1 = getIntent().getIntExtra("number1", 0 );

        number2 = getIntent().getIntExtra("number2", 0);

        operacion = getIntent().getIntExtra("operacion", 1);

        mensajeResultado = (TextView)findViewById(R.id.mensajeResultado);

        calculate();
    }

    private void calculate() {

        double resultado;

        resultado = 0.0;

        switch (operacion){

            case 1:

                resultado = number1 + number2;
                break;

            case 2:

                resultado = number1 - number2;
                break;

            case  3:

                resultado = number1 * number2;
                break;

            case 4:

                resultado = (double)(number1 / number2);
                break;

        }

        mensajeResultado.setText( "Resultado : " + resultado );

    }
}
