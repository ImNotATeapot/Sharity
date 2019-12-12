package itp341.piyawiroj.patriya.sharity.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import itp341.piyawiroj.patriya.sharity.R;
import itp341.piyawiroj.patriya.sharity.view.ListFragment;
import itp341.piyawiroj.patriya.sharity.view.MapFragment;

public class FindCenterActivity extends AppCompatActivity {

    private static final String TAG = FindCenterActivity.class.getSimpleName();
    public TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tabbed_activity);
        CenterSectionsPagerAdapter sectionsPagerAdapter = new CenterSectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        getSupportActionBar().hide();
        title = findViewById(R.id.title);
        title.setText("Find a center nearby");
        ImageButton imageButton= (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private class CenterSectionsPagerAdapter extends FragmentPagerAdapter {

        public CenterSectionsPagerAdapter(FragmentManager fm) {super(fm);}

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    ListFragment tab1 = new ListFragment();
                    return tab1;
                case 1:
                    MapFragment tab2 = new MapFragment();
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
                    return "List";
                case 1:
                    return "Map";
                default:
                    return "";
            }
        }
    }
}
