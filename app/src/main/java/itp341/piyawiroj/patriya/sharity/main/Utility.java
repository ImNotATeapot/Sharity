package itp341.piyawiroj.patriya.sharity.main;

import android.content.Context;
import android.location.Address;
import android.renderscript.Sampler;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.Locale;

import itp341.piyawiroj.patriya.sharity.models.BusinessHour;
import itp341.piyawiroj.patriya.sharity.models.DonationCenter;
import itp341.piyawiroj.patriya.sharity.models.DonationCentersSingleton;

public class Utility {

    private Context context;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference dbRef = database.getReference();

    Utility(Context context) {
        this.context = context;
    }


    public void getAll() {
        Query query;
//        query = dbRef.orderByChild("description").
//                    equalTo(itemText.getText().toString());

        query = dbRef.orderByKey();
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();


                while (iterator.hasNext()) {
                    DataSnapshot snapshot = (DataSnapshot) iterator.next();
                    DonationCenter center = getCenter(snapshot);
                    DonationCentersSingleton.get(context).addCenter(center);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public DonationCenter getCenter (DataSnapshot snapshot) {

        DonationCenter c = new DonationCenter();

        Address addr = new Address(Locale.US);
        DataSnapshot address = snapshot.child("address");
        addr.setAddressLine(0, address.child("addressLine").getValue().toString());
        addr.setSubAdminArea(address.child("subAdminArea").getValue().toString());
        addr.setAdminArea(address.child("adminArea").getValue().toString());
        addr.setPostalCode(address.child("zipCode").getValue().toString());

        BusinessHour b = new BusinessHour();
        String[] s = new String[2];
        c.setName(snapshot.child("name").getValue().toString());
        //c.setAcceptedItems(snapshot.child("acceptedItem").getValue().toString());
        c.setHours(b);
        c.setNotice(snapshot.child("notice").getValue().toString());
        c.setDescription(snapshot.child("description").getValue().toString());
        c.setAcceptedItems(s);
        c.setNotAcceptedItems(s);
        c.setPhoneNumber(snapshot.child("phoneNumber").getValue().toString());
        c.setEmail(snapshot.child("email").getValue().toString());
        c.setWebsite(snapshot.child("website").getValue().toString());
        c.setInstructions(snapshot.child("instructions").getValue().toString());
        c.setAddress(addr);
        c.setAcceptedItemsDetails(snapshot.child("acceptedItemDetails").getValue().toString());

        return c;
    }
}
