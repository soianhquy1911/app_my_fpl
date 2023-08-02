package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.Adapter.ThongBaoAdapter;
import com.example.myapplication.DAO.ThongBaoDAO;
import com.example.myapplication.Model.ThongBao;
import com.example.myapplication.Service.ThongBaoService;

import java.util.ArrayList;

public class ThongBaoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ThongBaoActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("GET_ALL_THONG_BAO");
        registerReceiver(myBroadcast, intentFilter);
        Intent intent = new Intent(ThongBaoActivity.this, ThongBaoService.class);
        startService(intent);
    }
    private BroadcastReceiver myBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "GET_ALL_THONG_BAO":
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        Log.i("TAG", "onReceive: sdfsdfsdfsdf");
                        ArrayList<ThongBao> listThongBao =(ArrayList<ThongBao>) bundle.getSerializable("listThongBao");
                        ThongBaoAdapter adapter = new ThongBaoAdapter( ThongBaoActivity.this, listThongBao);
                        recyclerView.setAdapter(adapter);
                    }
                    break;
            }
        }
    };
}