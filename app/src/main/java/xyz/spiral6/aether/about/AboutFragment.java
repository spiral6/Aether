package xyz.spiral6.aether.about;

import android.app.Fragment;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ru.noties.markwon.Markwon;
import xyz.spiral6.aether.BuildConfig;
import xyz.spiral6.aether.R;

public class AboutFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        TabLayout tabLayout = view.findViewById(R.id.AboutTabLayout);
        TabItem tabAbout = view.findViewById(R.id.tabAbout);
        TabItem tabLicense = view.findViewById(R.id.tabLicense);
        TabItem tabAttribution = view.findViewById(R.id.tabAttribution);

        final ViewPager viewPager = view.findViewById(R.id.AboutViewPager);
        AboutTabPagerAdapter pageAdapter = new AboutTabPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });


        return view;
    }

}
