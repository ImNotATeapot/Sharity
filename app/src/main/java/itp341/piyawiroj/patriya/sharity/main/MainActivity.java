package itp341.piyawiroj.patriya.sharity.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.List;
import java.util.Locale;

import itp341.piyawiroj.patriya.sharity.R;
import itp341.piyawiroj.patriya.sharity.choose_donations.ChooseDonationsActivity;
import itp341.piyawiroj.patriya.sharity.models.DonationCenter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button useCurrentLocationButton;
    private Button findCentersNearMeButton;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        searchView = findViewById(R.id.locationSearchView);
        searchView.setQueryHint("Enter a zip code");
        searchView.setIconified(false);
        searchView.clearFocus();
        searchView.getBackground().setLevel(1);

        useCurrentLocationButton = findViewById(R.id.useCurrentLocationButton);
        useCurrentLocationButton.getBackground().setLevel(0);
        useCurrentLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check for permissions
                if ( ContextCompat.checkSelfPermission( getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
                    //request permissions
                    String[] permissionsList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                    requestPermissions(permissionsList, 0);
                } else {
                    Intent i = new Intent(getApplicationContext(), ChooseDonationsActivity.class);
                    LocationManager lm = (LocationManager)getSystemService(getApplicationContext().LOCATION_SERVICE);
                    Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    double longitude = location.getLongitude();
                    double latitude = location.getLatitude();
                    i.putExtra(DonationCenter.EXTRA_LATITUDE, latitude);
                    i.putExtra(DonationCenter.EXTRA_LONGITUDE, longitude);
                    i.putExtra(DonationCenter.EXTRA_LOCATION, "none");
                    startActivity(i);
                }

            }
        });
        findCentersNearMeButton = findViewById(R.id.findCentersButton);
        findCentersNearMeButton.getBackground().setLevel(2);
        findCentersNearMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zip = searchView.getQuery().toString();
                Intent i = new Intent(getApplicationContext(), ChooseDonationsActivity.class);
                i.putExtra(DonationCenter.EXTRA_LOCATION, zip);
                startActivity(i);
            }
        });
    }
}
