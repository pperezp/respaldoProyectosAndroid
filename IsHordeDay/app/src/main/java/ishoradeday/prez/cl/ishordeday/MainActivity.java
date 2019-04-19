package ishoradeday.prez.cl.ishordeday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtDay;
    private TextView txtHorde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadComponents();
        loadListeners();
        init();
    }

    private void loadListeners() {
        txtDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable e) {
                try {
                    int day = Integer.parseInt(txtDay.getText().toString());

                    while(true){
                        if(day % 7 == 0){
                            break;
                        }else{
                            day++;
                        }
                    }

                    txtHorde.setText(String.valueOf(day));
                }catch(Exception ex){
                    txtHorde.setText("");
                }
            }
        });
    }

    private void init() {
        txtHorde.setText("");
    }

    private void loadComponents() {
        txtDay = (EditText) findViewById(R.id.dayNumber);
        txtHorde = (TextView) findViewById(R.id.horde);
    }
}
