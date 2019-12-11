package itp341.piyawiroj.patriya.sharity.choose_donations;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.net.URI;

import itp341.piyawiroj.patriya.sharity.R;

public class SearchFragment extends Fragment {

    private static final String TAG = SearchFragment.class.getSimpleName();

    @Nullable
    ImageView a;
    DatabaseReference reff;
    StorageReference storageRef;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_donations_search, container, false);
        reff = FirebaseDatabase.getInstance().getReference().child("0").child("imageid");
        storageRef  = FirebaseStorage.getInstance().getReference().child("DMC.jpeg");

//        final StorageReference pathReference = storageRef.child("DWC.jpeg");
//        storageRef.child("DWC.jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                // Got the download URL for 'users/me/profile.png'
//                Glide.with(getActivity()).load(pathReference).into(a);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle any errors
//            }
//        });
//
//        reff.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String name = dataSnapshot.getValue().toString();
//                //String location = dataSnapshot.child("Location").getValue().toString();
//                //String print = name+location;
//                Glide.with(getActivity()).load(storageRef).into(a);
//                //a.setText(print);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //a = v.findViewById(R.id.testTextView);
        return v;
    }
}