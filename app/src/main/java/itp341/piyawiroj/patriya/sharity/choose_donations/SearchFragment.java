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

public class SearchFragment extends Fragment implements OnSuccessListener<Uri>, ValueEventListener {

    private static final String TAG = SearchFragment.class.getSimpleName();
    private static String imglnk ;


    @Nullable
    ImageView a;
    DatabaseReference d0;
    DatabaseReference d1;
    DatabaseReference d2;
    StorageReference storageRef;
    String imgurl;

    @Override
    public void onSuccess(Uri uri) {
        imgurl = uri.toString();
        Log.d(TAG, "FOUND URL" + imgurl);
        Glide.with(getContext()).load(imgurl).into(a);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_donations_search, container, false);
        a = v.findViewById(R.id.testTextView);
        d0 = FirebaseDatabase.getInstance().getReference().child("0");
        d1 = FirebaseDatabase.getInstance().getReference().child("1");
        d2 = FirebaseDatabase.getInstance().getReference().child("2");
        d0.addValueEventListener(this);
        d1.addValueEventListener(this);
        d2.addValueEventListener(this);
        return v;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        imglnk = dataSnapshot.child("imageid").getValue().toString();
        Log.d(TAG,"imglnk is: "+imglnk);
        storageRef = FirebaseStorage.getInstance().getReference().child(imglnk);
        storageRef.getDownloadUrl().addOnSuccessListener(this);

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}