package com.vaidu.shahinvai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vaidu.shahinvai.ViewContacs.Display;


public class MainActivity extends AppCompatActivity {

    private Button btnAddContact;
    private Button btnViewVontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddContact = (Button) findViewById(R.id.addContacts);


        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent i = new Intent(MainActivity.this,AddNewContact.class);
                Intent i = new Intent(getApplicationContext(),AddNewContact.class);
                MainActivity.this.startActivity(i);

            }
        });


        btnViewVontact = (Button) findViewById(R.id.viewContacts);

        btnViewVontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Display.class));
            }
        });


    }


}
