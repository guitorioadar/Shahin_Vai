package com.vaidu.shahinvai.ViewContacs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vaidu.shahinvai.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Display extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String SHOW_URL = "http://192.168.75.1/AddNameID/showUser.php";
    public static final String JSON_ARRAY = "result";

    private ListView listView;
    private List<Student> studentList;
    private StudentAdapter adapter;

    private JSONArray jsonArray = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        studentList = new ArrayList<Student>();

        listView = (ListView) findViewById(R.id.listView);

        StringRequest stringRequest = new StringRequest(SHOW_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray(JSON_ARRAY);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                Student student = new Student();
                                student.setId(object.getString(ID));
                                student.setName(object.getString(NAME));
                                studentList.add(student);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter = new StudentAdapter(Display.this, studentList);
                        listView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Display.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
