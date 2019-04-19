package clase.cl.test_sqlite_youtube;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prez on 16/05/17.
 */

public class Data {
    private Context contexto;
    private BD conexion;
    private SQLiteDatabase db;
    private Cursor cursor;

    private final String RUTA_BD =
            Environment.getExternalStorageDirectory().getPath()+"/testBD/clientes.sqlite";

    public Data(Context contexto) {
        this.contexto = contexto;
    }

    public void crearCliente(Cliente c){
        conexion = new BD(contexto, RUTA_BD, null, 1);
        db = conexion.getWritableDatabase();
        String insert = "insert into cliente values(null, '"+c.getNombre()+"')";
        Log.v("INSERT:", insert);
        db.execSQL(insert);
        db.close();
    }

    public List<Cliente> getClientes(){
        List<Cliente> lista = new ArrayList<>();

        Cliente c = null;

        conexion = new BD(contexto, RUTA_BD, null, 1);
        db = conexion.getWritableDatabase();

        String select = "select * from cliente";
        cursor = db.rawQuery(select, null);

        if(cursor.moveToFirst()){
            do{
                // recorriendo la tabla con un cursor.
                c = new Cliente();

                c.setId(cursor.getInt(0));
                c.setNombre(cursor.getString(1));

                lista.add(c);
            }while(cursor.moveToNext());
        }

        return lista;
    }
}
