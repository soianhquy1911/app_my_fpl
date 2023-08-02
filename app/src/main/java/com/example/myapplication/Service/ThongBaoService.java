package com.example.myapplication.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.myapplication.DAO.ThongBaoDAO;
import com.example.myapplication.Model.ThongBao;

import java.util.ArrayList;

public class ThongBaoService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ThongBaoDAO thongBaoDAO = new ThongBaoDAO(this);
        ArrayList<ThongBao> listThongBao = (ArrayList<ThongBao>) thongBaoDAO.getAll();
        for (int i = 0; i < listThongBao.size(); i++) {
//            Log.i("nnnn", "onStartCommand: " + listThongBao.get(i).get());
//            Log.i("nnnn", "onStartCommand: " + listThongBao.get(i).getSLPHONGNGU());
//            Log.i("nnnn", "onStartCommand: " + listThongBao.get(i).getGIACHOTHUE());
        }
        Intent intent1 = new Intent();
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("listThongBao", listThongBao);
        intent1.putExtras(bundle1);
        intent1.setAction("GET_ALL_THONG_BAO");
        sendBroadcast(intent1);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
