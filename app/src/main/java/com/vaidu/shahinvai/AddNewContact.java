package com.vaidu.shahinvai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddNewContact extends AppCompatActivity {

    private EditText editTextName, editTextContactNo;
    private Button btnAdd;

    private String URL = "http://192.168.75.1/ShahinVai/addcont.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextContactNo = (EditText) findViewById(R.id.editTextContactNo);

        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = editTextName.getText().toString();
                final String contactNo = editTextContactNo.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(AddNewContact.this, response, Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(AddNewContact.this,MainActivity.class);
                                startActivity(i);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddNewContact.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("name",name);
                        params.put("contactNo",contactNo);

                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(AddNewContact.this);
                requestQueue.add(stringRequest);

            }
        });


    }
}
