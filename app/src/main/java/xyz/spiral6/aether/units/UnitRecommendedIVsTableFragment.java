package xyz.spiral6.aether.units;

import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import xyz.spiral6.aether.R;
import xyz.spiral6.aether.units.data.UnitEntity;
import xyz.spiral6.aether.units.data.UnitIVs;

public class UnitRecommendedIVsTableFragment extends Fragment {

    private UnitEntity unit = new UnitEntity();
    private ArrayList<String> recommendedIVs = new ArrayList<>();

    public UnitRecommendedIVsTableFragment(){

    }

    public static UnitRecommendedIVsTableFragment newInstance() {
        //Bundle args = new Bundle();
        //fragment.setArguments(args);
        return new UnitRecommendedIVsTableFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            unit = (UnitEntity) getArguments().getSerializable("unit");
            UnitIVs IVs = null;

            try {
                IVs = new UnitIVs(getActivity(), unit.getName(), "fivestar");
            }catch (IOException e){
                e.printStackTrace();
            }
            recommendedIVs = IVs.getRecommendedIVs();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit_recommended_ivs, container, false);
        if (!(unit.getName() == null)) {
            assignIVs(view);
        }

        return view;
    }

    private void assignIVs(View view){
        TextView recommendedHP = view.findViewById(R.id.recommendedHP);
        TextView recommendedATK = view.findViewById(R.id.recommendedATK);
        TextView recommendedSPD = view.findViewById(R.id.recommendedSPD);
        TextView recommendedDEF = view.findViewById(R.id.recommendedDEF);
        TextView recommendedRES = view.findViewById(R.id.recommendedRES);

        recommendationChecker(recommendedIVs.get(0),recommendedHP);
        recommendationChecker(recommendedIVs.get(1),recommendedATK);
        recommendationChecker(recommendedIVs.get(2),recommendedSPD);
        recommendationChecker(recommendedIVs.get(3),recommendedDEF);
        recommendationChecker(recommendedIVs.get(4),recommendedRES);
    }

    private void recommendationChecker(String recommendation, TextView view){

        int[] attrs = {R.attr.RedText, R.attr.YellowText,
               R.attr.GreenText};
        Resources.Theme theme = getActivity().getTheme();
        TypedArray ta = theme.obtainStyledAttributes(attrs);

        int[] colors = new int[attrs.length];
        for (int i = 0; i < attrs.length; i++) {
            colors[i] = ta.getResourceId(i, 0);
        }

        ta.recycle();

        if(recommendation.equals("bane")){
            view.setText("-");
            view.setTextColor(getResources().getColor(colors[0]));
        }
        else if(recommendation.equals("neutral")){
            view.setText("~");
            view.setTextColor(getResources().getColor(colors[1]));
        }
        else if(recommendation.equals("boon")){
            view.setText("+");
            view.setTextColor(getResources().getColor(colors[2]));
        }
        else{
            view.setText("");
        }
    }

}
