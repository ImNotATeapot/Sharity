package itp341.piyawiroj.patriya.sharity.center_details;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import itp341.piyawiroj.patriya.sharity.R;

public class CenterDetailActivity extends AppCompatActivity {

    private static final String TAG = CenterDetailActivity.class.getSimpleName();
    public TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_center_detail_view);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setDisplayShowCustomEnabled(true);
//
//        View view = getSupportActionBar().getCustomView();
//        title = view.findViewById(R.id.customBarTitle);
//        title.setText("Center Details");
//        ImageButton imageButton= (ImageButton)view.findViewById(R.id.imageButtonCustom);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });


    }
}
