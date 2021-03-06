package xyz.spiral6.aether.units;


import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;

import xyz.spiral6.aether.R;
import xyz.spiral6.aether.units.data.UnitEntity;
import xyz.spiral6.aether.units.data.UnitIVs;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnitDisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnitDisplayFragment extends Fragment {
    private UnitEntity unit = new UnitEntity();

    public UnitDisplayFragment() {
        // Required empty public constructor
    }

    public static UnitDisplayFragment newInstance() {
        //Bundle args = new Bundle();
        //fragment.setArguments(args);
        return new UnitDisplayFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            unit = (UnitEntity) getArguments().getSerializable("unit");
        }
    }

    private int[] pictureLoader(String unitName){
        int[] pictureIDs = new int[4];
        for(int i = 0; i < pictureIDs.length; i++){
            pictureIDs[i] = getResources().getIdentifier(unitName + (i+1), "drawable", getActivity().getPackageName());
        }
        return pictureIDs;
    }

    private int getMovementType(String moveType){
        if(moveType == null){
            return android.R.color.transparent;
        }
        switch(moveType){
            case "Armored": return R.drawable.icon_move_armored;
            case "Infantry": return R.drawable.icon_move_infantry;
            case "Flying": return R.drawable.icon_move_flying;
            case "Cavalry": return R.drawable.icon_move_cavalry;
        }
        return 0; //not found
    }

    private int getWeaponType(String weaponType){
        if(weaponType == null){
            return android.R.color.transparent;
        }
        switch(weaponType){
            case "BlueBow": return R.drawable.icon_class_blue_bow;
            case "BlueBreath": return R.drawable.icon_class_blue_breath;
            case "Lance": return R.drawable.icon_class_blue_lance;
            case "BlueTome": return R.drawable.icon_class_blue_tome;
            case "BlueDagger": return R.drawable.icon_class_blue_dagger;
            case "RedBow": return R.drawable.icon_class_red_bow;
            case "RedBreath": return R.drawable.icon_class_red_breath;
            case "Sword": return R.drawable.icon_class_red_sword;
            case "RedTome": return R.drawable.icon_class_red_tome;
            case "RedDagger": return R.drawable.icon_class_red_dagger;
            case "GreenBow": return R.drawable.icon_class_green_bow;
            case "GreenBreath": return R.drawable.icon_class_green_breath;
            case "Axe": return R.drawable.icon_class_green_axe;
            case "GreenTome": return R.drawable.icon_class_green_tome;
            case "GreenDagger": return R.drawable.icon_class_green_dagger;
            case "Bow": return R.drawable.icon_class_colorless_bow;
            case "Breath": return R.drawable.icon_class_colorless_breath;
            case "Dagger": return R.drawable.icon_class_colorless_dagger;
            case "Staff": return R.drawable.icon_class_colorless_staff;
        }
        return 0; //not found
    }

    private int getLegendaryType(String legendaryType){
        if(legendaryType == null){
            return android.R.color.transparent;
        }
        switch(legendaryType){
            case "Fire": return R.drawable.icon_legendary_fire;
            case "Water": return R.drawable.icon_legendary_water;
            case "Wind": return R.drawable.icon_legendary_wind;
            case "Earth": return R.drawable.icon_legendary_earth;
        }
        return 0; //not found
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit_display, container, false);
        ViewPager viewPager = view.findViewById(R.id.portraitPager);
        if(!(unit.getName() == null)){
            PagerAdapter viewPagerAdapter = new UnitDisplayPortraitPagerAdapter(getActivity(), pictureLoader(unit.getName()));
            viewPager.setAdapter(viewPagerAdapter);

            TextView unitNameLabel = view.findViewById(R.id.unit_search_item_name);
            unitNameLabel.setText(unit.getDisplayName() + " - " + unit.getEpithet());
            TextView rarityLabel = view.findViewById(R.id.RarityLabel);
            rarityLabel.setText(unit.getRarity());
            TextView seriesText = view.findViewById(R.id.SeriesText);
            seriesText.setText(unit.getSeries());
            TextView flavorText = view.findViewById(R.id.FlavorText);
            flavorText.setText(unit.getFlavorText());
            ImageView movementType = view.findViewById(R.id.movementType);
            movementType.setImageResource(getMovementType(unit.getMoveType()));
            ImageView weaponType = view.findViewById(R.id.weaponType);
            weaponType.setImageResource(getWeaponType(unit.getWeaponType()));
            ImageView legendaryType = view.findViewById(R.id.legendaryType);
            legendaryType.setImageResource(getLegendaryType(unit.getLegendaryElement()));

            setRarityVisibility(view);
            setDefaultRarityChecked(view, getDefaultRarity());

            Bundle bundle = new Bundle();
            bundle.putString("level","level1");
            bundle.putString("rarity", getDefaultRarity());
            bundle.putSerializable("unit", unit);

            Bundle bundle2 = new Bundle();
            bundle2.putString("level","level40");
            bundle2.putString("rarity", getDefaultRarity());
            bundle2.putSerializable("unit", unit);

            Fragment initialLevel1IVTableFragment = UnitIVsTableFragment.newInstance();
            initialLevel1IVTableFragment.setArguments(bundle);
            Fragment initialLevel40IVTableFragment = UnitIVsTableFragment.newInstance();
            initialLevel40IVTableFragment.setArguments(bundle2);

            getFragmentManager().beginTransaction().replace(R.id.Level1IVsTable, initialLevel1IVTableFragment).commit();
            getFragmentManager().beginTransaction().replace(R.id.Level40IVsTable, initialLevel40IVTableFragment).commit();

            Fragment initialRecommendedIVTableFragment = UnitRecommendedIVsTableFragment.newInstance();
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("unit", unit);
            initialRecommendedIVTableFragment.setArguments(bundle3);
            getFragmentManager().beginTransaction().replace(R.id.RecommendedIVsTable, initialRecommendedIVTableFragment).commit();


        }

        // This will get the radiogroup
        final RadioGroup rGroup = view.findViewById(R.id.IVButtonGroup);
        final FrameLayout oldContainer = view.findViewById(R.id.Level1IVsTable);
        final FrameLayout oldContainer2 = view.findViewById(R.id.Level40IVsTable);
        // This overrides the radiogroup onCheckListener
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked)
                {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();

                    Fragment oldFragment = getFragmentManager().findFragmentById(R.id.Level1IVsTable);
                    Fragment newFragment = UnitIVsTableFragment.newInstance();

                    Fragment oldFragment2 = getFragmentManager().findFragmentById(R.id.Level40IVsTable);
                    Fragment newFragment2 = UnitIVsTableFragment.newInstance();

                    Bundle bundle = new Bundle();
                    bundle.putString("level","level1");
                    bundle.putSerializable("unit", unit);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("level","level40");
                    bundle2.putSerializable("unit", unit);

                    switch(checkedRadioButton.getId()){
                        case R.id.threestarIV: bundle.putString("rarity","threestar"); bundle2.putString("rarity","threestar"); break;
                        case R.id.fourstarIV: bundle.putString("rarity","fourstar"); bundle2.putString("rarity","fourstar"); break;
                        case R.id.fivestarIV: bundle.putString("rarity","fivestar"); bundle2.putString("rarity","fivestar"); break;
                    }

                    newFragment.setArguments(bundle);
                    newFragment2.setArguments(bundle2);
                    ft.remove(oldFragment).remove(oldFragment2);
                    ft.replace(oldContainer.getId(), newFragment).replace(oldContainer2.getId(),newFragment2).commit();
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @SuppressWarnings("PointlessBooleanExpression")
    //Allows explicit comparison for readability
    private void setRarityVisibility(View view){
        boolean[] rarities = new boolean[3];

        try {
            rarities = UnitIVs.getRarities(getActivity(), unit.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(rarities[0] == false){
            RadioButton threestar = view.findViewById(R.id.threestarIV);
            threestar.setVisibility(View.INVISIBLE);
        }
        if(rarities[1] == false){
            RadioButton fourstar = view.findViewById(R.id.fourstarIV);
            fourstar.setVisibility(View.INVISIBLE);
        }
        if(rarities[2] == false){
            RadioButton fivestar = view.findViewById(R.id.fivestarIV);
            fivestar.setVisibility(View.INVISIBLE);
        }
    }

    private String getDefaultRarity(){
        boolean[] rarities = new boolean[3];

        try {
            rarities = UnitIVs.getRarities(getActivity(), unit.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(rarities[0] == false && rarities[1] == false){
            return "fivestar";
        }
        else if(rarities[0] == false){
            return "fourstar";
        }
        else{
            return "threestar";
        }
    }

    private void setDefaultRarityChecked(View view, String rarity){
        RadioButton threestar = view.findViewById(R.id.threestarIV);
        RadioButton fourstar = view.findViewById(R.id.fourstarIV);
        RadioButton fivestar = view.findViewById(R.id.fivestarIV);
        switch(rarity){
            case "threestar":
                              threestar.setChecked(true);
                              break;
            case "fourstar":
                             fourstar.setChecked(true);
                             break;
            case "fivestar":
                             fivestar.setChecked(true);
                             break;
        }
    }

}
