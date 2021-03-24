package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private String user;
    private String password;
    private TextView messageUser;
    private EditText number1;
    private EditText number2;
    private RadioButton sumar;
    private RadioButton restar;
    private RadioButton multiply;
    private RadioButton dividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        user = getIntent().getStringExtra( "user" );
        password = getIntent().getStringExtra( "password" );

        messageUser = (TextView)findViewById(R.id.messageUser);
        messageUser.setText( "Bienvenido "+ user );


        number1 = (EditText)findViewById(R.id.number1);
        number2 = (EditText)findViewById(R.id.number2);

        sumar = (RadioButton)findViewById(R.id.suma);
        restar = (RadioButton)findViewById(R.id.resta);
        multiply = (RadioButton)findViewById(R.id.multiply);
        dividir = (RadioButton)findViewById(R.id.division);

    }


    public void calculate(View view){

        if( validateFields() ){

            int operacion;

            operacion = 1;

            if( restar.isChecked() ) operacion = 2;
            if(multiply.isChecked()) operacion = 3;
            if(dividir.isChecked()) operacion = 4;

            Intent intent =  new Intent( this, Calculator.class );
            intent.putExtra( "number1", Integer.parseInt( number1.getText().toString() ) );
            intent.putExtra( "number2", Integer.parseInt( number2.getText().toString() ) );
            intent.putExtra( "operacion", operacion );
            startActivity(intent);

        }else{



        }

    }


    private boolean validateFields(){

        if(number1.getText().toString().isEmpty()) return false;

        if(number2.getText().toString().isEmpty()) return false;

        return true;

    }
}
