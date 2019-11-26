package itp341.piyawiroj.patriya.sharity.find_center;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import itp341.piyawiroj.patriya.sharity.R;
import itp341.piyawiroj.patriya.sharity.models.DonationCenter;
import itp341.piyawiroj.patriya.sharity.models.DonationCentersSingleton;

public class ListFragment extends Fragment {
    public ListView listView;
    private CenterListAdapter adapter;
    public SearchView searchView;
    public TextView searchTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_center_list, container, false);

        // Connect UI elements
        listView = view.findViewById(R.id.center_list);
        searchView = view.findViewById(R.id.center_search_view);
        searchTextView = view.findViewById(R.id.search_location_textview);

        ArrayList<DonationCenter> centers = DonationCentersSingleton.get(getContext()).getCenters();
        adapter = new CenterListAdapter(getContext(), R.id.center_list, centers);
        listView.setAdapter(adapter);

        return view;
    }
}
