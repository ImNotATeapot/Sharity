package itp341.piyawiroj.patriya.sharity.choose_donations;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import itp341.piyawiroj.patriya.sharity.R;
import itp341.piyawiroj.patriya.sharity.find_center.FindCenterActivity;

public class CategoriesFragment extends Fragment {

    public Button nextButton;

    //table elements
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;


    public TextView text1;
    public TextView text2;
    public TextView text3;
    public TextView text4;
    public TextView text5;
    public TextView text6;
    public TextView text7;
    public TextView text8;

    private String[] categories;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.choose_donations_categories, container, false);

        //link table elements
        button1 = view.findViewById(R.id.push_button1);
        button2 = view.findViewById(R.id.push_button2);
        button3 = view.findViewById(R.id.push_button3);
        button4 = view.findViewById(R.id.push_button4);
        button5 = view.findViewById(R.id.push_button5);
        button6 = view.findViewById(R.id.push_button6);
        button7 = view.findViewById(R.id.push_button7);
        button8 = view.findViewById(R.id.push_button8);
        text1 = view.findViewById(R.id.push_text1);
        text2 = view.findViewById(R.id.push_text2);
        text3 = view.findViewById(R.id.push_text3);
        text4 = view.findViewById(R.id.push_text4);
        text5 = view.findViewById(R.id.push_text5);
        text6 = view.findViewById(R.id.push_text6);
        text7 = view.findViewById(R.id.push_text7);
        text8 = view.findViewById(R.id.push_text8);

        //group table elements
        categories = getResources().getStringArray(R.array.donation_categories);
        Button[] buttons = {button1,button2,button3,button4,button5,button6,button7,button8};
        TextView[] textViews = {text1,text2,text3,text4,text5,text6,text7,text8};
        int i=0;
        for(Button button:buttons){
            button.getBackground().setLevel(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int level = v.getBackground().getLevel();
                    v.getBackground().setLevel((level+8)%16);
                }
            });
            i++;
        }
        i=0;
        for(TextView text:textViews) {
            text.setText(categories[i]);
            i++;
        }


        nextButton = view.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findCentersIntent = new Intent(getContext(), FindCenterActivity.class);
                startActivity(findCentersIntent);
            }
        });

        return view;
    }
}
