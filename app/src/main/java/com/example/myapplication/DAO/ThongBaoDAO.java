package com.example.myapplication.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.Database.DpHelper;
import com.example.myapplication.Model.ThongBao;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoDAO {
    private DpHelper dbHelper;
    public ThongBaoDAO(Context context)
    {
        dbHelper = dbHelper.getInstance(context);
    }
    public List<ThongBao> getAll()
    {
        List<ThongBao> list = new ArrayList<>();
        String sql = "SELECT * FROM THONGBAO";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try {
            if(cursor.moveToFirst())
            {
                while(!cursor.isAfterLast())
                {
                    int id = cursor.getInt(0);
                    String title = cursor.getString(1);
                    String content =cursor.getString(2);
                    String date = cursor.getString(3);
                    String time = cursor.getString(4);
                    ThongBao thongBao = new ThongBao(id, title, content, date, time);
                    list.add(thongBao);

                    cursor.moveToNext();
                }
            }

        }catch (Exception e)
        {
            Log.d(">>>>>>>>>>>tag", "getAll" + e.getMessage());
        }finally {
            if(cursor != null && !cursor.isClosed())
            {
                cursor.close();
            }
        }
        return list;
    }
//    public Boolean insert(CanHo canHo)
//    {
//        Boolean result = false;
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.beginTransaction();
//        try {
//            ContentValues values = new ContentValues();
//            values.put("NAME",canHo.getTENCH());
//            values.put("PRICE",canHo.getPrice()+"");
//            long rows = db.insertOrThrow("CANHO", null, values);
//            db.setTransactionSuccessful();
//            result = rows >=1;
//            return result;
//
//        }catch (Exception e)
//        {
//            Log.d("enrol", "insert" + e.getMessage());
//        }finally {
//            db.endTransaction();
//        }
//        return result;
//    }
//
//    public Boolean update(CanHo sach)
//    {
//        Boolean result = false;
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.beginTransaction();
//        try {
//            ContentValues values = new ContentValues();
//            values.put("NAME",sach.getName());
//            values.put("PRICE",sach.getPrice() + "");
//            long rows = db.update("SACH", values, " ID = ? ",
//                    new String[]{String.valueOf(sach.getId())});
//            db.setTransactionSuccessful();
//            result = rows >= 1;
//        }catch (Exception e)
//        {
//            Log.d("enrol", "update" + e.getMessage());
//        }finally {
//            db.endTransaction();
//        }
//        return result;
//    }
//    public Boolean delete(int id)
//    {
//        Boolean result = false;
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.beginTransaction();
//        try {
//            long rows = db.delete("SACH", " ID = ? ", new String[]{String.valueOf(id)});
//            db.setTransactionSuccessful();
//            result = rows >=1;
//            return result;
//
//        }catch (Exception e)
//        {
//            Log.d("enrol", "delete" + e.getMessage());
//        }finally {
//            db.endTransaction();
//        }
//        return result;
//
//    }

}
