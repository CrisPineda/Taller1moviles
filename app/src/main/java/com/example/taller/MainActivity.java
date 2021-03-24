package com.example.taller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText user;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        user = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.password);

    }


    public void sendData( View view ){

        if( validateFields() ){

            Intent intent =  new Intent( this, Menu.class );
            intent.putExtra( "user", user.getText().toString() );
            intent.putExtra( "password", password.getText().toString() );
            startActivity(intent);

        }else{



        }

    }

    private boolean validateFields(){

        if(user.getText().toString().isEmpty()) return false;

        if(password.getText().toString().isEmpty()) return false;

        return true;

    }

    @Override
    public void onBackPressed() {

    }
}
