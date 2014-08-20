package com.example.BottomTabTry;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity implements View.OnClickListener {

    List<LinearLayout> linearLayoutList;

    int colorSelected;

    int colorUnselected;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        initLinearLayoutList();
        setOnClickListener();
        initColor();
    }

    @Override
    public void onClick(View v) {

        for (LinearLayout linearLayout : linearLayoutList) {
            int color = linearLayout.getId() == v.getId() ? colorSelected : colorUnselected;
            ((TextView) linearLayout.getChildAt(0)).setTextColor(color);
            ((TextView) linearLayout.getChildAt(1)).setTextColor(color);
        }
    }

    private void initLinearLayoutList() {

        linearLayoutList = new ArrayList<LinearLayout>();
        linearLayoutList.add((LinearLayout) findViewById(R.id.llHome));
        linearLayoutList.add((LinearLayout) findViewById(R.id.llCalendar));
        linearLayoutList.add((LinearLayout) findViewById(R.id.llPhone));
        linearLayoutList.add((LinearLayout) findViewById(R.id.llMe));
    }

    private void setOnClickListener() {

        for (LinearLayout linearLayout : linearLayoutList) {
            linearLayout.setOnClickListener(this);
        }
    }

    private void initColor() {

        Resources resources = getResources();
        colorSelected = resources.getColor(android.R.color.holo_blue_light);
        colorUnselected = resources.getColor(android.R.color.darker_gray);
    }

}
