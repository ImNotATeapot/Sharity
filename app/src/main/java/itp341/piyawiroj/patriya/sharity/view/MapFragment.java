package itp341.piyawiroj.patriya.sharity.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import itp341.piyawiroj.patriya.sharity.R;
import itp341.piyawiroj.patriya.sharity.controller.ChooseDonationsActivity;
import itp341.piyawiroj.patriya.sharity.models.DonationCenter;
import itp341.piyawiroj.patriya.sharity.models.DonationCentersSingleton;

public class MapFragment extends Fragment {

    private int REQUEST_CODE = 0;
    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View v = inflater.inflate(R.layout.find_center_map, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                List<DonationCenter> centers = DonationCentersSingleton.get(getContext()).getCenters();

                for (DonationCenter center : centers) {
                    Address a = center.getAddress();
                    String addressString = String.format("%s, %s, %s %s, United States", a.getAddressLine(0),
                            a.getSubAdminArea(),
                            a.getAdminArea(),
                            a.getPostalCode());
                    LatLng latLng = getLocationFromAddress(addressString);

                    MarkerOptions marker = new MarkerOptions().position(latLng).title(center.getName()).snippet(addressString);
                    googleMap.addMarker(marker);
                    // For zooming automatically to the location of the marker
//                    if (latLng != null) {
//                        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(60).build();
//                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                    }
                }

                if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    //request permissions
                    String[] permissionsList = new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION};
                    requestPermissions(permissionsList, 0);
                } else {
                    LocationManager lm = (LocationManager) getActivity().getSystemService(getContext().LOCATION_SERVICE);
                    Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    double longitude = location.getLongitude();
                    double latitude = location.getLatitude();
                    LatLng latLng = new LatLng(latitude, longitude);
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(60).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            }
        });

        // Perform any camera updates here
        return v;
    }

    public LatLng getLocationFromAddress(String strAddress)
    {
        Geocoder coder= new Geocoder(getContext());
        List<Address> address;
        LatLng p1 = null;

        try
        {
            address = coder.getFromLocationName(strAddress, 5);
            if(address==null)
            {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return p1;

    }

}
