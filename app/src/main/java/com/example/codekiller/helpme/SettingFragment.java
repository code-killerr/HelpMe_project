package com.example.codekiller.helpme;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends PreferenceFragment {


    public SettingFragment() {
        // Required empty public constructor
    }
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_setting);
    }


    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        final boolean b = sharedPreferences.getBoolean("isLocked",false);
        final Preference image = findPreference("image_path");
        final Preference isLocked = findPreference("isLocked");
        final Preference password = findPreference("password");
        final Preference safeProblem = findPreference("safe_problem");
        final Preference safeProblemAnswer = findPreference("safe_problem_answer");
    }

}
