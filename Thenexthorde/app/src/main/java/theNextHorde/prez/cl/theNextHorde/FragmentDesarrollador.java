package theNextHorde.prez.cl.theNextHorde;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by prez on 5/03/17.
 */

public class FragmentDesarrollador extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View miVista = inflater.inflate(R.layout.activity_desarrollador,container,false);
        return miVista;
    }
}
