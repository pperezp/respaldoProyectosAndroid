package clase.cl.test_sqlite_youtube;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prez on 16/05/17.
 */

public class BD extends SQLiteOpenHelper{

    private String tCliente = "create table cliente(" +
                                "id INTEGER primary key AUTOINCREMENT," +
                                "nombre TEXT" +
                                ")";

    public BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tCliente);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // no implementado
    }
}
