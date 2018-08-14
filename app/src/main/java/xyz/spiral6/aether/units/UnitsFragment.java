package xyz.spiral6.aether.units;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyz.spiral6.aether.R;
import xyz.spiral6.aether.units.data.UnitDatabase;
import xyz.spiral6.aether.units.data.UnitEntity;


public class UnitsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private AutoCompleteTextView UnitSearch;
    private UnitDatabase unitDatabase;

    public UnitsFragment() {
        // Required empty public constructor
    }

    public static UnitsFragment newInstance() {
        UnitsFragment fragment = new UnitsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) { }
        unitDatabase = UnitDatabase.getDatabase(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_units, container, false);
        UnitSearch = view.findViewById(R.id.UnitSearch);

        //getFragmentManager().beginTransaction().replace(R.id.UnitDisplayFragment, UnitDisplayFragment.newInstance(), "Blank Unit").commit();

        String[] unitsArray = getUnits();
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList(unitsArray));

        //ArrayAdapter<String> adapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, unitsArray);
        final ArrayAdapter<String> adapter = new UnitDisplaySearchAdapter(this.getActivity(), android.R.layout.simple_list_item_1, tempList);
        UnitSearch.setAdapter(adapter);
        UnitSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
                //adapter.notifyDataSetChanged();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        UnitSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(arg1.getApplicationWindowToken(), 0);
                String name = arg0.getItemAtPosition(arg2).toString();
                UnitEntity unit = getUnitInfo(name);
                Bundle bundle = new Bundle();
                bundle.putSerializable("unit",unit);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment newFragment = UnitDisplayFragment.newInstance();
                newFragment.setArguments(bundle);
                ft.replace(R.id.UnitDisplayFragment, newFragment).commit();

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

    private UnitEntity getUnitInfo(String DisplayName){
        return unitDatabase.UnitDAO().getUnit(DisplayName);
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
}
