package clase.cl.test_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnCrear;
    private Button btnListar;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btnCrear = (Button)findViewById(R.id.btnCrear);
        btnListar = (Button)findViewById(R.id.btnListar);

        data = new Data(MainActivity.this);
    }

    public void crearCliente(View v){
        Toast.makeText(MainActivity.this, "Crear cliente", Toast.LENGTH_SHORT).show();
        data.crearCliente(new Cliente("nombre1"));
    }

    public void listarCliente(View v){
        Toast.makeText(MainActivity.this, "Listar cliente", Toast.LENGTH_SHORT).show();

        List<Cliente> lista = data.getClientes();

        for(Cliente c : lista){
            Log.v("Cliente: ", c.getId()+"-"+c.getNombre());
        }
    }
}
