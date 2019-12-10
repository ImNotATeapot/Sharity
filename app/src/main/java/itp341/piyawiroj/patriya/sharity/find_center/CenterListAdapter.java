package itp341.piyawiroj.patriya.sharity.find_center;

import android.content.Context;
import android.content.Intent;
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
        DonationCenter center = getItem(position);
        TextView listName = convertView.findViewById(R.id.listNameTextView);
        listName.setText(center.getName());
        TextView address = convertView.findViewById(R.id.listAddressTextView);
        address.setText(center.getAddress().toString());
        TextView hours = convertView.findViewById(R.id.listHoursTextView);
        ImageView image = convertView.findViewById(R.id.listCenterImageView);

        LinearLayout layout = convertView.findViewById(R.id.center_item);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent centerDetailIntent = new Intent(getContext(), CenterDetailActivity.class);
                centerDetailIntent.putExtra(DonationCenter.EXTRA_POSITION, (Integer) view.getTag());
                getContext().startActivity(centerDetailIntent);
            }
        });

        //TODO: implement hours
        //TODO: implement image

        return convertView;
    }
}
