package xyz.spiral6.aether;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnitDisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnitDisplayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public UnitDisplayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UnitDisplayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UnitDisplayFragment newInstance(String param1, String param2) {
        UnitDisplayFragment fragment = new UnitDisplayFragment();
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
        View view = inflater.inflate(R.layout.fragment_unit_display, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.portraitPager);
        PagerAdapter viewPagerAdapter = new UnitDisplayPortraitPagerAdapter(getContext(), new int[]{R.drawable.fcorrin1,R.drawable.fcorrin2,R.drawable.fcorrin3,R.drawable.fcorrin4});
        viewPager.setAdapter(viewPagerAdapter);
        // Inflate the layout for this fragment
        return view;
    }

}
