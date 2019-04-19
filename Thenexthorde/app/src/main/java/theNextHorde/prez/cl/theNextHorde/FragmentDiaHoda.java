package theNextHorde.prez.cl.theNextHorde;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by prez on 5/03/17.
 */

public class FragmentDiaHoda extends Fragment{
    private EditText txtDay;
    private TextView txtHorde;
    private View miVista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        miVista = inflater.inflate(R.layout.activity_dia_horda,container,false);

        loadComponents();
        loadListeners();
        init();

        return miVista;
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
                        if(day % 7 == 0){ // si es multiplo de 7
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
        txtDay = (EditText) miVista.findViewById(R.id.dayNumber);
        txtHorde = (TextView) miVista.findViewById(R.id.horde);
    }
}
