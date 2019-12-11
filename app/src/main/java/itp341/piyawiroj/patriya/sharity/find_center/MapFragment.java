package itp341.piyawiroj.patriya.sharity.find_center;

import android.Manifest;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import itp341.piyawiroj.patriya.sharity.models.DonationCenter;
import itp341.piyawiroj.patriya.sharity.models.DonationCentersSingleton;

public class MapFragment extends Fragment {

    private int REQUEST_CODE = 0;
    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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

//                //request permissions
//                String[] permissionsList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
//                requestPermissions(permissionsList, REQUEST_CODE);
//                // For showing a move to my location button
//                googleMap.setMyLocationEnabled(true);

                //test location
                Address a = new Address(Locale.US);
                a.setAddressLine(0,"442 S. Pedro Street");
                a.setSubAdminArea("Los Angeles");
                a.setAdminArea("CA");
                a.setPostalCode("90013");
                String addressString = String.format("%s, %s, %s %s, United States", a.getAddressLine(0),
                        a.getSubAdminArea(),
                        a.getAdminArea(),
                        a.getPostalCode());
                LatLng latLng = getLocationFromAddress(addressString);


                // For dropping a marker at a point on the Map
                LatLng sydney = new LatLng(34.0224, -118.2851);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
                googleMap.addMarker(new MarkerOptions().position(latLng).title("Women's Center").snippet("Marker Description"));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(30).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
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
