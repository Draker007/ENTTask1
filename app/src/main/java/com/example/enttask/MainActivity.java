package com.example.enttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    private List<data> data1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(data1);
        recyclerView.setAdapter(adapter);


        GetData service = RetrofitInstance.getRetrofitInstance().create(GetData.class);
        Call<dataList> call = service.getAllData();
        call.enqueue(new Callback<dataList>() {
            @Override
            public void onResponse(Call<dataList> call, Response<dataList> response) {
                dataList body = response.body();
                List<data> data = body.getData();
                data.size();
                data.get(1).getName();
                int s =data.size();
                for (int i = 0 ; i<s;i++){
                    String name = data.get(i).getName();
                    String contact = data.get(i).getContact();
                    data data2 = new data(contact,name);
                    data1.add(data2);
                    recyclerView.setAdapter(adapter);
                    Log.e("hey ", data.get(i).getName());
                }

            }

            @Override
            public void onFailure(Call<dataList> call, Throwable t) {
          //  int i = 1+1;
            }
        });
    }
}
