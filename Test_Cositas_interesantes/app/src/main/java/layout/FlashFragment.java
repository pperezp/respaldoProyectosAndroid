package layout;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import test.pato.test_cositas_interesantes.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FlashFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FlashFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlashFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;



    private Button btnOn;
    private Button btnOff;
    private String mCameraId;
    private CameraManager mCameraManager;

    public FlashFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlashFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlashFragment newInstance(String param1, String param2) {
        FlashFragment fragment = new FlashFragment();
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
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_flash, container, false);

        init_botones(v);


        mCameraManager = (CameraManager) getActivity().getSystemService(Context.CAMERA_SERVICE);

        try {
            mCameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }


        return v;
    }

    private void init_botones(View v) {
        btnOff = (Button)v.findViewById(R.id.btnOff);
        btnOn = (Button)v.findViewById(R.id.btnOn);

        btnOff.setOnClickListener(this);
        btnOn.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnOn){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    mCameraManager.setTorchMode(mCameraId, true);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }else if(view.getId() == R.id.btnOff){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    mCameraManager.setTorchMode(mCameraId, false);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }
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
}
