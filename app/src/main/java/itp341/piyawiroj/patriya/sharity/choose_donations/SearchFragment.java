package itp341.piyawiroj.patriya.sharity.choose_donations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import itp341.piyawiroj.patriya.sharity.R;

public class SearchFragment extends Fragment {
    @Nullable

    TextView a;
    DatabaseReference reff;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_donations_search, container, false);
        reff = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("Name").getValue().toString();
                String location = dataSnapshot.child("Location").getValue().toString();
                String print = name+location;
                a.setText(print);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        a = v.findViewById(R.id.testTextView);
        return v;
    }
}