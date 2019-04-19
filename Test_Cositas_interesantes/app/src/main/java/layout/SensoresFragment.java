package layout;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import test.pato.test_cositas_interesantes.R;


public class SensoresFragment extends Fragment implements SensorEventListener {

    private OnFragmentInteractionListener mListener;
    private SensorManager mSensorManager;
    private TextView lblSenPro;
    private TextView lblSenLuz;
    private Sensor mLight;
    private Sensor mProximidad;
    private float max_value;

    public SensoresFragment() {

    }


    public static SensoresFragment newInstance(String param1, String param2) {
        SensoresFragment fragment = new SensoresFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sensores, container, false);

        lblSenLuz = (TextView)v.findViewById(R.id.lblSenLuz);
        lblSenPro = (TextView)v.findViewById(R.id.lblSenPro);

        init_sensores();

        return v;
    }







    private void init_sensores() {
        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        String str = "";

        for(Sensor sen : deviceSensors){
            str += sen.getName() +" - "+sen.getVendor()+" - "+sen.getVersion()+"\n";
        }

        //lblSensores.setText(str);


        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mProximidad = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mProximidad, SensorManager.SENSOR_DELAY_NORMAL);


        max_value = 0;
    }







    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }








    @Override
    public void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mProximidad, SensorManager.SENSOR_DELAY_NORMAL);
        Toast.makeText(getContext(), "ON RESUME", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
        Toast.makeText(getContext(), "ON PAUSE", Toast.LENGTH_LONG).show();
    }









    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }







    /*SensorEventListener*/
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        int tipo = sensor.getType();
        float valor = sensorEvent.values[0];

        String str = "";

        if(tipo == Sensor.TYPE_LIGHT){
            str += "LUZ:"+valor+"\n";

            if(valor > max_value){
                max_value = valor;
            }

            str += max_value +"\n";

            // max = 131.174
            /*
            135000 = 255
            luz    = x

            */

            int valorRGB = (int)((valor * 255) / max_value);


            String hexColor = String.format( "#%02x%02x%02x", valorRGB, valorRGB, valorRGB);

            str += valorRGB+"\n";

            lblSenLuz.setText(str);
            lblSenLuz.setBackgroundColor(Color.parseColor(hexColor));
        }else if(tipo == Sensor.TYPE_PROXIMITY){
            lblSenPro.setText("PROXIMIDAD:"+valor+"\n");
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    /*SensorEventListener*/
}
