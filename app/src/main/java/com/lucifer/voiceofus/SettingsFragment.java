package com.lucifer.voiceofus;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {

    private RelativeLayout relativeLayout;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.layout_settings_fragment, container, false);
        DayNightSwitch dayNightButton = rootView.findViewById(R.id.day_night_switch);
        relativeLayout = rootView.findViewById(R.id.root_settings_layout);

        SharedPreferences prefs = getContext().getSharedPreferences("NightMode", MODE_PRIVATE);
        boolean isNight = prefs.getBoolean("isNight", false);

        if(isNight){
            dayNightButton.setIsNight(true);
        }
        else {
            dayNightButton.setIsNight(false);
        }


        dayNightButton.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
                if(isNight){
                    //Function to change color
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                    Toast.makeText(getContext(),"Night Mode On",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = getContext().getSharedPreferences("NightMode", MODE_PRIVATE).edit();
                    editor.putBoolean("isNight", true);
                    editor.apply();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                    Toast.makeText(getContext(),"Night Mode Off",Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = getContext().getSharedPreferences("NightMode", MODE_PRIVATE).edit();
                    editor.putBoolean("isNight", false);
                    editor.apply();
                }
            }
        });

        return rootView;
    }


}
