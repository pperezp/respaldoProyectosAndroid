package clase.cl.test_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {

    private String tCliente =
            "create table cliente("+
                    "id INTEGER primary key AUTOINCREMENT,"+
                    "nombre TEXT" +
                    ")";

    public BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Una vez, cuando la conexión se establece
        // Vamos a crear o ejecutar la creación de tablas
        db.execSQL(tCliente);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Version cambia
        // no hay cambios


    }
}

