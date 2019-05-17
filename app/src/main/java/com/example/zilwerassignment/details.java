package com.example.zilwerassignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setTitle("Detailed NEWS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressDialog progressDoalog = new ProgressDialog(details.this);
        progressDoalog.setMessage("Loading...");
        progressDoalog.show();

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(" https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonplaceholderapi Jsonplaceholderapi = retrofit.create(jsonplaceholderapi.class);
        Call<Example> call = Jsonplaceholderapi.getposts1();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                ArrayList<Article> photodata = response.body().getArticles();
                progressDoalog.dismiss();
                Intent i = getIntent();
                WebView wb = findViewById(R.id.wb);
                wb.setWebViewClient(new WebViewClient());
                wb.loadUrl(photodata.get(i.getIntExtra("id",1)).getUrl());

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });




    }
}
