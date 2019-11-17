package itp341.piyawiroj.patriya.sharity.choose_donations_activities;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import itp341.piyawiroj.patriya.sharity.R;

public class ChooseDonationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabbed_activity);
        DonationSectionsPagerAdapter sectionsPagerAdapter = new DonationSectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    private class DonationSectionsPagerAdapter extends FragmentPagerAdapter {

        public DonationSectionsPagerAdapter(FragmentManager fm) {super(fm);}

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    CategoriesFragment tab1 = new CategoriesFragment();
                    return tab1;
                case 1:
                    SearchFragment tab2 = new SearchFragment();
                    return tab2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0:
                    return "Categories";
                case 1:
                    return "Search";
                default:
                    return "";
            }
        }
    }
}
