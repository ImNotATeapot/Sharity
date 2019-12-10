package itp341.piyawiroj.patriya.sharity.choose_donations;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import itp341.piyawiroj.patriya.sharity.R;

public class ChooseDonationsActivity extends AppCompatActivity {

    private static final String TAG = ChooseDonationsActivity.class.getSimpleName();
    public TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tabbed_activity);
        DonationSectionsPagerAdapter sectionsPagerAdapter = new DonationSectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        getSupportActionBar().hide();
        title = findViewById(R.id.title);
        title.setText("Donations");
        ImageButton imageButton= (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
