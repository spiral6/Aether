package xyz.spiral6.aether.units;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.spiral6.aether.R;
import xyz.spiral6.aether.units.data.UnitEntity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnitIVsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnitIVsFragment extends Fragment {
    private UnitEntity unit = new UnitEntity();
    private String rarity = "";

    public UnitIVsFragment() {
        // Required empty public constructor
    }

    public static UnitIVsFragment newInstance() {
        //Bundle args = new Bundle();
        //fragment.setArguments(args);
        return new UnitIVsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            unit = (UnitEntity) getArguments().getSerializable("unit");
            rarity = getArguments().getString("rarity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit_ivs, container, false);
        if(!(unit.getName() == null)){
            if(!(rarity == null || rarity.equals(""))){
                //TODO: IV instantiation stuff

            }
        }
        // Inflate the layout for this fragment
        return view;
    }

}
