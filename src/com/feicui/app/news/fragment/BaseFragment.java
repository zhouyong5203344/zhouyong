package com.feicui.app.news.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment基类
 */
public abstract class BaseFragment extends Fragment{
	
	public Activity mActivity;

	/**创建fragment*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	 mActivity=getActivity();
    }
    
    /**处理fragment布局*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	return initView();
    }
    
    /**依附Activity创建完成*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	super.onActivityCreated(savedInstanceState);
    	initData();
    }
    
    /**初始化布局*/
    public abstract View initView();
    
    /**初始化数据*/
    public void initData(){
    	
    }
}
