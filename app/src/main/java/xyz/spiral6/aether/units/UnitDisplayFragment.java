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
            pictureIDs[i] = getResources().getIdentifier(unitName + (i+1), "drawable", getContext().getPackageName());
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
            case "RedBow": return R.drawable.icon_class_red_bow;
            case "RedBreath": return R.drawable.icon_class_red_breath;
            case "Sword": return R.drawable.icon_class_red_sword;
            case "RedTome": return R.drawable.icon_class_red_tome;
            case "GreenBow": return R.drawable.icon_class_green_bow;
            case "GreenBreath": return R.drawable.icon_class_green_breath;
            case "Axe": return R.drawable.icon_class_green_axe;
            case "GreenTome": return R.drawable.icon_class_green_tome;
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
            PagerAdapter viewPagerAdapter = new UnitDisplayPortraitPagerAdapter(getContext(), pictureLoader(unit.getName()));
            viewPager.setAdapter(viewPagerAdapter);

            TextView unitNameLabel = view.findViewById(R.id.unit_search_item_name);
            unitNameLabel.setText(unit.getDisplayName() + " - " + unit.getEpithet());
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
        }
        // Inflate the layout for this fragment
        return view;
    }

}
