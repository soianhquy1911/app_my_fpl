package com.example.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DpHelper extends SQLiteOpenHelper {
    private static DpHelper instance;
    public static synchronized DpHelper getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new DpHelper(context);
        }
        return instance;
    }
    public DpHelper(@Nullable Context context)
    {
        super(context,"DATABASE_ANDROID_NETWORKING",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sqlThongBao = "Create table if not exists THONGBAO(ID INTEGER primary key autoincrement, TITLE TEXT, CONTENT TEXT, DATE TEXT, TIME TEXT)";
        db.execSQL(sqlThongBao);
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");
        db.execSQL("INSERT INTO THONGBAO(TITLE, CONTENT, DATE, TIME) VALUES('Bạn đã điểm danh thành công môn SYB3012', 'Bạn đã điểm danh thành công môn SYB2012 vào ca 6 ngày 19-17-2023','19-17-2023', '8:11')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        if(i != i1)
        {
            String DThongBao = "Drop table if exists THONGBAO";
            db.execSQL(DThongBao);

        }

    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }
}
