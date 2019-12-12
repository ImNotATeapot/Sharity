package itp341.piyawiroj.patriya.sharity.controller;

import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import itp341.piyawiroj.patriya.sharity.R;
import itp341.piyawiroj.patriya.sharity.util.FirebaseUtility;
import itp341.piyawiroj.patriya.sharity.models.DonationCenter;
import itp341.piyawiroj.patriya.sharity.models.DonationCentersSingleton;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;

public class CenterDetailActivity extends AppCompatActivity implements OnSuccessListener<Uri> {

    private static final String TAG = CenterDetailActivity.class.getSimpleName();
    public TextView title;
    private TextView nameTextView;
    private TextView locationTextView;
    private TextView hoursTextView;
    private TextView descriptionTextView;
    private TextView notesTextView;
    private TextView phoneTextView;
    private TextView mailTextView;
    private TextView websiteTextView;
    private TextView statusTextView;
    private TextView openHoursTextView;
    private TextView acceptedItemsTextView;
    private ImageView imageview;
    private String imgurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_center_detail_view);

        //link elements
        nameTextView = findViewById(R.id.detail_name_textView);
        locationTextView = findViewById(R.id.detail_location_textview);
        hoursTextView = findViewById(R.id.detail_hours_textview);
        descriptionTextView = findViewById(R.id.description_textview);
        notesTextView = findViewById(R.id.notes_textview);
        phoneTextView = findViewById(R.id.phoneno_textview);
        mailTextView = findViewById(R.id.mail_textview);
        websiteTextView = findViewById(R.id.website_textview);
        statusTextView = findViewById(R.id.open_status_textView);
        openHoursTextView = findViewById(R.id.opening_hours_textView);
        acceptedItemsTextView = findViewById(R.id.accepted_items_textView);
        imageview = findViewById(R.id.detail_imageview);

        //set elements
        int position = getIntent().getIntExtra(DonationCenter.EXTRA_POSITION,-1);
        DonationCenter center = DonationCentersSingleton.get(getApplicationContext()).getCenter(position);
        Log.d(TAG, "Showing center at location" + position);

        nameTextView.setText(center.getName());
        Address address = center.getAddress();
        String addressText = String.format("%s, %s, %s, %s",
                address.getAddressLine(0),
                address.getSubAdminArea(),
                address.getAdminArea(),
                address.getPostalCode());
        locationTextView.setText(addressText);
        descriptionTextView.setText(center.getDescription());
        notesTextView.setText(center.getNotice());
        phoneTextView.setText(center.getPhoneNumber());
        mailTextView.setText(center.getEmail());
        websiteTextView.setText(center.getWebsite());
        acceptedItemsTextView.setText(center.getAcceptedItemsDetails());
        Log.d(TAG,"Phone number is "+center.getPhoneNumber());

        FirebaseUtility u = new FirebaseUtility(getApplicationContext());
        u.getURi(center.getImageUrl(), this);
    }

    @Override
    public void onSuccess(Uri uri) {
        imgurl = uri.toString();
        Glide.with(this).load(imgurl).into(imageview);
    }
}
