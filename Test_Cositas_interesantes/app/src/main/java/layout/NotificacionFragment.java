package layout;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import test.pato.test_cositas_interesantes.MainActivity;
import test.pato.test_cositas_interesantes.R;


public class NotificacionFragment extends Fragment implements View.OnClickListener{
    private Button btnNotificacion;
    private int id;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private void init(View v) {
        btnNotificacion = (Button)v.findViewById(R.id.btnNotificacion);
        btnNotificacion.setOnClickListener(this);

        id = 0;
    }


    private OnFragmentInteractionListener mListener;

    public NotificacionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificacionFragment newInstance(String param1, String param2) {
        NotificacionFragment fragment = new NotificacionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notificacion, container, false);

        init(v);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnNotificacion){
            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder)
                            new NotificationCompat.Builder(getContext())
                                    .setSmallIcon(android.R.drawable.stat_notify_more)
                                    .setLargeIcon((((BitmapDrawable)getResources()
                                            .getDrawable(R.drawable.yo)).getBitmap()))
                                    .setContentTitle("Mensaje de Alerta")
                                    .setContentText("Ejemplo de notificación.")
                                    .setContentInfo("4")
                                    /*.setOngoing(true) // Notificación permanente*/
                                    .setAutoCancel(true); // cuando haga click se cierra;

            Intent notIntent =
                    new Intent(getContext(), NotificacionFragment.class);

            PendingIntent contIntent = PendingIntent.getActivity(
                    getContext(), 0, notIntent, 0);

            mBuilder.setContentIntent(contIntent);

            NotificationManager mNotificationManager =
                    (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);


            mNotificationManager.notify(++id, mBuilder.build());
        }
    }
}
