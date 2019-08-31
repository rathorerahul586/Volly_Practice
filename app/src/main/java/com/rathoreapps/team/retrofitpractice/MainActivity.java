package com.rathoreapps.team.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Context context;
    String Base_URL = "https://my-json-server.typicode.com/typicode/demo/db";
    List<modelClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);
        context = MainActivity.this;
        loadDatabase();
    }

    private void loadDatabase(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Base_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("posts");
                            list = new ArrayList<>();
                            for (int i = 0; i<jsonArray.length(); i++){
                                JSONObject postObj = jsonArray.getJSONObject(i);
                                String id = postObj.getString("id");
                                String title = postObj.getString("title");
                                modelClass modelClass1 = new modelClass(id,title);
                                list.add(modelClass1);
                            }

                            adapter adapter = new adapter(list);
                            recyclerView.setAdapter(adapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                            recyclerView.setLayoutManager(layoutManager);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                },

                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("", "onErrorResponse: "+error);
            }
        });

        RequestQueue requestQueue =Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
