package xyz.spiral6.aether.about;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class AboutTabPagerAdapter extends FragmentPagerAdapter {
    private int numberOfTabs;

    public AboutTabPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AboutAppFragment();
            case 1:
                return new AboutLicenseFragment();
            case 2:
                return new AboutAttributionFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
