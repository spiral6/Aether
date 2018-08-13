package xyz.spiral6.aether.units;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import xyz.spiral6.aether.R;
import xyz.spiral6.aether.units.data.UnitEntity;
import xyz.spiral6.aether.units.data.UnitIVs;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnitIVsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnitIVsFragment extends Fragment {
    private UnitEntity unit = new UnitEntity();
    private String rarity = "";
    private String level = "";
    private ArrayList<ArrayList<Integer>> IVTable = new ArrayList<>();


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
            level = getArguments().getString("level");
            UnitIVs IVs = null;


            try {
                IVs = new UnitIVs(getContext(), unit.getName(), rarity);
            }catch (IOException e){
                e.printStackTrace();
            }

            if(level.equals("level1") && (IVs != null)){
                IVTable = IVs.getLevel1IVs();
            }
            else if(level.equals("level40") && (IVs != null)){
                IVTable = IVs.getLevel40IVs();
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit_ivs, container, false);
        if(!(unit.getName() == null)){
            if(!(rarity == null || rarity.equals(""))){

                if(level.equals("level1")){
                    TextView IVLabel = view.findViewById(R.id.IVLabel);
                    IVLabel.setText(getString(R.string.unitivs_level1ivs_label));
                }
                else if(level.equals("level40")){
                    TextView IVLabel = view.findViewById(R.id.IVLabel);
                    IVLabel.setText(getString(R.string.unitivs_level40ivs_label));
                }

                assignIVs(view);

            }
        }

        Switch weaponSwitch = view.findViewById(R.id.WeaponSwitch);
        weaponSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if(isChecked){
                    UnitIVs IVs = null;
                    try {
                        IVs = new UnitIVs(getContext(), unit.getName(), rarity);
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                    if(level.equals("level1")){
                        IVTable = IVs.getLevel1IVsWithWeapon();
                    }
                    else if(level.equals("level40")){
                        IVTable = IVs.getLevel40IVsWithWeapon();
                    }
                    assignIVs(getView());
                }
                else{
                    UnitIVs IVs = null;
                    try {
                        IVs = new UnitIVs(getContext(), unit.getName(), rarity);
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                    if(level.equals("level1")){
                        IVTable = IVs.getLevel1IVs();
                    }
                    else if(level.equals("level40")){
                        IVTable = IVs.getLevel40IVs();
                    }
                    assignIVs(getView());
                }
            }
        });



        // Inflate the layout for this fragment
        return view;
    }

    private void assignIVs(View view){
        TextView minusHP = view.findViewById(R.id.minusHP);
        minusHP.setText("" + IVTable.get(0).get(0));
        TextView minusATK = view.findViewById(R.id.minusATK);
        minusATK.setText("" + IVTable.get(0).get(1));
        TextView minusSPD = view.findViewById(R.id.minusSPD);
        minusSPD.setText("" + IVTable.get(0).get(2));
        TextView minusDEF = view.findViewById(R.id.minusDEF);
        minusDEF.setText("" + IVTable.get(0).get(3));
        TextView minusRES = view.findViewById(R.id.minusRES);
        minusRES.setText("" + IVTable.get(0).get(4));

        TextView neutralHP = view.findViewById(R.id.neutralHP);
        neutralHP.setText("" + IVTable.get(1).get(0));
        TextView neutralATK = view.findViewById(R.id.neutralATK);
        neutralATK.setText("" + IVTable.get(1).get(1));
        TextView neutralSPD = view.findViewById(R.id.neutralSPD);
        neutralSPD.setText("" + IVTable.get(1).get(2));
        TextView neutralDEF = view.findViewById(R.id.neutralDEF);
        neutralDEF.setText("" + IVTable.get(1).get(3));
        TextView neutralRES = view.findViewById(R.id.neutralRES);
        neutralRES.setText("" + IVTable.get(1).get(4));

        TextView plusHP = view.findViewById(R.id.plusHP);
        plusHP.setText("" + IVTable.get(2).get(0));
        TextView plusATK = view.findViewById(R.id.plusATK);
        plusATK.setText("" + IVTable.get(2).get(1));
        TextView plusSPD = view.findViewById(R.id.plusSPD);
        plusSPD.setText("" + IVTable.get(2).get(2));
        TextView plusDEF = view.findViewById(R.id.plusDEF);
        plusDEF.setText("" + IVTable.get(2).get(3));
        TextView plusRES = view.findViewById(R.id.plusRES);
        plusRES.setText("" + IVTable.get(2).get(4));
    }

}
