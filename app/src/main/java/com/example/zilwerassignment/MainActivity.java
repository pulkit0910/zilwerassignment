package com.example.zilwerassignment;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressDialog progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading...");
        progressDoalog.show();
        final ArrayList<cardata> arraylist = new ArrayList<cardata>();
        final RecyclerView r1 = findViewById(R.id.r1);
        final LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(" https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonplaceholderapi Jsonplaceholderapi = retrofit.create(jsonplaceholderapi.class);
        Call<Example> call = Jsonplaceholderapi.getposts1();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(!response.isSuccessful()){
                    progressDoalog.dismiss();
                    Toast.makeText(MainActivity.this, "Request UnSuccessful", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDoalog.dismiss();
                ArrayList<Article> photodata = response.body().getArticles();
                for(int i=0 ;i<photodata.size();i++){
                    arraylist.add(new cardata(photodata.get(i).getTitle(), photodata.get(i).getUrlToImage()));

                    //Toast.makeText(MainActivity.this,arraylist.get(i).getR(),Toast.LENGTH_SHORT).show();
                }
                r1.setLayoutManager(manager);
                r1.setAdapter(new adapter(arraylist,getApplicationContext()));

            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
