package xyz.spiral6.aether.units;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.List;

import xyz.spiral6.aether.R;
import xyz.spiral6.aether.units.data.UnitDatabase;
import xyz.spiral6.aether.units.data.UnitEntity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UnitsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UnitsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnitsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AutoCompleteTextView UnitSearch;
    private UnitDatabase unitDatabase;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public UnitsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UnitsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UnitsFragment newInstance(String param1, String param2) {
        UnitsFragment fragment = new UnitsFragment();
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
        unitDatabase = UnitDatabase.getDatabase(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_units, container, false);
        UnitSearch = (AutoCompleteTextView) view.findViewById(R.id.UnitSearch);
        String[] unitsArray = getUnits();
        ArrayAdapter adapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, unitsArray);
        UnitSearch.setAdapter(adapter);
        UnitSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                InputMethodManager in = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(arg1.getApplicationWindowToken(), 0);
                String name = arg0.getItemAtPosition(arg2).toString();
                loadUnitInfo(name);
            }

        });
        return view;
    }

    private String[] getUnits(){
        List<String> units = unitDatabase.UnitDAO().getUnitList();
        String[] unitsArray = new String[units.size()];
        for(int i = 0; i < unitsArray.length; i++){
            unitsArray[i] = units.get(i);
        }
        return unitsArray;
    }

    private void loadUnitInfo(String DisplayName){
        UnitEntity unit = unitDatabase.UnitDAO().getUnit(DisplayName);

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
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
}
