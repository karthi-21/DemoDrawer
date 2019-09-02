package com.lucifer.voiceofus;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vincent.bottomnavigationbar.BottomItem;
import com.vincent.bottomnavigationbar.BottomNavigationBar;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.layout_home_fragment, container, false);

        RelativeLayout relativeLayout = rootView.findViewById(R.id.root_home_layout);

        BottomNavigationBar bnb = rootView.findViewById(R.id.bnb_default);

        BottomItem item = new BottomItem();
        item.setMode(BottomItem.DRAWABLE_MODE);
        item.setText("Camera");
        item.setActiveIconResID(getResources().getIdentifier("ic_action_tick2", "drawable",
                getContext().getApplicationInfo().packageName));
        item.setInactiveIconResID(getResources().getIdentifier("ic_action_tick2", "drawable",
                getContext().getApplicationInfo().packageName));
        item.setActiveTextColor(Color.parseColor("#E64B4E"));
        bnb.addItem(item);

        BottomItem item1 = new BottomItem();
        item1.setMode(BottomItem.DRAWABLE_MODE);
        item1.setText("another");
        item1.setActiveIconResID(getResources().getIdentifier("ic_action_tick2", "drawable",
                getContext().getApplicationInfo().packageName));
        item1.setInactiveIconResID(getResources().getIdentifier("ic_action_tick2", "drawable",
                getContext().getApplicationInfo().packageName));
        item1.setActiveTextColor(Color.parseColor("#E64B4E"));
        bnb.addItem(item1);

        bnb.addOnSelectedListener(new BottomNavigationBar.OnSelectedListener() {
            @Override
            public void OnSelected(int oldPosition, int newPosition) {
                //ToDo: Do anything you want, transforming fragment etc.
            }
        });
        bnb.setSelectedPosition(0); //Set default item
        bnb.initialize();

//        bnb.setBadgeNumber(0,-1);

        return rootView;
    }

}