package clase.cl.test_sqlite_youtube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnCrear;
    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btnCrear = (Button) findViewById(R.id.btnCrear);
        btnListar = (Button) findViewById(R.id.btnListar);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data d = new Data(MainActivity.this);

                // desde la gui
                Cliente c = new Cliente(1, "nombre 1");

                d.crearCliente(c);
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data d = new Data(MainActivity.this);
                List<Cliente> lista = d.getClientes();

                for(Cliente c : lista){
                    Log.v("Cliente:", c.toString());
                }
            }
        });
    }
}
