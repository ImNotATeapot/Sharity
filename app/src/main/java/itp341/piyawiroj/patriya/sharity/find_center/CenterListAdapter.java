package itp341.piyawiroj.patriya.sharity.find_center;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import itp341.piyawiroj.patriya.sharity.center_details.CenterDetailActivity;
import itp341.piyawiroj.patriya.sharity.models.DonationCenter;
import itp341.piyawiroj.patriya.sharity.R;

public class CenterListAdapter extends ArrayAdapter<DonationCenter> {

    private static final String TAG = CenterListAdapter.class.getSimpleName();
    private int currentPosition = 0;

    public CenterListAdapter(Context c, int resId, ArrayList<DonationCenter> centers) {
        super(c, resId);
        for (DonationCenter center : centers) {
            add(center);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.find_center_list_item, parent, false);
        }
        currentPosition = position;
        DonationCenter center = getItem(position);

        TextView listName = convertView.findViewById(R.id.listNameTextView);
        TextView addressTextView = convertView.findViewById(R.id.listAddressTextView);
        TextView hoursTextView = convertView.findViewById(R.id.listHoursTextView);
        ImageView imageTextView = convertView.findViewById(R.id.listCenterImageView);

        listName.setText(center.getName());

        Address address = center.getAddress();
        String addressText = String.format("%s, %s, %s, %s",
                address.getAddressLine(0),
                address.getSubAdminArea(),
                address.getAdminArea(),
                address.getPostalCode());
        addressTextView.setText(addressText);

        LinearLayout layout = convertView.findViewById(R.id.center_item);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent centerDetailIntent = new Intent(getContext(), CenterDetailActivity.class);
                centerDetailIntent.putExtra(DonationCenter.EXTRA_POSITION, currentPosition);
                getContext().startActivity(centerDetailIntent);
            }
        });

        //TODO: implement hours
        //TODO: implement image

        return convertView;
    }

}
