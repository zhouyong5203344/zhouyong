package com.feicui.app.news.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment����
 */
public abstract class BaseFragment extends Fragment{
	
	public Activity mActivity;

	/**����fragment*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	 mActivity=getActivity();
    }
    
    /**����fragment����*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	return initView();
    }
    
    /**����Activity�������*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    	initData();
    }
    
    /**��ʼ������*/
    public abstract View initView();
    
    /**��ʼ������*/
    public void initData(){
    	
    }
}
