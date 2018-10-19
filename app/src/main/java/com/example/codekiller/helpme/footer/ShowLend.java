package com.example.codekiller.helpme.footer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.codekiller.helpme.R;

public class ShowLend extends Fragment{
    public ShowLend(){}
    @Override//savedInstanceState--保存上次活动状态
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.showlendthings_layout,container,false);
        return view;
    }

}
/*生命周期public void onAttach(Context context)
public void onCreate(@Nullable Bundle savedInstanceState)
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
public void onActivityCreated(@Nullable Bundle savedInstanceState)
public void onViewStateRestored(@Nullable Bundle savedInstanceState)
public void onStart()
public void onResume()
public void onPause()
public void onStop()
public void onDestroyView()
public void onDestroy()
public void onDetach()
 */
